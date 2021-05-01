package LearningScalaCode.Setion_2_OOP.Exercise



abstract class MyList
{
  /*
  * head==> First Element of List
  * tail==>remainder of list
  * add(int)==>new List with element added
  * toString==> String representation of List*/

  def head:Int
  def tail:MyList
  def isEmpty:Boolean
  def add(element:Int):MyList
  def printElement:String
  //Polymorphic call of print Element
  override def toString:String="[" +printElement+ "]"
}

object Empty extends MyList
{
  override def head: Int =  throw new NoSuchElementException

  override def tail: MyList = throw new NoSuchElementException

  override def isEmpty: Boolean = true

  override def add(element: Int): MyList = ???

  override def printElement: String = ""
}
class NonEmpty(h:Int,t:MyList) extends MyList
{
  override def head: Int =  h

  override def tail: MyList = t

  override def isEmpty: Boolean = false

  override def add(element: Int): NonEmpty = new NonEmpty(element ,this)

  override def printElement: String =
  {
    if(t.isEmpty) ""+ h
    else h + "," +t.printElement
  }

}

object ListTest extends App()
{
  var lst=new NonEmpty(1,new NonEmpty(2,new NonEmpty(3,Empty)))

  println(lst.tail.head)
  lst=lst.add(4)
  println(lst.isEmpty)
  println(lst.tail.head)
  println(lst.toString)
}

