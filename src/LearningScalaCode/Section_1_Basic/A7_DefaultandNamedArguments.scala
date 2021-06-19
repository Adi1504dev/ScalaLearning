package LearningScalaCode.Section_1_Basic

object A7_DefaultandNamedArguments extends App {
  def tailFacto(n: Int, acc: Int = 1): Int = //now we do not need to pass tail recursion value
  {
    if (n <= 1) acc
    else tailFacto(n - 1, n * acc)
  }
  //but even if we provide with an argument default value(1) will be replaced with that
  tailFacto(5)

  //Default arguments work fine when default argument is in last
  //what if
  def savePicture(format: String = "jpeg", width: Int, Hieght: Int): Unit =
    println("Picture saved")

  //savepicture(800,600)//do not work bcoz compiler do not understands if 800 is argument for format or anything else
  /*Solution We can name the parameter while passing arguments in the function
  */
  savePicture(width = 800, Hieght = 600) //by this we can pass parameter in any orders


}
