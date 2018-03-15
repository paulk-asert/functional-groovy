new GroovyShell().evaluate '''
def factorial = {
    it <= 1 ? 1G : it * factorial(it - 1)
}

println factorial(10G)
'''
// Caught: groovy.lang.MissingMethodException: No signature of method: Factorial0.factorial() is applicable for argument types: (BigInteger) values: [9]
