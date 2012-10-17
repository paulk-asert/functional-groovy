public class Main {
  public static void main(String[] args) {
    print(reverse("Hello"))
  }

  public static reverse(arg) {
     return arg.reverse()
  }

  public static print(arg) {
    System.out.println(arg)
  }
}

Main.main()

//def code = { arg -> println "Hello $arg" }
//code('Oslo')

def codeListInG = [{ println it}, { it.reverse()}]
def main(first, second, arg) {
  def third = second >> first
  third(arg)
}
main(codeListInG[0], codeListInG[1], "Hello")
