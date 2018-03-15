def s = [2, 5, 3, 2, 0, 2] as Stack
assert s.size() % 2 == 0

def result = []
def lazyPop = { s.pop() }
while(s.size() > 0) {
    result << pow(lazyPop, lazyPop)
}
assert result == [1, 8, 25] & s.size() == 0

def pow(base, exponent) {
//    base() ** exponent()
//    exponent() == 0 ? 1 : base() ** exponent()
//    def e = exponent()
//    e == 0 ? 1 : base() ** e
    def b = base()
    def e = exponent()
    e == 0 ? 1 : b ** e
}
