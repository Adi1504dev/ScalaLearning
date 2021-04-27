package LearningScalaCode.Setion_2_OOP

import scala.language.postfixOps

object A4_Notations extends App {
  //creating class inside object
  class Person(val name: String, f_movie: String, val age: Int) {
    def likes(movie: String): Boolean = movie == f_movie

    def hangsOut(per: Person): String = s"${this.name} is hanging out with ${per.name}"

    def +(per: Person): String = s"$this.name is hanging out with ${per.name}" //we can create method with name = - + etc
    //defining unary operator for person

    def unary_! : String = s"$name what the heck" // space before the : is very important else compiler will think : is part of name

    def isAlive: Boolean = true

    def apply(): String = "This function can even be called without using its name"

    //Exercise
    /*1.*/ def +(str: String): Person = new Person(s"${this.name}" + " " + s"(${str})", this.f_movie, this.age)

    /*2.*/ def unary_+ : Person = new Person({
      this.name
    }, this.f_movie, this.age + 1)

    /*3.*/
    def learn: String = s"${this.name} learns Scala"

    def learnerScala: String = this learn

    /*4*/
    def apply(n: Int): String = s"${this.name} watched ${this.f_movie} ${n} times"


  }


  val mary = new Person("Aditya", "Avengers", 24)
  println(mary.likes("Avengers"))
  println(mary likes "Avengers") //equivalent-->Methods with single parameter can be= called like this(Infix notation)
  //An example of syntactic sugar
  //Infix Notation
  //Operators in scala
  //+ - / etc all are methods in scala

  val tom = new Person("Tom", "Rock", 27)
  println(tom.hangsOut(mary))
  println(tom hangsOut mary)
  println(tom + mary)
  //All operators are methods
  println(1 + 2)
  println(1.+(2))


  //Prefix notation
  val x = -1
  val y = 1.unary_-
  //Unary operators only works with - + ~ ! operators by default
  println(!mary)


  // Postfix Notation
  println(mary.isAlive) // can be only used with no parameter funtions
  println(mary isAlive) //It needs a import as well

  //apply method
  println(mary.apply()) //When compiler see object being called like a function it looks for apply method in class
  println(mary())


  //Exercises
  println((mary + ("is rockstar")).name)
  println((+mary).age)
  println(mary learnerScala)
  println(mary(3))

}
