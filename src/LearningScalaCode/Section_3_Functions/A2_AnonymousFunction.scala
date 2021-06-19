package LearningScalaCode.Section_3_Functions

object A2_AnonymousFunction extends App{
val doubler=new Function1[Int,Int]
  {
    override def apply(x:Int):Int=x*2
  }
  println(doubler(3))

  //Or by Anonymous function
  val doubler1=(x:Int)=>x*2
  //Or
  val doubler2:Int=>Int=x=>x*2//Type specified
  println(doubler(4))
  println(doubler1(4))
  println(doubler2(4))

  //multiple parameters in lambda
  val adder:(Int,Int)=>Int=(a,b)=>a+b

  val justDoSomething:()=>Int=()=>3

  //Careful
  println(justDoSomething)//Function Itself//LearningScalaCode.Section_3_Functions.A2_AnonymousFunction$$$Lambda$8/1792393294@6833ce2c
  println(justDoSomething())//Function call

  //another way of lambda expression
  val stringToInt={
    (str:String)=>Int
      str.toInt
  }

  //Moar Syntactic Sugar-->Careful _ is very contextual
  val niceIncrementer:Int=>Int=_+1//equivalent to (x:Int)=>x+1
  val niceAdder:(Int,Int)=>Int= _ + _//equivalent to (x:Int,y:Int)=>x+y
  println(niceIncrementer(4))
  println(niceAdder(5,6))

val superAdder=(x:Int)=>(y:Int)=>x+y//Curried function syntactic sugar
println(superAdder(4)(5))
}
