def even
def odd = { n -> n == 0 ? false : even(n - 1) }
even = { n -> n == 0 ? true : odd(n - 1) }

assert odd(21) & even(12)
