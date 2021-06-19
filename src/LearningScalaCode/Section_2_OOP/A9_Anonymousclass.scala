package LearningScalaCode.Section_2_OOP

object A9_Anonymous_class extends App{
  trait Animal
  {
    def eat:Unit
  }

  val funnyAnimal:Animal=new Animal{
    override def eat: Unit = println("hahahahahaha")
  }
  funnyAnimal.eat
  println(funnyAnimal.getClass)//Anonymous_class$$anon$1

 // for class with parameter
  class Person(name:String)
  {
    def SayHi:Unit=println(s"Hi this ${name} how I can help you")
  }

  val HiAdi=new Person("Aditya"){
    override def SayHi: Unit = println(s"Hi this Aditya how I can help you")
  }
  HiAdi.SayHi


}
