def factorial
factorial = { n, acc = 1 ->
    println "$n $acc"
    n <= 1 ? acc : factorial.trampoline(n - 1, n * acc)
}//.trampoline()

println factorial(1G)
println factorial(5G)
println factorial(5G).call()
//println factorial(1000G)
//40238....[total of 2569 digits]...000