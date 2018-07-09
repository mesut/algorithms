object ApplesAndOranges {

  // Complete the countApplesAndOranges function below.
  def countApplesAndOranges(houseStartPosition: Int,
                            houseEndPosition: Int,
                            appleTreeLocation: Int,
                            orangeTreeLocation: Int,
                            appleLocations: Array[Int],
                            orangeLocations: Array[Int]) {

    println(appleLocations.filter(location => (location + appleTreeLocation) >= houseStartPosition && (location + appleTreeLocation) <= houseEndPosition).size)
    println(orangeLocations.filter(location => (location + orangeTreeLocation) <= houseEndPosition && (location + orangeTreeLocation) >= houseStartPosition).size)

  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val st = stdin.readLine.split(" ")

    val houseStartPosition = st(0).trim.toInt

    val houseEndPosition = st(1).trim.toInt

    val ab = stdin.readLine.split(" ")

    val appleTreeLocation = ab(0).trim.toInt

    val orangeTreeLocation = ab(1).trim.toInt

    val appleLocations = stdin.readLine.split(" ").map(_.trim.toInt)

    val orangeLocations = stdin.readLine.split(" ").map(_.trim.toInt)
    countApplesAndOranges(houseStartPosition, houseEndPosition, appleTreeLocation, orangeTreeLocation, appleLocations, orangeLocations)
  }

}
