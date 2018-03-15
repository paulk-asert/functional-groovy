def x, y, z, arg

def doSomething = {
    // ...
    it = 99 // or it++
//    y = 99 // or y++
//    it.clear()
}

y = 3
//y = [1, 2, 3]
x = y + 1
//x = y.size()
doSomething(y)
z = y + 1               // expect z = x
//z = y.size()
assert x == z
