def factorial = {
    it <= 1 ? 1G : it * call(it - 1)
}

println factorial(10G)
//println factorial(1000G)
// Caught: java.lang.StackOverflowError
