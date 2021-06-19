package LearningScalaCode.Section_3_Functions

object A3_HOFAndCurries extends App{

 // val superFunction:(Int,(String, (Int=>Boolean))=>Int)=>(Int=>Int)= ???

//Such Function that take other function as result or take another function as an argument is called HOFs
//Example
  //Function that applies a function n times over a value x
  //nTimes(f,n,x)
  //==>f(f(f(x)))

  val nTimes:(Int=>Int,Int,Int)=>Int=(f,n,x)=>if(n<=0) x else nTimes(f,n-1,f(x))
  val increment:Int=>Int=_+ 1
  println(nTimes(increment,4,5))

  //ntb(f,n)=x=>f(f(f.....(x)))
  //increment10=ntb(incrementer,10)=x=>incrementer(incrementer(incrementer.....(x))))
  //val y=increment10(1)//11
val nTimesBetter:(Int=>Int,Int) =>Int => Int= (f,n)=>if(n<=0) (x:Int)=>x else  (x:Int)=>nTimesBetter(f,n-1)(f(x))
  //See in else part nTimesBetter Returns the function definition that is applied on f(X)
 val t= nTimesBetter(increment,5)
  print(t(4))

}
