def s1 = new Stack()
assert s1.size() % 2 == 0
[2, 5, 3, 2, 0, 2].each{ s1.push(it) }
def result1 = []
while(s1.size() > 0) {
    result1 << s1.pop() ** s1.pop()
}
assert result1 == [1, 8, 25]
assert s1.size() == 0

def s2 = [2, 5, 3, 2, 0, 2] as Stack
assert s2.size() % 2 == 0
def result2 = []
while(s2.size() > 0) {
    result2 << pow2(s2.pop(), s2.pop())
}
assert result2 == [1, 8, 25]
assert s2.size() == 0

def pow2(base, exponent) { base == 0 ? 1 : base ** exponent }
//def pow2(base, exponent) { base ** exponent }

def s3 = [2, 5, 3, 2, 0, 2]
assert s3.size() % 2 == 0
def result3 = []
def lazyPop = { s3.pop() }
while(s3.size() > 0) {
//  println s3
    result3 << pow3(lazyPop, lazyPop)
}
assert result3 == [1, 8, 25] & s3.size() == 0

def pow3(base, exponent) {
//  base() == 0 ? 1 : base() ** exponent()
////  def b = base()
////  b == 0 ? 1 : b ** exponent()
//////  def e = exponent() // [1, 9, 32]
    def b = base()
    def e = exponent()
    b == 0 ? 1 : b ** e
}

def s4 = [2, 5, 3, 2, 0, 2]
assert s4.size() % 2 == 0
def get = { idx -> s4[idx] }
def baseIndices = s4.indices.findAll{ it % 2 == 0 }.reverse()
//def result4 = baseIndices.collect{ pow4(get(it+1), get(it)) }
def result4 = baseIndices.collect{ pow4(get.curry(it+1), get.curry(it)) }
assert result4 == [1, 8, 25]
def pow4(base, exponent) {
//  base == 0 ? 1 : base ** exponent
//  base() ** exponent()
//  base() == 0 ? 1 : base() ** exponent()
////  def b = base()
////  b == 0 ? 1 : b ** exponent()
//  def e = exponent() // [1, 9, 32]
    def b = base()
    def e = exponent()
    b == 0 ? 1 : b ** e
}
