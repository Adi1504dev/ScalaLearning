package LearningScalaCode.Section_2_OOP

object B2_ExceptionHandling extends App {
  val x:String=null
  //println(x.length)//Throw null pointer Exception
  //Throwing Exception
  // val m:String=throw new NullPointerException//It is also expression an return nothing So nothing can be passed to any type
  //variables like String Int Float etc

  //The class can be only be thrown if it is derivative of Throwable
  //Exception and Error are the major throwable subtypes
  //Exception --> wrong with program(like null pointer Exception)
  //Error--> Wrong with System (like Stack overflow Error)--> Memory of System Finished off

  def getInt(withException:Boolean):Int=
    if(withException) throw new RuntimeException("No number for you")
    else 34
val pointerData=try {
   getInt(false)
}
catch
  {
    case e:RuntimeException=>34//println(e.getMessage)//Exceptions are from java family//When is 34 then pointer data is Int as try and
      //catch both are in but when println("<Anything>")//Then pointer data is of type AnyVal
  }
  finally
    {
      //Do not impacts pointer data value or its type
      //optional
      //Should only be used for side effects like logging
      println("Inside Finally")
    }
    println(pointerData)
}
