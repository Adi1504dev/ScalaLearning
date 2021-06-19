package LearningScalaCode.Section_2_OOP

object A8_Generics extends App {
 //Generics of class
  class MyList[+A]
  {
   //def add(a:A):MyList[A]= ???//Covariant type A occurs in contravariant position in type A of value a
   def add[A1>:A](a:A1):MyList[A1]= ???
   //use this Type A
  }
  class MyMap[key,value]
 //Same can be used for traits as well

 val lstInteger=new MyList[Int]
 val lstString=new MyList[String]

 //generic Methods
 object MyList
 {
   def empty[A]: MyList[A]= null
 }

  val emptyListofInteger=MyList.empty[Int]

 //Invariance
 class Animal
 {
  def printer:Unit=println("I am animal")
 }
 class Dog extends Animal
 {
  override def printer:Unit=println("I am animal Dog")
  def dogprinter():Unit=println("I am native to dog class")
 }
 class Cat extends Animal
 {
  override def printer:Unit=println("I am animal cat")
  def Catprinter:Unit=println("I am native to cat class")
 }

 println("===================Invariance=======================")
 //Invariance
 class invar[A]
 {
  def objret(a:A)=a
 }

 val cat1=new Cat
 val dog1=new Dog
 val animal1=new Animal
 val inc:invar[Cat]=new invar[Cat]
 //inc.objret(animal1).printer//error as invariance
 //inc.objret(dog1).printer //required cat given dog
 print("1.")
 inc.objret(cat1).Catprinter


 println("\n\n\n===================Covariance=======================")
 //Covariance
 class covar[+A]
 {
  def objret[A1>:A](a:A1)=a
 }
 val covar:covar[Animal]=new covar[Cat]

 print("1.")
 covar.objret(cat1).printer
 //covar.objret(cat1).Catprinter//It will only be animal object
 print("2.")
 covar.objret(animal1).printer
 print("3.")
 covar.objret(dog1).printer//Important It can also take object of dog but important is that it only call the the override func
 //And it takes dog as dog is also animal


 println("\n\n\n===================Contravariance=======================")
 //contravariance
 class contravar[-A]
 {
  def objret[A1<:A](a:A1)=a
 }


 val contra:contravar[Cat]=new contravar[Animal]
 //contra.objret(dog1).printer// The function takes dog instance as an argument ans as per func(A1<:A) A1-->Cat A--> Dog A is not superclass of A1
 print("1.")
 contra.objret(cat1).Catprinter//If here we would have applied covariance then we would not have been able to print this as the
 //Object returned by covariance will be of parent class type but here the object is returned of child class type i.e. Cat class type
 print("2.")
 contra.objret(cat1).printer
 print("3.")
// contra.objret(animal1).printer
// contra.objret(dog1).dogprinter()
 contra.objret(cat1).printer




 println("\n\n\n===================Bounding=======================")
 class cage[A]
 {
  def printing[A<:Animal](a:A)=a.printer//bounding can be done at class level as well
 }

 class cage2[A<:Animal](animal:A)//upper bounded--There can also e lower bounded type
 {
  def printing=animal.printer//bounding can be done at class level as well
 }


 val c=new cage[Dog]
 print("1.")
 c.printing(dog1)
 val c1=new cage2[Dog](dog1)
 print("2.")
 c1.printing



}



