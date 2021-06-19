package LearningScalaCode.Section_2_OOP

import Playground.Cinderella
import java.util.Date
import java.sql.{Date=>SqlDate, Time}
//import Playground._//Cinderella//only use _ if only needed




object PackageAndImports extends App {
  //Package members are accessible by their simple name
val person=new Person("" +"Bacha",6)

  //Import Packages
  val cinderella=new Cinderella
  //or
  val cinderella1=new Playground.Cinderella
  //Packages are in hierarchy
  //matching folder structure

  //Using Package Objects
name//Package object are visible throughout package

  //Using 2 class with same name
  val date=new Date()
  val date2=new SqlDate(2018,5,4)//Aliasing see import or u can use fully qualified path

  //default imports
    //Java.Lang==>String,Object,Exception
  //scala==> Int,Nothing, Function
  //scala.Predef==>println,???,
}
