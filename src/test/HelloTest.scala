
import org.scalatest.FunSuite

class HelloTest extends FunSuite {
  test("display 'hello'"){
    assert(Hello.displaySalutation == "Hello Wordl")
  }

}
