import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.io.Source
object FuturesCreate extends App {
  def getUrlSpec(): Future[List[String]] = Future {
    val url = "http://www.w3.org/non-existent-url-spec.txt"
    val f = Source.fromURL(url)
    try f.getLines.toList finally f.close()
  }
  val urlSpec: Future[List[String]] = getUrlSpec()


  urlSpec.failed foreach{
    case t => println("excepiton"+t.getMessage)
  }

  println("callback registered, continuing with other work")
  Thread.sleep(8000)
  def find(lines: List[String], keyword: String): String = lines.zipWithIndex collect {
    case (line, n) if line.contains(keyword) => (n, line)
  } mkString("\n")

}


