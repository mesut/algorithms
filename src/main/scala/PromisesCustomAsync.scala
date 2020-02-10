import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{Future, Promise}
import scala.util.control.NonFatal

object PromisesCustomAsync extends App {

  def myFuture[T](b: => T): Future[T] = {
    val p = Promise[T]
    global.execute(() => try {
      p.success(b)
    } catch {
      case NonFatal(e) => p.failure(e)
    })
    p.future
  }
  val f = myFuture { "naa" + "na" * 8 + " Katamari Damacy!" }
  f foreach { case text => println(text) }

  Thread.sleep(2000)
}
