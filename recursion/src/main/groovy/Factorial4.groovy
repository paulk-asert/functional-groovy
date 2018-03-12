def factorial = { n ->
    def doFact = { n1, acc -> n1 <= 1 ? acc : call(n1 - 1, n1 * acc) }
    doFact(n, 1)
}

println factorial(10G) // => 3628800
//println factorial(1000G)
// Caught: java.lang.StackOverflowError
