new GroovyShell().evaluate '''
import groovy.transform.TailRecursive

@TailRecursive
def factorial(n) {
    n * factorial(n - 1)
}

println factorial(10G)
'''
