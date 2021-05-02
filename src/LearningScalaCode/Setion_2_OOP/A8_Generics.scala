package LearningScalaCode.Setion_2_OOP

object A8_Generics extends App {
 //Generics of class
  class Mylist[+T]
  {
    def add[B >: T](element:B):Mylist[B]= ???
    //Use the type T
  }
  class MyMap[A,B]
//Generics also works in similar ways for traits as well
  val lstInteger=new Mylist[String]
  val lstString=new Mylist[Int]
  val myMap=new MyMap[String,Int]

  object Mylist {
    def empty[A]: Mylist[A] = ???
  }

  val emptylst=Mylist.empty[Int]


  //Variance Problem

  class animal
  class cat extends animal
  class dog extends animal
  class car
  //Covariance
  //1. yes type parameterized class of cat extend Type parameterized class of animals
  class covariant[+A]
  val c:covariant[animal]=new covariant[cat]//but not new covariant[car]
//So as the c is covariant[animal] then we can add any animal to it say dog
//Question if we have say cat list and we add dog to it what world it return ==> It will return list of animal
  
  //2. No
  //Invariance--here ve can not substitute animal with dog or cat
  class invariant[A]
  val i:invariant[animal]=new invariant[animal]//but not new invariant[cat]

//3.
    //Contravariant--opposite to covariance
  class trainer[-A]
  val t:trainer[cat]=new trainer[animal]



  //Bounded types

/*Upper bounded*/
  class cage[A <: animal](animal:A)//Class cage only accepts sub type of animals
  val ca=new cage(new cat)
  //but not  val ca1=new cage(new car)
  // as car is not subtype of animal

  /*lower bounded [A <: animal]  only accepts something that is supertype of animal*/

}



