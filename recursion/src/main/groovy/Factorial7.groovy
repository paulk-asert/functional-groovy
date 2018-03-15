def factorial = { n, acc = 1 ->
    n <= 1 ? acc : trampoline(n - 1, n * acc)
}.trampoline()

//println factorial(0G)
//println factorial(1G)
println factorial(4G)//.call()
//println factorial(1000G)
//40238....[total of 2569 digits]...000