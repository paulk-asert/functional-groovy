def greeter = { salutation, adverb, audience ->
    "$salutation $adverb $audience"
}

def aussieGreeter = greeter.curry("G'day")
def worldGreeter = greeter.rcurry("World")
def groovyGreeter = greeter.ncurry(1, "Groovy")

assert 'Hello Amazing Greach' == greeter('Hello', 'Amazing', 'Greach')
assert "G'day Fascinating Madrid" == aussieGreeter('Fascinating', 'Madrid')
assert 'Goodbye Cruel World' == worldGreeter('Goodbye', 'Cruel')
assert 'Party on Groovy Programmers' == groovyGreeter("Party on", 'Programmers')
