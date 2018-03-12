def factorial = { n, acc = 1 ->
    n <= 1 ? acc : call(n - 1, n * acc)
}

println factorial(10G)
//println factorial(1000G)
// Caught: java.lang.StackOverflowError
