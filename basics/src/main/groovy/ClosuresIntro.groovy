def twice = { int num -> num + num }

assert twice(5) == 10
assert twice.call(6) == 12

def twice10 = { -> 2 * 10 }
assert 20 == twice10()

def triple = { arg -> arg * 3 }
assert triple(5) == 15
def alsoTriple = { it * 3 }
assert alsoTriple(6) == 18

// ...

def twiceMethod(int num) { num * 2 }
assert twiceMethod(2) == 4

def alsoTwice = this.&twiceMethod
assert alsoTwice(5) == 10

def callWith5(Closure c) { c(5) }
assert 15 == callWith5(triple)

def applyTwice = {
    arg, Closure c -> c(c(arg)) }
assert 18 == applyTwice(2, triple)

// ...

def quadruple = { arg = 2 ->
    twice(arg) * 2 }
assert quadruple(5) == 20
assert quadruple() == 8

def alsoQuadruple = twice >> twice
assert alsoQuadruple(5) == 20

def forty = quadruple.curry(10)
assert forty() == 40

assert [10, 15, 20] == [twice, triple, quadruple].collect{ it(5) }
assert 45 == [alsoTwice, alsoTriple, alsoQuadruple].sum{ it(5) }

// ...

def THE_ANSWER = 42
def checkAnswer = { int guess ->
    guess == THE_ANSWER }
assert !checkAnswer(21)
assert checkAnswer(twice(21))

import groovy.util.logging.Log

@Log class Quiz {
    private static int THE_ANSWER = 42
    def checkAnswer = { int guess ->
        log.info "Guess was $guess"
        guess == THE_ANSWER
    }
}

def q = new Quiz()
assert !q.checkAnswer(21)
assert q.checkAnswer(42)
