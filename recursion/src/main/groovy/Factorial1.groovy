def factorial

factorial = {
    it <= 1 ? 1G : it * factorial(it - 1)
}

println factorial(10G)  // => 3628800
//println factorial(1000G)
// Caught: java.lang.StackOverflowError
