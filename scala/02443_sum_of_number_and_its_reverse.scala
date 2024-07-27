import scala.util.control.Breaks.{break, breakable}
//        Scala
// Time complexity -  O (NlogN)
// Space complexity - O (1)

object SumOfNumberAndItsReverseScala {
  def sumOfNumberAndReverse(num: Int): Boolean = {
    def reverse(x: Int): Int = {
      var result = 0
      var number = x
      while (number > 0) {
        result = result * 10 + number % 10
        number /= 10
      }
      result
    }

    var found = false
    breakable {
      for (x <- 0 to num) {
        if (x + reverse(x) == num) {
          found = true
          break
        }
      }
    }
    found
  }

}