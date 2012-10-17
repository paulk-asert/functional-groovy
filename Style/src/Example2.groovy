def nums = 4..8
for (int i = 0; i < nums.size(); i++) {
  println "result = ${nums[i] * 10 + 5}"
}
println()

def timesTen = { it * 10 }
def plusFive = { it + 5 }
def print = { println "result = $it" }
for (int i = 0; i < nums.size(); i++) {
  print(plusFive(timesTen(nums[i])))
}
println()

nums.each{ print(plusFive(timesTen(it))) }
println()

def doAll = timesTen >> plusFive >> print
nums.each(doAll)
println()

def times = { a, b -> a * b }
def doAgain = times.curry(10) >> plusFive >> print
nums.each(doAgain)
