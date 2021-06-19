package LearningScalaCode.Section_2_OOP

import org.w3c.dom.ranges.RangeException

object B3_ExceptionHandling2 extends App{
/*Define Exception*/

  class MyException extends Exception

  val exception=new MyException
  //throw exception
  //OOM
 // val array=Array.ofDim(Int.MaxValue)

  //Stack Overflow
  /*
  def infinite:Int=1+infinite
  infinite
  */
  class OverflowException extends RuntimeException
  class UnderFlowException extends RuntimeException
  class MathCalculationException extends RuntimeException("Revision by zero")
  object pocketCalculator
  {
    def add(x:Int,y:Int):Int={
      val result=x+y
      if(x>0 && y>0 && result<0) throw new OverflowException
      else if(x<0 && y<0 && result>0) throw new UnderFlowException
      else result
    }
    def subtract(x:Int,y:Int):Int={
      val result=x-y
      if(x>0 && y<0 && result<0) throw new OverflowException
      else if(x<0 && y>0 && result>0) throw new UnderFlowException
      else result
    }

    def multiply(x:Int,y:Int):Int= {
      val result = x * y
      if (x > 0 && y > 0 && result < 0) throw new OverflowException
      else if (x < 0 && y < 0 && result > 0) throw new OverflowException
      else if (x > 0 && y < 0 && result > 0) throw new UnderFlowException
      else if (x < 0 && y > 0 && result > 0) throw new UnderFlowException
      else result
    }

      def divide(x:Int,y:Int):Int={

        if(y==0) throw new MathCalculationException
        else x/y


      }

  }
  //println(pocketCalculator.add(Int.MaxValue,10))
println(pocketCalculator.divide(4,0))

}
