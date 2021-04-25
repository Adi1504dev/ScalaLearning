package LearningScalaCode.Setion_1_Basic

object Funtions extends App {
  def aFucn(a: String, b: Int): String = {
    a + " " + b
  }

  println(aFucn("Hello", 7))

  //Parameter less function
  def paramLessFucn(): Int = 45

  println(paramLessFucn) //Parameter less functions can be called just by names

  //Using recursion  function instead of loops
  /* Functions with recursion need the return type in normal function compiler may  infer but not in this it will give
  * compile time error*/
  def aRepeatedFuntion(a: String, n: Int): String = {
    if (n == 1)
      return a
    else
      a + aRepeatedFuntion(a, n - 1)
  }

  println(aRepeatedFuntion("Hello", 7))


  //Side effect function with unit return type
  def sideeffect(a: String): Unit = println(a)

  sideeffect("SideEffect")

  //Auxiliary Functions (Using function inside function)
  def aBigFuntion(n: Int): Int = {
    def aSmallFuntion(a: Int, b: Int): Int = a + b

    aSmallFuntion(n, n - 1)
  }

  println(aBigFuntion(5))


  //Recursive function to check if number is prime
  def primeCheck(k: Int, m: Int): Boolean = {
    if (m == 1)
      true
    else {
      if (k % m == 0)
        return false
      else
        return true  && primeCheck(k, m - 1)
    }
  }
  print(primeCheck(23, 22))
}