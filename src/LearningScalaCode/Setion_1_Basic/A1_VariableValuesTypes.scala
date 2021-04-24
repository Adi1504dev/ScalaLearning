package LearningScalaCode.Setion_1_Basic

object A1_VariableValuesTypes extends App{

  //Values in Scala

  val x=43
  println(x)

  //x=2//Val are immutable
  /*
  Types are optional compiler can infer types(hover on x and check)
  */

  val str: String="hello"

  val bool: Boolean=true//or false

  val chr: Char='a'

  val lng: Long=33747744433L//use L in last to signify it is long

  val shr: Short=3322

  val flt: Float= 22.3f //use f for float

  val dbl : Double=3.443


  // Variables is scala
  var intvar: Int=90

  intvar=45//Reassignment is possible
  //variable are used as side effect to show what is happening in the code


}
