def sum0(... items) { items.sum() }
def sum1 = { ... items -> items.sum() }
def sum2 = { int... items -> items.sum() }
def sum3 = { int[] items -> items.sum() }
println sum0(1)
println sum1(1, 3)
println sum2(1, 2, 3)
println sum3(1, 2, 3, 4)
