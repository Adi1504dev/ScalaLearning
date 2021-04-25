package LearningScalaCode.Setion_1_Basic

import scala.annotation.tailrec

object A5_Recursion extends App{
  def facto(n:Int):Int=
  {
    if(n==1) 1
    else
    {
      println("Computing factorial of "+n+" -I first need factorial of "+(n-1))
      val result=n* facto(n-1)
      println("Computed factorial of "+ n)
      result
    }
  }

  //Stack is used to compute recursive function in above case as it is not tail recursive
  println("Factorial of 5 is==> "+facto(5))
  //println("Factorial of 600 is==> "+facto(6000))// we run out of stack memory error as intermediate results stored in stack
  // but if we use tail recursion we do not use stack rather the last value is replaced.
  // In tail recursion last value is only function call
  // we can assure the tail recursive function bhy using annotation @tailrec


  @tailrec
  def anotherFactorial(n:BigInt, accumulator:BigInt):BigInt=
  {
    if(n<=1) accumulator
    else anotherFactorial(n-1,n*accumulator)//Tail recursion uses recursive call as last expression so no intermediate result is to
    // be stored

  }
  println("Factorial of 5000 by Tail recursion==> "+anotherFactorial(5000,1))


  //Use Tail recursion when you need loops


  //Exercise 1 -->Tail recursion string concatenation
  @tailrec
  def conStr(str:String,n:Int,acc:String):String=
  {
    if(n==0) acc
    else conStr(str,n-1,acc+str)
  }
  println("Concatenate using tail recursion ==>"+conStr("Aditya ",6,""))


  //Exercise 2 --> Tail recursion is prime
  @tailrec
  def isPrime(n:Int,m:Int,acc:Boolean):Boolean=
  {
    if(m==1) acc
    else
    {
      if((n%m)==0) (acc && false)
      else isPrime(n,m-1,acc && true)
    }
  }
  val n:Int=23
  println(n+" is a prime number ==> "+isPrime(n,n-1,true))

  //Exercise 3 Tail recursion
  def Fabbo(n:Int,acc1:Int,acc2:Int): Int =
  {
    if(n==0) acc1
    else if(n==1) acc2
    else Fabbo(n-1,acc2,acc2+acc1)
  }
  val n1=7
  println("Fibonacci of "+n1+" is ==> "+Fabbo(n1,0,1))


}
//0 1 1 2 3 5 8 13 21