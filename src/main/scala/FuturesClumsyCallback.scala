import java.io._

import org.apache.commons.io.FileUtils._

import scala.collection.convert.decorateAsScala._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.io.Source

object FuturesClumsyCallback extends App {


  def findFiles(patterns: List[String]): List[String] = {
    val root = new File(".")
    for {
      f <- iterateFiles(root, null, true).asScala.toList
      pat <- patterns
      abspat = root.getCanonicalPath + File.separator + pat
      if f.getCanonicalPath.contains(abspat)
    } yield f.getCanonicalPath
  }


  def blacklistFile(name: String): Future[List[String]] = Future {
    val lines = Source.fromFile(name).getLines
    lines.filter(x => !x.startsWith("#") && !x.isEmpty).toList
  }

  def blacklisted(name: String): Future[List[String]] = {
    blacklistFile(name).map(patterns => findFiles(patterns))
  }

  for {
    tet <- blacklisted(".gitignore")
  } yield {
    println(s"matches: ${tet.mkString("\n")}")
  }
  println("hello")
  Thread.sleep(1000)

}
