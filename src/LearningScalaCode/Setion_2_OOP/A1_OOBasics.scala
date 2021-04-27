package LearningScalaCode.Setion_2_OOP

object OOBasics extends App {
  val person = new Person("Aditya", 25)
  //println(person.age)
  // we can not print age like this they are not class fields
  //The val to do that is use val before age then it will be taken as field
  println(person.age)
  println(person.x)
  person.greet("Shobhita")
  person.greet()

  val person2 = new Person("Shobha")
  println(person2.age)
}

class Person(name: String, val age: Int = 0)
//Constructor-- Default arguments can also be used
//Class parameter is NOT FIELDS {
  //Body
  val x = 3
  println(x + 2) //in java you can do in function only
  //here 5 will be printed every time when class is Instantiated

  def greet(name: String): Unit = println(s"${this.name} says: Hi, $name")

  //Overloading--methods with different parameters
  def greet(): Unit = println(s"Hi ,  I am $name")

  //Overloaded constructors
  def this(name: String) = this(name, 0) //They need to return some other constructor as an output

  def this() = this("Aditya Singh") //can replace the use of default constructors by using default arguments in class
}