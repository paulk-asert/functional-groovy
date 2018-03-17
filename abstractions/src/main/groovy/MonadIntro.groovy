def sine = x -> Math.sin(x)
println sine(0.123)

def cube = x -> x**3
println cube(0.987)

sineCube = sine >> cube
println sineCube(1.22)

def sineDebug = x -> [Math.sin(x), 'sine was called.']
println sineDebug(0.3218)
def cubeDebug = x -> [x**3, 'cube was called.']
println cubeDebug(3)

def sineCubeDebug = sineDebug << cubeDebug
//sineCubeDebug(3) // BOOM!

def composeDebuggable = { f, g ->
    { x ->
        def (y, s) = g(x)
        def (z, t) = f(y)
        [z, s + t]
    }
}
println composeDebuggable(sineDebug, cubeDebug)(3)

def bind = { f ->
    { g, h ->
        def (x, s) = [g, h]
        def (y, t) = f(x)
        [y, s + t]
    }
}

def monadicSineCubeDebug = bind(sineDebug) << bind(cubeDebug)
println monadicSineCubeDebug(3, '')

def unit = x -> [x, '']
println monadicSineCubeDebug(unit(3))

println monadicSineCubeDebug << unit << 3

def round = x -> Math.round(x)
println round(1.23)

roundDebug = x -> unit(round(x))
println roundDebug << 1.23

def lift = f -> unit << f
def roundDebug = lift(round)
println roundDebug(0.9)

def f = bind(roundDebug) << bind(sineDebug)
println f(unit(27))

// inspired by:
// http://blog.klipse.tech/javascript/2016/08/31/monads-javascript.html
