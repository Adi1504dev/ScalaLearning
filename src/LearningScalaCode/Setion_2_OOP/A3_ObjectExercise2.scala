package LearningScalaCode.Setion_2_OOP

object A3_ObjectExercise2 extends App {
  val c = new counter(235)
  println(c.current_count().value) //235
  println(c.decrement().value) //234
  println(c.increment().value) //236
  println(c.decrement(120).value) //120
  println(c.increment(400).value) //400
}


class counter(val value: Int) {
  def current_count(): counter = new counter(value)

  def decrement(): counter = new counter(value - 1)

  def increment(): counter = new counter(value + 1)

  def decrement(value1: Int): counter = new counter(value1)

  def increment(value1: Int): counter = new counter(value1)
}
