

object AngryProfessor {

  // Complete the angryProfessor function below.
  def angryProfessor(threshold: Int, studentArriveTimes: Array[Int]): String = {
    val count = studentArriveTimes.filter(time => time >= 0).size
    if (count >= threshold) {
      "NO"
    } else {
      "NO"
    }
  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val testCaseCount = stdin.readLine.trim.toInt

    for (tItr <- 1 to testCaseCount) {
      val studentCountAndThreshold = stdin.readLine.split(" ")

      val studentCount = studentCountAndThreshold(0).trim.toInt

      val threshold = studentCountAndThreshold(1).trim.toInt

      val studentArriveTimes = stdin.readLine.split(" ").map(_.trim.toInt)
      val result = angryProfessor(threshold, studentArriveTimes)

      println(result)
    }

  }

}
