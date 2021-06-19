package LearningScalaCode.Section_2_OOP

object B1_CaseClasses extends App{
// case classes have predefined implementation of method like equals ,toString, hashcode etc
  case class Person(name:String ,age:Int)
  //1. Class parameters are promoted to fields
  val jim=new Person("Jim",34)
  print(jim.name)

  //2. Sensible toString
  println(jim.toString)//=println(jim)//Syntactic Sugar

  //3. Implementation of Hashcode and toString,equals etc
  val jim2=new Person("Jim",34)
  println(jim==jim2)//Implementation of equals

  //4. Handy Copy Method
  val jim3=jim.copy(age=45)//Can receive different parameter
  println(jim3)

  //5. Have Companion Objects
  val thePerson=Person("jhajhu",32)//Already implemented companion object with apply method to get instances
  println(thePerson)

  //6. They are Serializable

  //7. Case classes has extractor method so can be used in pattern matching

  /*Case Object -- They are same as case class but without companion object as they are there own companion objects*/
  case object India
  {
    def name:String="This is India"
  }
println(India.name)

}
