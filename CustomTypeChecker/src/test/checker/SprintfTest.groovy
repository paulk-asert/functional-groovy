package checker

import groovy.transform.stc.StaticTypeCheckingTestCase

class SprintfTest extends StaticTypeCheckingTestCase {
  void testCustomVisitorPass() {
    assertScript '''
        import groovy.transform.TypeChecked
        import checker.SprintfTypeCheckingVisitor

        @TypeChecked(visitor=SprintfTypeCheckingVisitor)
        void main() {
            sprintf('%s will turn %d on %tF', 'John', 21, new Date())
        }
        '''
  }

  void testCustomVisitorFailNumArgs() {
    shouldFailWithMessages '''
      import groovy.transform.TypeChecked
      import checker.SprintfTypeCheckingVisitor

      @TypeChecked(visitor=SprintfTypeCheckingVisitor)
      void main() {
        sprintf('%s will turn %d on %tF', 'John', new Date(), 21, 'foo')
      }
      ''', 'Found 4 parameters for sprintf call with 3 conversion code placeholders in the format string'
  }

  void testCustomVisitorFailArgTypes() {
    shouldFailWithMessages '''
        import groovy.transform.TypeChecked
        import checker.SprintfTypeCheckingVisitor

        @TypeChecked(visitor=SprintfTypeCheckingVisitor)
        void main() {
            sprintf('%s will turn %d on %tF', 'John', new Date(), 21)
        }
        ''',
        "Parameter types didn't match types expected from the format String:",
        "For placeholder 2 [%d] expected 'int' but was 'java.util.Date'",
        "For placeholder 3 [%tF] expected 'java.util.Date' but was 'int'"
  }

  void testCustomVisitorRetainsExistingChecks() {
    shouldFailWithMessages '''
        import groovy.transform.TypeChecked
        import checker.SprintfTypeCheckingVisitor

        @TypeChecked(visitor=SprintfTypeCheckingVisitor)
        void main() {
            Date.parse(21)
        }
        ''', 'Cannot find matching method java.lang.Class#parse(int)'
  }
}