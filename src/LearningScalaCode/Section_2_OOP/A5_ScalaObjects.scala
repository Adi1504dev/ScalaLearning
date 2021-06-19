package LearningScalaCode.Section_2_OOP

object A5_ScalaObjects //extends App commenting it to show use of main
  //main method can only be created in object as it is static
{
//Scala do not have class level functionality ("static")
object person //type + only instance
{///*static*/ "class" level functionality
  val N_EYES=2
  def canfly: Boolean=true

  //FACTORY METHOD
  def from(mother:String,father:String):person=new person("Aditya")
  //or better implementation by apply
  def apply(mother:String,father:String):person=new person("Aditya")

}

  class person(val name:String)
  {
    // Instance level functionality
    val N_EYES=2
    def canfly: Boolean=false


  }

  /*Classes and objects with same name are called companion one used for class
  * level another used for instance level*/

def main(args:Array[String]) {
  // Object can not have parameters
  println(person.N_EYES)
  println(person.canfly)

  //Object has single Instance
  /*FOR OBJECTS*/
  val mary = person;
  val jhon = person;
  println(mary == jhon)


  /*FOR CLASS(different Instances)*/
  val mary1 = new person("Mary");
  val jhon1 = new person("Jhon");
  println(mary1 == jhon1)

  //data accessed are always from either class instances or singleton object instances
  //Scala is so highly object oriented

  //FACTORY METHODS-They only help to create an object
  val child1 = person.from("Shobha", "Shesh")
  println(child1.name)
  //or better implementation
  val child2 = person("Shobha", "Shesh")
  println(child1.name)

  //Scala Application = Scala object with main method
  //def main(args:Array[String])
  //extends app already have def main method

}

}
