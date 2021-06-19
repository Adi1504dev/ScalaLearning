package LearningScalaCode.Section_1_Basic

object A6_CBNandCBV extends App {
  def calledbyValue(x: Long): Unit = {
    println("By value call==>" + x)
    println("By value call==>" + x)
  }

  def calledbyName(x: => Long): Unit = { //For doing by name => is used
    println("By name call==>" + x)
    println("By name call==>" + x)
  }

  (calledbyValue(System.nanoTime())) //The value of System.nanoTime is calculated first and value calculated is sent to function
  (calledbyName(System.nanoTime())) //Here the expression System.nanoTime is sent to function and hence you see 2 different time


}
