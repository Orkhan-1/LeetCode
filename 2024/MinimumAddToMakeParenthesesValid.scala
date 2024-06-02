//            Scala
//     Time complexity - O (N)
//     Space complexity - O (1)

object MinimumAddToMakeParenthesesValidScala {
  def minAddToMakeValid(s: String): Int = {
    var openParentheses = 0
    var minAdd = 0

    for (c <- s) {
      if (c == '(') {
        openParentheses += 1
      } else if (c == ')') {
        if (openParentheses == 0) {
          minAdd += 1
        } else {
          openParentheses -= 1
        }
      }
    }

    minAdd + openParentheses
  }
}
