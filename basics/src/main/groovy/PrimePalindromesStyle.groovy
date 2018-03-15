import groovy.transform.CompileStatic

@CompileStatic Number fac(Number n) { n == 1 ? 1G : n * fac(n - 1) }
def nums = 100..200
def isPrime = { Number n -> (fac(n - 1) + 1) % n == 0 }
def isPalindrome = { Number n -> n.toString().reverse() == n.toString() }

//def primes = []
//def palins = []
//def both = []
//for (int i = 0; i < nums.size(); i++) {
//    def n = nums[i]
//    if (isPrime(n)) primes << n
//    if (isPalindrome(n)) palins << n
//    if (isPrime(n) && isPalindrome(n)) both << n
//}
//println primes
//println palins
//println both
//
//def (primes, palins, both) = [[]] * 3
//palins = []
//both = []
//for (int i = 0; i < nums.size(); i++) {
//    def n = nums[i]
//    boolean prime = isPrime(n)
//    boolean palin = isPalindrome(n)
//    if (prime) primes << n
//    if (palin) palins << n
//    if (prime && palin) both << n
//}

//println primes
//println palins
//println both
//
//
//def primes = nums.findAll(isPrime)
//def palins =  nums.findAll(isPalindrome)
////def both = nums.findAll{ n -> isPalindrome(n) && isPrime(n) }
//def both = primes.intersect(palins)
//
//println primes
//println palins
//println both

//import static java.util.stream.Collectors.toList
//import java.util.stream.IntStream
//
//def both = IntStream.rangeClosed(100, 200).boxed().filter(isPrime).filter(isPalindrome).collect(toList())
//println both

def (primes, palins, both) = nums.inject([[], [], []]) { acc, n ->
    def pr = isPrime(n)
    def pa = isPalindrome(n)
    if (pr) acc[0] << n
    if (pa) acc[1] << n
    if (pr && pa) acc[2] << n
    acc
}
println primes
println palins
println both
