object QuickSort {

  /*
     Best      : nlogn
     Average   : nlogn
     Worst     : n2
     Stable    : Yes
     Method    : Insertion
     tractable

  */




  def main(args: Array[String]): Unit = {
    var array = Array(5, 4, 3, 2, 1)
    sort(array, 0, array.length - 1)
    println(array.mkString("<"))

  }

  def sort(array: Array[Int], low: Int, high: Int): Unit = {
    if (low < high) {
      var pi = partition(array, low, high)
      sort(array, low, pi - 1)
      sort(array, pi + 1, high)
    }
  }

  def partition(array: Array[Int], low: Int, high: Int): Int = {
    var pivot = array(high)
    var i = low - 1 // index of smallere element
    for (j <- low until high) {
      //if current element  is smaller than or equal to pivot
      if (array(j) <= pivot) {
        i = i + 1
        var temp = array(i)
        array(i) = array(j)
        array(j) = temp
      }


    }
    var temp = array(i + 1)
    array(i + 1) = array(high)
    array(high) = temp
    i + 1
  }
}
