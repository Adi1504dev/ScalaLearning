package LearningScalaCode.Section_3_Functions

object A1_WhatIsFunction extends App{
//Dream--> Use Function as First Class element
  //Problem --> We comes from OOPs background
  trait MyFunction[A,B]
  {
    def apply(element:A):B
  }
//We can call double like function
  val doubler=new MyFunction[Int,Int] {
    override def apply(element: Int): Int = element * 2
  }

  println(doubler(2))

  /*Function Types in Scala*/
  // Scala Support Function1,Function2,Function3....Function22 classes with
  // function1--> 1 arg function2--> 2 arg .....Function22-->22 args parameters possible
  val StringToIntConvertor=new Function1[String,Int]
  {
    override def apply(v1: String): Int = v1.toInt
  }
println(StringToIntConvertor("3")+4)

  //Syntactic Sugar
  val adder1: (Int, Int) => Int=new Function2[Int,Int,Int] {
    override def apply(v1: Int, v2: Int): Int = v1+v2
  }

  val concater:(String,String)=>String=new Function2[String,String,String] {
    override def apply(v1: String, v2: String): String = v1.concat(v2)
  }

  println(adder1(4,5))
  println(concater("Aditya ","Singh"))

  //Function1[Int,Function1[Int,Int]]
  val superAdder:(Int=>Function1[Int,Int])=new Function1[Int,Function1[Int,Int]]
  {
    override def apply(x:Int):Function1[Int,Int]=new Function[Int,Int] {
      override def apply(y: Int): Int = x+y
    }
  }

  val sum1=superAdder(4)
  println(sum1(5))
  //or
  println(superAdder(3)(4))//This special function is called curried function
}
