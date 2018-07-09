
object InsertionSort {
  /*
      Best      : n
      Average   : n2
      Worst     : n2
      Stable    : Yes
      Method    : Insertion
      tractable

   */

  def main(args: Array[String]): Unit = {
    var array = Array(5, 4, 3, 2, 1)
    for (i <- 0 to array.length - 1) {
      var key = array(i)
      var j = i - 1
      while (j >= 0 && array(j) > key) {
        array(j + 1) = array(j)
        j = j - 1
      }
      array(j + 1) = key

    }
    print(array.mkString("||"))
  }


}
