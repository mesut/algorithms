

object Staircase {

  private var map = scala.collection.mutable.Map(1 -> 1, 2 -> 2, 3 -> 4)

  // Complete the stepPerms function below.
  def stepPerms(n: Int): Int = {
    if (map.contains(n)) {
      return map.get(n).get
    }
    val step: Int = stepPerms(n - 1) + stepPerms(n - 2) + stepPerms(n - 3)
    map.put(n,step)
    return step
  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn
    val s = stdin.readLine.trim.toInt
    for (sItr <- 1 to s) {
      val n = stdin.readLine.trim.toInt
      val res = stepPerms(n)
      println(res)
    }
  }


}
