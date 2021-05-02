package LearningScalaCode.Setion_2_OOP.Exercise

object GenericCovariance extends App {

  class printer[A] {
    def printAll(a: Seq[A]) = {
      for (i <- a)
        println(i)
    }

    def add(x: A, y: A)(implicit num: Numeric[A]): A = num.plus(x, y)

  }

  val p = new printer[Int]
  val m = Seq(1, 3, 2)
  println("===================Generics=======================")
   p.printAll(m)
  println(p.add(7,5))


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
  //Invariance
  class invar[A]
  {
    def objret(a:A)=a
  }
  println("===================invariance=======================")
  val cat1=new Cat
  val dog1=new Dog
  val animal1=new Animal
  val inc=new invar[Cat]
  //inc.objret(animal1).printer//error as invariance
  inc.objret(cat1).printer
  inc.objret(cat1).Catprinter

  //Covariance
  class covar[+A]
  {
    def objret[A1>:A](a:A1)=a
  }
val covar=new covar[Animal]
  println("===================Covariance=======================")
  covar.objret(cat1).printer
  //covar.objret(cat1).Catprinter//It will only be animal object
  covar.objret(animal1).printer
  covar.objret(dog1).printer//Important It can also take object of dog but important is it can only call the the override func

  //
  class contravar[-A]
  {
    def objret[A1<:A](a:A1)=a
  }

  println("===================Contravariance=======================")
  val contra=new contravar[Animal]
  contra.objret(dog1).printer
  contra.objret(cat1).Catprinter//If here we would have applied covariance then we would not have been able to print this as the
    //Object returned by covariance will be of parent class type but here the object is returned of child class type i.e. Cat class type

  contra.objret(animal1).printer
  contra.objret(dog1).dogprinter()
  contra.objret(cat1).printer



}