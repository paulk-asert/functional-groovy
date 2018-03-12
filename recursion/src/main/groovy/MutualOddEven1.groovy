// https://en.wikipedia.org/wiki/Mutual_recursion
// https://www.slideshare.net/arturoherrero/functional-programming-with-groovy
def odd, even

odd = { n -> n == 0 ? false : even.trampoline(n - 1) }.trampoline()
even = { n -> n == 0 ? true : odd.trampoline(n - 1) }.trampoline()

assert odd(4321) & even(1234)
