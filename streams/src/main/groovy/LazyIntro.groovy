def myList = ['foo', 'bar'] // ...
if (myList != null && myList.size() > 1) {
    myList.remove(0)
}
println myList

def gs1 = "Hello at ${new Date()}"
def gs2 = "Hello at ${ -> new Date()}"
sleep 5000
println gs1
println gs2

@Singleton(lazy = true)
class Universe {
    public int ANSWER = 42
}

assert 42 == Universe.instance.ANSWER
