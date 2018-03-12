def factorial

factorial = { n, acc ->
    n <= 1 ? acc : factorial(n - 1, n * acc)
}

println factorial(10G, 1) // => 3628800
//println factorial(1000G)
// Caught: java.lang.StackOverflowError
