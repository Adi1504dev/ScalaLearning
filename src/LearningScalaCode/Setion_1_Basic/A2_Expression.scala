package LearningScalaCode.Setion_1_Basic

object A2_Expression extends App{
  val x=1+2 //1+2 here is expression
  /*
  * Expressions are evaluated and value is set to x and type of x is same as type of expression
  * Math expression + - / *
  * bitwise & | >> << >>>(right shift with zero extension
  // */
  println(x)

  //Relation operator == != > < <= >=
  println(1==2)
  //logical operator ! && ||


  var y=4
  y *=2 //only works with var


  //Instructions{Do}(Tell computer to do eg print to console, send to server etc) vs Expression{Value}(That has value and/or type)
  //If Expression(Value) In scala if can return a value instead of setting it process the instructions
  val acondition= true
  val aconditioned= if(acondition) 5 else 3
  println("aconditioned==>"+aconditioned)
  println(if(acondition) 5 else 3) //similar to println(1+2)

  var i=0
  while(i<10)
    {
      println("While loop==>"+i)
      i+=1
    }
    //Never use while loop avoid it==> they are side effects and they also returns unit

    //Everything in scala in an expression

    // eg variable assignment is also and expression which return unit(void) type value
    var avariable=2
    val aWeirdValue= (avariable = 9)
    println(aWeirdValue)//()

    //Side effects ==> printing something to console ,variable , reassigning==> They return unit



    /*  Code Block */
    //Value of block is value of last expression
    val aCodeBlock={
     //Everything inside code block is not visible outside
      val x=4
      val y=if(x==4) "Hello" else "Good Bye"
    }
}
