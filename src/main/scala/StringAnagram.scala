

object StringAnagram {

  // Complete the makeAnagram function below.
  def makeAnagram(a: String, b: String): Int = {
    val firstTuple = a.groupBy(x => x).mapValues(x => x.length)
    val secondTuple = b.groupBy(x => x).mapValues(x => x.length)

    var count = 0
    for (firstKey <- firstTuple.keys) {
      if (secondTuple.contains(firstKey)) {
        if (firstTuple(firstKey) > secondTuple(firstKey)) {
          count += firstTuple(firstKey) - secondTuple(firstKey)
        }
      } else {
        count += firstTuple(firstKey)
      }
    }

    for (firstKey <- secondTuple.keys) {
      if (firstTuple.contains(firstKey)) {
        if (secondTuple(firstKey) > firstTuple(firstKey)) {
          count += secondTuple(firstKey) - firstTuple(firstKey)
        }
      } else {
        count += secondTuple(firstKey)
      }
    }
    count
  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val a = stdin.readLine

    val b = stdin.readLine

    println(makeAnagram(a, b))
  }

}
