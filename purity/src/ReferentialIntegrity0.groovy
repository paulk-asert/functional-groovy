def s = [2, 5, 3, 2, 0, 2] as Stack
assert s.size() % 2 == 0
def result = []
while(s.size() > 0) {
    result << pow(s.pop(), s.pop())
}
assert result == [1, 8, 25]
assert s.size() == 0

//def pow(base, exponent) { base ** exponent }
def pow(base, exponent) { exponent == 0 ? 1 : base ** exponent }
