package LearningScalaCode.Section_3_Functions.Exercise2

import LearningScalaCode.Section_3_Functions.Exercise.MyList

abstract class MyList[+A]
{
  /*
  * head==> First Element of List
  * tail==>remainder of list
  * add(int)==>new List with element added
  * toString==> String representation of List*/

  def head:A
  def tail:MyList[A]
  def isEmpty:Boolean
  def add[B>:A](element:B):MyList[B]
  def printElement:String
  //Polymorphic call of print Element
  override def toString:String="[" +printElement+ "]"

  def map[B](transformer:A=>B):MyList[B]
  //A=>MyList[B]
  //A=>Boolean
  //A=>B
  //The above are called higher order function .HOFs are function that takes function as an input or output
  def flatMap[B](transformer: A=>MyList[B]):MyList[B]
  def filter(predicate: A=>Boolean): MyList[A]
  def ++[B>:A](list:MyList[B]):MyList[B]
}

case object Empty1 extends MyList[Nothing]
{
  override def head: Nothing =  throw new NoSuchElementException//Nothing is proper substitution of any type

  override def tail: MyList[Nothing] = throw new NoSuchElementException

  override def isEmpty: Boolean = true

  override def add[b>:Nothing](element: b): MyList[b] = new NonEmpty[b](element,this)

  override def printElement: String = ""

  override def map[B](transformer:Nothing=>B): MyList[B] = Empty1

  override def flatMap[B](transformer: Nothing=>MyList[B]): MyList[B] = Empty1

  override def filter(predicate: Nothing=>Boolean): MyList[Nothing] = Empty1

  override def ++[B >: Nothing](list: MyList[B]): MyList[B] = list
}
case class NonEmpty[+A](h:A,t:MyList[A]) extends MyList[A]
{
  override def head: A =  h

  override def tail: MyList[A] = t

  override def isEmpty: Boolean = false

  override def add[A1>:A](element: A1): NonEmpty[A1] = new NonEmpty(element ,this)

  override def printElement: String =
  {
    if(t.isEmpty) ""+ h
    else h + "," +t.printElement
  }
  /*[1,2,3].map(n*2)
   =new NonEmpty(2,(2,3).map(n*2))
   =new NonEmpty(2,new NonEmpty(4,(3).map(n*2)))
   =new NonEmpty(2,new NonEmpty(4,new NonEmpty(2,Empty1.map(n*2))))
   =new NonEmpty(2,new NonEmpty(4,new NonEmpty(2,Empty1)))
   */

  override def map[B](transformer: A=>B): MyList[B] =
    new NonEmpty[B](transformer(h),t.map(transformer))

  /*
  [1,2].flatmap(n=>[n,n+1])
 =[1,2]++[2].flatmap(n=>[n,n+1])
 =[1,2] ++ [2,3] ++ Empty1.flatmap(n=>[n,n+1])
 =[1,2] ++ [2,3] ++ Empty1
 =[1,2,2,3]
  * */
  override def flatMap[B](transformer: A=>MyList[B]): MyList[B] =
    transformer(h) ++ tail.flatMap(transformer)


  /*
  * [1,2,3].filter(n%2==0)
  * =[2,3].filter(n%2==0)
  * =new NonEmpty(2,[3].filter(n%2==0))
  * =new NonEmpty(2,Empty1.filter(n%2==0))
  * =new NonEmpty(2,Empty1)
   */
  override def filter(predicate: A=>Boolean): MyList[A] =
    if(predicate(h)) new NonEmpty[A](h,t.filter(predicate))
    else t.filter(predicate)

  /*[1,2]++[3,4,5]
  * =new NonEmpty(1 , [2]++[3,4,5])
  * =new NonEmpty(1,new NonEmpty(2,Empty1++[3,4,5]))
  * =new NonEmpty(1,new NonEmpty(2,[3,4,5]))
  * =new NonEmpty(1,new NonEmpty(2,new NonEmpty(3,new NonEmpty(4,new NonEmpty(5,Empty1))))
  * */
  override def ++[B >: A](list: MyList[B]): MyList[B] = new NonEmpty(h,tail++list)
}

object ListTest extends App()
{
  var lst=new NonEmpty[Int](1,new NonEmpty(2,new NonEmpty(3,Empty1)))
  var lst1:NonEmpty[Any]=new NonEmpty[String]("Hello",new NonEmpty("Scala",new NonEmpty("2.0",Empty1)))
  var lst1clone:NonEmpty[Any]=new NonEmpty[String]("Hello",new NonEmpty("Scala",new NonEmpty("2.0",Empty1)))
  var lst1clone2:NonEmpty[Any]=new NonEmpty[String]("Hello",new NonEmpty("Scala",new NonEmpty("2.0",Empty1)))
  println(lst.tail.head)
  lst=lst.add(4)//here it is not possible to supply non Int value as lst is of type NonEmpty[Int]0
  println(lst.isEmpty)
  println(lst.tail.head)
  println(lst.toString)

  println("=================================list of String==========================")
  println(lst1.tail.head)
  lst1=lst1.add(4)//as list is of Any It is possible to give char n or int 4 else it wont have been
  println(lst1.isEmpty)
  println(lst1.tail.head)
  println(lst1.toString)

  println("==========================Advanced Implementation==========================")
  println(lst.filter(elem=>(elem%2)==0))
  println(lst.map(elem=>(elem*2)))//
  println(lst.map((_*2)))//


  println(lst++lst1)

  println(lst.flatMap(new Function[Int,MyList[Int]] {
    override def apply(element: Int): MyList[Int] = new NonEmpty[Int](element,new NonEmpty[Int](element+1,Empty1))
  }))
println("===========================Case Class========================")
  println(lst1clone2==lst1clone)//Implementation of Equals and now our list is serializable
}

