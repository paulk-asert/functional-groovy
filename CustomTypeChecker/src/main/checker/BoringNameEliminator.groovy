package checker

import org.codehaus.groovy.ast.*
import org.codehaus.groovy.control.SourceUnit
import org.codehaus.groovy.transform.stc.*

class BoringNameEliminator extends StaticTypeCheckingVisitor {
  BoringNameEliminator(SourceUnit source, ClassNode cn,
                       TypeCheckerPluginFactory pluginFactory) {
    super(source, cn, pluginFactory)
  }

  final message = "Your method name is boring, I cannot allow it!"

  @Override void visitMethod(MethodNode node) {
    super.visitMethod(node)
    if ("method".equals(node.name) || "bar".equals(node.name)) {
      addStaticTypeError(message, node)
    }
  }
}
