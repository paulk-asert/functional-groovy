@GrabResolver('http://repo.bodar.com/')
@Grab('com.googlecode.totallylazy:totallylazy:808')
import com.googlecode.totallylazy.Predicate
import com.googlecode.totallylazy.Callable1
import com.googlecode.totallylazy.Callable2
import java.util.concurrent.Callable

import static com.googlecode.totallylazy.Sequences.map
import static com.googlecode.totallylazy.Sequences.flatMapConcurrently
import static com.googlecode.totallylazy.numbers.Numbers.fibonacci
import static com.googlecode.totallylazy.numbers.Numbers.powersOf
import static com.googlecode.totallylazy.numbers.Numbers.range
import static com.googlecode.totallylazy.numbers.Numbers.even
import static com.googlecode.totallylazy.numbers.Numbers.add
import static com.googlecode.totallylazy.Iterators.repeat
import static com.googlecode.totallylazy.numbers.Numbers.primes

//println 6..10
//println range(6, 10)
//println range(6, 10).filter({ it % 2 == 0 } as Predicate)
//def isEven = { it % 2 == 0 } as Predicate
//println range(6, 10).filter(isEven)
//println range(6, 10).filter(even)
def p = { Closure c -> c as Predicate }
//println range(6, 10).filter(p{ it % 2 == 0 })

println range(6, 1000000000000).filter(p{ it % 2 == 0 }).drop(1).take(5)
//println range(6, 10, 2).forAll(even)
//println range(6, 10).reduce({ a, b -> a + b } as Callable2 )
//println range(6, 10).foldLeft(0, add)
//println map(range(6, 10),  { it + 100 } as Callable1 )
println flatMapConcurrently(range(6, 10), { println it; it % 2 == 0 ? [it, it+100] : [] } as Callable1 )
//println flatMapConcurrently(range(6, 10), { it % 2 == 0 ? [it, it+100] : [] } as Callable1 )
//println primes().take(10)
//println range(1, 4).cycle().drop(2).take(8)
//int count = 0
//repeat({ "count=${count++}" } as Callable).take(4).each{ println it }
//
//println primes().takeWhile(p{ it < 200 }).dropWhile(p{ it < 100 })
//println primes().takeWhile(p{ it < 200 }).dropWhile(p{ it < 100 }).intersection(powersOf(3).map({ it + 20} as Callable1).takeWhile(p{ it < 200 }).dropWhile(p{ it < 100 }))
