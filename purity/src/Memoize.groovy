import static java.lang.System.currentTimeMillis

def wotd = 'possessionlessness'
println wotd.size()
println wotd.toSet().size()
println wotd.toSet().toList().tail()

//def upper = { c -> sleep 500; c.toUpperCase() }
//def upper = { c -> sleep 500; c.toUpperCase() }.memoize()
// memoizeAtLeast(10) memoizeAtMost(10) memoizeBetween(10, 20)
def upper = { c -> sleep 500; c.toUpperCase() }.memoizeAtMost(5)
def start = currentTimeMillis()
def result = wotd.collect{ upper(it) }
println currentTimeMillis() - start
println result
/* */
