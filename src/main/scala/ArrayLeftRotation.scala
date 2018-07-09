object ArrayLeftRotation {

  // Complete the rotLeft function below.
  def rotLeft(array: Array[Int], rotateCount: Int): Array[Int] = {
    var rotated = Array.ofDim[Int](array.length)
    for (index <- 0 until array.length) {
      var rotatedIndex = index + rotateCount
      if (rotatedIndex == array.length) {
        rotatedIndex = array.length - rotatedIndex
      } else if (rotatedIndex > array.length) {
        rotatedIndex = rotatedIndex - array.length
      }
      rotated(index) = array(rotatedIndex)
    }
    rotated
  }


  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val nd = stdin.readLine.split(" ")

    val rotateCount = nd(1).trim.toInt

    val array = stdin.readLine.split(" ").map(_.trim.toInt)
    val result = rotLeft(array, rotateCount)

    println(result.mkString(" "))

  }

}
