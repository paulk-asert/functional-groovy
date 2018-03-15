import fj.F2

import static fj.data.List.list

F2<Integer, Integer, Integer> plus = { Integer a, Integer acc -> a + acc }
def val = list(1, 4, 6, 7).foldRightC(plus, 0)
println val.run()
