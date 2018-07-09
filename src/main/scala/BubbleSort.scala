object BubbleSort {

  /*

  Normal :
    Best      : n2
    Average   : n2
    Worst     : n2
    Stable    : Yes
    Method    : swap
    tractable

  Optimized :
    Best      : n
    Average   : n2
    Worst     : n2
    Stable    : Yes
    Method    : swap
    tractable

 */

  def main(args: Array[String]): Unit = {
    //normalBubbleSort
    optimizedBubbleSort
  }

  def optimizedBubbleSort = {
    var array = Array(1)
    var needSwap = false
    for (i <- 0 until array.length) {

      if (i < array.length - 1 && array(i) > array(i + 1)) {
        needSwap = true
      }

      if (needSwap) {
        for (j <- 0 until array.length - i - 1) {
          if (array(j) > array(j + 1)) {
            var temp = array(j + 1)
            array(j + 1) = array(j)
            array(j) = temp
          }
        }
      }
    }
    print(array.mkString("||"))
  }

  def normalBubbleSort = {
    var array = Array(1, 2, 3)

    for (i <- 0 until array.length) {
      for (j <- 0 until array.length - i - 1) {
        if (array
        (j) > array(j + 1)) {
          var temp = array(j + 1)
          array(j + 1) = array(j)
          array(j) = temp
        }
      }
    }
    print(array.mkString("||"))
  }

}
