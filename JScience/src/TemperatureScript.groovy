@GrabResolver('http://maven.obiba.org/maven2')
@Grab('org.jscience:jscience:4.3.1')
import groovy.transform.TypeChecked
import javax.measure.quantity.*
import org.jscience.physics.amount.Amount

import static javax.measure.unit.SI.*
import static javax.measure.unit.NonSI.*

main()

@TypeChecked
def main() {
  Amount<Temperature> freezingC = Amount.valueOf(0, CELSIUS)
//  Amount<Temperature> boilingF = Amount.valueOf(212, FAHRENHEIT)
  def boilingF = Amount.valueOf(212, FAHRENHEIT)
  printDifference(boilingF, freezingC)
//  Amount<Mass> heavy = Amount.valueOf(100, KILO(GRAM))
  def heavy = Amount.valueOf(100, KILO(GRAM))
  printDifference(heavy, boilingF)
}

def <T> void printDifference(Amount<T> arg1, Amount<T> arg2) {
  println arg1 - arg2
}
