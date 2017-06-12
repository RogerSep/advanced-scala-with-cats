package cats.exercises.typeclasses.printable

import org.scalatest.{FunSuite, Matchers}

/**
  * Created by roger on 6/12/17.
  */
class PrintableSpec extends FunSuite with Matchers {

  final case class Cat(
    name: String,
    age: Int,
    color: String
  )

  val kitty = Cat("Tequila", 4, "blue")

  implicit val cat = new Printable[Cat] {
    import Printable.{ format => fmt }
    import PrintableInstances._

    override def format(value: Cat): String =
      s"${fmt(value.name)} is a ${fmt(value.age)} year-old ${fmt(value.color)} cat."
  }

  test("Cat instance test") {
    Printable.print(kitty)
    Printable.format(kitty) should equal ("Tequila is a 4 year-old blue cat.")
  }

  test("Cat syntax test") {

    import PrintableSyntax._

    kitty.print
    kitty.format should equal ("Tequila is a 4 year-old blue cat.")

  }

}
