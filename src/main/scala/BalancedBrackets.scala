import scala.collection.mutable.Stack

object BalancedBrackets {

  private val open = List[Char]('{', '(', '[')
  private val close = List[Char]('}', ')', ']')

  def isBalanced(input: String): Unit = {
    var openStack = Stack[Char]()
    var isBalanced = true
    val brackets = input.toCharArray
    if ((brackets.length % 2) != 0) {
      isBalanced = false
    }
    var i = 0
    while (isBalanced && i < brackets.length) {
      if (open.contains(brackets(i))) {
        openStack.push(brackets(i))
      }
      if (openStack.isEmpty) {
        isBalanced = false
      } else {
        if (close.contains(brackets(i))) {
          val bracket = openStack.pop()
          if (
            !(
              (bracket == '{' && brackets(i) == '}') ||
                (bracket == '(' && brackets(i) == ')') ||
                (bracket == '[' && brackets(i) == ']')
              )
          ) {
            isBalanced = false
          }
        }
      }
      i += 1
    }

    if (isBalanced && openStack.isEmpty) println("YES")
    else println("NO")
  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn
    val t = stdin.readLine.trim.toInt
    for (tItr <- 1 to t) {
      isBalanced(stdin.readLine)
    }
  }
}
