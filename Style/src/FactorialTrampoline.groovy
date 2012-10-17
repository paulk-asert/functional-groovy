def factorial

//factorial = {
//    it <= 1 ? 1G : it * factorial(it - 1)
//}

factorial = { n, acc = 1->
  n <= 1 ? acc : factorial.trampoline(n - 1, n * acc)
}.trampoline()

println factorial(1000G)
