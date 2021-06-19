package LearningScalaCode.Section_2_OOP

object A6_Inherit extends App{
  sealed class Animal
  {
    private def eat=println("nomnom")
    protected def eat1:Unit=println("vokvok")
    def eat2=println("Slurp")
    val nature="Wild"
    val love_man:Boolean=false
  }
  class dog extends Animal{
    eat1//accessible here protected function are accessible inside the class or inside the sub class
    eat2//public--> accessible byh object of parent or child class
    //eat3// private not accessible
  }
  val d=new dog()
  d.eat2//only public is accessible like this

  /*****************Concept of constructors in inheritance**************/
  class Person(name:String,age:Int)
  {
    def this(name:String)=this(name,0)
  }
  class Adult(name:String,age:Int,idCard:String) extends Person(name)// you need to make valid constructor call from parent class
  //or
  class Adult2(name:String,age:Int,idCard:String) extends Person(name,age)

  /*****************Concept of Overiding in inheritance**************/
  class Dog2(override val love_man: Boolean ) extends Animal{//val loves man have been overridden in constructor
    override def eat1: Unit = {
     println("powpow calling parent class eat1")
      super.eat1
    }

    //or
    override def eat2: Unit ={println("chopchop")}
    //same can be done for variables as well
    override val nature="pet"
  }

  //using overridden value of constructor
  val d2=new Dog2(true)
  println(d2.love_man)


  //type substitution {broad:Polymorphism}
  val unknown:Animal=new Dog2(true)
  unknown.eat2//call the latest overridden version--chopchop and not slurp


  //super keyword is used to reference see implementation with Dog2-eat


//preventing override
  /*
  1.final -- any member -- we wont be able to override it
  2.final class(class wont be extended at all) itself
  3.sealed class -- extension of class in this file is valid but in different file it would be invalid

   */

}
