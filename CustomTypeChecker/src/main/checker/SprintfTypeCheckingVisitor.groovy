package checker

import org.codehaus.groovy.ast.ClassHelper
import org.codehaus.groovy.ast.ClassNode
import org.codehaus.groovy.ast.expr.ArgumentListExpression
import org.codehaus.groovy.ast.expr.ConstantExpression
import org.codehaus.groovy.ast.expr.Expression
import org.codehaus.groovy.ast.expr.MethodCallExpression
import org.codehaus.groovy.classgen.asm.InvocationWriter
import org.codehaus.groovy.control.SourceUnit
import org.codehaus.groovy.transform.stc.*

import static org.codehaus.groovy.ast.ClassHelper.STRING_TYPE
import static org.codehaus.groovy.ast.ClassHelper.int_TYPE

class SprintfTypeCheckingVisitor extends StaticTypeCheckingVisitor {
  SprintfTypeCheckingVisitor(SourceUnit source, ClassNode cn, TypeCheckerPluginFactory pluginFactory) {
    super(source, cn, pluginFactory)
  }

  @Override
  void visitMethodCallExpression(MethodCallExpression call) {
    super.visitMethodCallExpression(call)
    final String name = call.methodAsString
    if (name == null || !name.equals("sprintf")) return

    Expression callArguments = call.getArguments()
    ArgumentListExpression argList = InvocationWriter.makeArgumentList(callArguments)
    def formatExpr = argList.getExpression(0)
    if (!(formatExpr instanceof ConstantExpression)) return

    def args = getArgumentTypes(argList).toList().tail()
    def codes = formatExpr.text.replaceAll(/[^%]*%([a-zA-Z]+)/, '_$1').tokenize('_')
    if (args.size() != codes.size()) {
      addStaticTypeError("Found ${args.size()} parameters for sprintf call with ${codes.size()} conversion code placeholders in the format string", argList)
      return
    }
    def codeTypes = codes.collect { code ->
      switch (code) {
        case 's': return STRING_TYPE
        case 'd': return int_TYPE
        case 'tF': return ClassHelper.make(Date)
        default: return null
      }
    }
    if (codeTypes != args) {
      addStaticTypeError("Parameter types didn't match types expected from the format String: ", argList)
      (0..<args.size()).findAll { args[it] != codeTypes[it] }.each { n ->
        String msg = "For placeholder ${n + 1} [%${codes[n]}] expected '${codeTypes[n].toString(false)}' but was '${args[n].toString(false)}'"
        addStaticTypeError(msg, argList.getExpression(n + 1))
      }
    }
  }
}
