def wotd = 'possessionlessness'
println wotd.size()
println wotd.toSet().size()

def upper = { c -> sleep 500; c.toUpperCase() }
timedWotd(wotd, upper)
timedWotd(wotd, upper.memoize())
// also memoizeAtLeast(5), memoizeBetween(5, 10)
timedWotd(wotd, upper.memoizeAtMost(5))

private void timedWotd(String wotd, upper) {
    def start = System.currentTimeMillis()
    def result = wotd.collect { upper(it) }
    def time = System.currentTimeMillis() - start
    assert result == ['P', 'O', 'S', 'S', 'E', 'S', 'S', 'I','O',
                      'N', 'L', 'E', 'S', 'S', 'N', 'E', 'S', 'S']
    println time
}

//18
//7
//9014
//3504
//4505
