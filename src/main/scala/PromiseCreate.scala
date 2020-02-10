import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Promise
object PromiseCreate extends App {

  val p = Promise[String]
  val q = Promise[String]

  p.future foreach {
    case x=> {
      println(s"${Thread.currentThread().getName}  p succeeded with '$x'")

    }
  }

  q.future.failed foreach { case t => {
    Thread.sleep(1000)
    println(s" ${Thread.currentThread().getName} q failed with $t")

  } }

  Thread.sleep(1000)

  p success "assigned"

  q failure new Exception("not kept")


  Thread.sleep(7000)

}
