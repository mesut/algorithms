
object InsertionSor extends App {
  /*
      Best      : n
      Average   : n2
      Worst     : n2
      Stable    : Yes
      Method    : Insertion
      tractable

   */
  val list = Array(31, 41, 59, 26, 41,58)

  for (i <- 1 until list.length) {
    val key = list(i)
    var j = i - 1
    while (j >= 0 && list(j) > key) {
      list(j + 1) = list(j)
      j = j - 1
      println("---")
      list.foreach(print)
    }
    list(j + 1) = key
    println("---")
    list.foreach(print)
  }

  list.foreach(print)
}
