object SelectionSort {

  /*
    Best      : n2
    Average   : n2
    Worst     : n2
    Stable    : No
    Method    : Selection
    tractable

 */

  def main(args: Array[String]): Unit = {

    var array = Array(1, 2, 3, 4)
    var targetIndex = 0
    for (i <- 0 until array.length) {
      targetIndex = i
      for (j <- i until array.length) {
        if (array(targetIndex) > array(j)) {
          targetIndex = j
        }
      }
      var temp = array(targetIndex)
      array(targetIndex) = array(i)
      array(i) = temp
    }
    print(array.mkString("<"))
  }
}
