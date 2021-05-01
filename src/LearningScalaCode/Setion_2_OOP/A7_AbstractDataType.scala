package LearningScalaCode.Setion_2_OOP

object A7_AbstractDataType extends App{
//abstract--Classes which contains unimplemented Fields or methods are called abstract classes
  abstract class Animal(val ear:Int)
  {
    val creatureType:String
    def eat:Unit
    def walk=println("fast")//can have non abstract methods as well
  }
  //abstract classes could not be instantiated
  class Dog extends Animal(4)
  {
    override val creatureType: String = "k9"
    override def eat=println("chapchap")
  }

  val d:Dog=new Dog
  d.walk

  //trait created by keyword traits
  trait carnivore
  {
    def eat(animal:Animal):Unit
    def walk1=println("fast")
  }
   trait coldblooded

  class crocodile extends Animal(4) with carnivore with coldblooded// can implement multiple traits
  {
    val creatureType:String="croc"
    def eat:Unit=println("nomnom")
    def eat(animal:Animal):Unit=println(s"I am crocodile and I'm eating ${animal.creatureType}")



  }

  val croc=new crocodile
  croc.eat


  // Traits vs abstract class
  /*
  * 1. Traits do not have constructor parameters
  * 2. Multiple traits can be inherited in same class
  * 3. traits = behaviour
  * */
}
