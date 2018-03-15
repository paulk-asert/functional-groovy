import groovy.transform.Memoized

@Memoized
int sum(int n1, int n2) {
    println "DEBUG: $n1 + $n2 = ${n1 + n2}"
    n1 + n2
}

2.times {
    [[1, 10], [2, 20]].each { a, b ->
        println sum(a, b)
    }
}
