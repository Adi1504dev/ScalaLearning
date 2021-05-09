package LearningScalaCode.Setion_2_OOP.Exercise



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
}

object Empty1 extends MyList[Nothing]
{
  override def head: Nothing =  throw new NoSuchElementException//Nothing is proper substitution of any type

  override def tail: MyList[Nothing] = throw new NoSuchElementException

  override def isEmpty: Boolean = true

  override def add[b>:Nothing](element: b): MyList[b] = new NonEmpty[b](element,this)

  override def printElement: String = ""
}
class NonEmpty[+A](h:A,t:MyList[A]) extends MyList[A]
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

}

object ListTest extends App()
{
  var lst=new NonEmpty[Int](1,new NonEmpty(2,new NonEmpty(3,Empty1)))
  var lst1:NonEmpty[Any]=new NonEmpty[String]("Hello",new NonEmpty("Scala",new NonEmpty("2.0",Empty1)))
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
}

