package checker

import groovy.transform.stc.StaticTypeCheckingTestCase

class BoringNameTest extends StaticTypeCheckingTestCase {
  void testGoodName() {
    assertScript '''
        import groovy.transform.TypeChecked
        import checker.BoringNameEliminator

        @TypeChecked(visitor=BoringNameEliminator)
        class Foo {
            int method1() { 1 }
        }
        assert new Foo().method1() == 1
        '''
  }

  void testBadName() {
    shouldFailWithMessages '''
        import groovy.transform.TypeChecked
        import checker.BoringNameEliminator

        @TypeChecked(visitor=BoringNameEliminator)
        class Foo {
            int method() { 1 }
        }
      ''', '[Static type checking] - Your method name is boring, I cannot allow it!'
  }
}