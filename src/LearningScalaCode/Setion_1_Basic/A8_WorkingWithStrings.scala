package LearningScalaCode.Setion_1_Basic

object A8_WorkingWithStrings extends App {
  val str1 =
    """Hi This is Aditya and
      |I am writing the string is in multiple lines
      |using the 3"
      |""".stripMargin
  println(str1)
  val str: String = "Hello I am learning Scala"
  //Java String Funtion
  println("charAt Function==>" + str.charAt(2))
  println("Substring Function==> " + str.substring(7, 11))
  println("Split Function==> " + str.split(" ").toList)
  println("StartWith Function==> " + str.startsWith("Hello"))
  println("Replacement Function==> " + str.replace(" ", " "))
  println("Change case Function==>" + str.toUpperCase())
  println("Length Function==> " + str.length)

  //Scala Specific Functions
  val aNumberString = "45"
  println("Convert to number==> " + aNumberString.toInt)
  println("Reverse the String==> " + str.reverse)
  println("Take first 2 character==> " + str.take(2))

  //Scala String Interpolation

  //S-Interpolation
  val name = "Aditya"
  val age = 25
  val greeting = s"Hello my name is $name and my age is $age"
  println(greeting)
  //It could also perform calculation
  val anotherGreeting = s"Hi, My name is $name and I will be turning ${age + 1} this is year" //Like a code block
  println(anotherGreeting)


  //F-Interpolation
  // Can be used to provide float precision
  val speed = 18.5
  val myth = f"My name is $name and I can run at speed of $speed%2.2f" //2.2--> atleast 2 character and 2 decimals
  println(myth) //here 18.50 is printed as 2 decimal place is define in interpolation
  //It could aldo perform type check
  val data = 1.1f
  //val str4=f"$data%3d"  //Argument float can not be used with int as 3d represents int here


  //Raw Interpolator
  println(raw"This is a \n String")
  // Although if value is injected as a variable then there wont be any impact
  val str5 = "This is a \n String"
  println(raw"$str5")
}

