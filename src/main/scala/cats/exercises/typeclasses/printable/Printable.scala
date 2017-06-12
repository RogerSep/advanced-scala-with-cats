package cats.exercises.typeclasses.printable

/**
  * Created by roger on 6/12/17.
  */

trait Printable[A] {
  def format(value: A): String
}

object PritableInstances {

  implicit val str = new Printable[String] {
    override def format(value: String): String = value
  }

  implicit val int = new Printable[Int] {
    override def format(value: Int): String = value.toString
  }

}

object Printable {

  def format[A](value: A)(implicit p: Printable[A]): String = p.format(value)

  def print[A](value: A)(implicit p: Printable[A]): Unit = println(format(value))

}