def s = [2, 5, 3, 2, 0, 2] as Stack
assert s.size() % 2 == 0
def get = { idx -> s[idx] }
def baseIndices = s.indices.findAll{ it % 2 == 0 }.reverse()
//def result = baseIndices.collect{ pow(get(it+1), get(it)) }
def result = baseIndices.collect{ pow(get.curry(it+1), get.curry(it)) }
assert result == [1, 8, 25]
def pow(base, exponent) {
//  base == 0 ? 1 : base ** exponent
//  base() ** exponent()
    exponent() == 0 ? 1 : base() ** exponent()
////  def b = base()
////  b == 0 ? 1 : b ** exponent()
//  def e = exponent() // [1, 9, 32]
//    def b = base()
//    def e = exponent()
//    e == 0 ? 1 : b ** e
}
