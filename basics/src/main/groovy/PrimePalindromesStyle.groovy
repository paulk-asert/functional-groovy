import java.util.function.Predicate
import java.util.stream.Collectors
import java.util.stream.IntStream

@groovy.transform.CompileStatic Number fac(Number n) { n == 1 ? 1G : n * fac(n - 1) }

def nums = 100..200
def isPrime = { Number n -> (fac(n - 1) + 1) % n == 0 }
def isPalindrome = { Number n -> n.toString().reverse() == n.toString() }

def primes = []
def palins = []
def both = []
//for (int i = 0; i < nums.size(); i++) {
//  def n = nums[i]
//  if (isPrime(n)) primes << n
//  if (isPalindrome(n)) palins << n
//  if (isPrime(n) && isPalindrome(n)) both << n
//}
//println primes
//println palins
//println both
//
//primes = []
//palins = []
//both = []
//for (int i = 0; i < nums.size(); i++) {
//  def n = nums[i]
//  boolean prime = isPrime(n)
//  boolean palin = isPalindrome(n)
//  if (prime) primes << n
//  if (palin) palins << n
//  if (prime && palin) both << n
//}
//println primes
//println palins
//println both
//
//println primes.intersect(palins)
//
println nums.findAll(isPrime)
println nums.findAll(isPalindrome)
println nums.findAll{ n -> isPalindrome(n) && isPrime(n) }

println IntStream.rangeClosed(100, 200).boxed().filter(isPrime).filter(isPalindrome).collect(Collectors.toList())
