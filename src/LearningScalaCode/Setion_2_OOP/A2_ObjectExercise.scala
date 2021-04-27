package LearningScalaCode.Setion_2_OOP

object A2_ObjectExercise extends App {
  val w = new Writer("Aditya", "Singh", 1997)
  println(w.fullname())
  val n = new Novel("School time", 2005, w)
  println(n.author_age())
  println(n.isWrittenBy())
  println((n.new_year_of_release(2008)).author_age())
}

class Writer(f_name: String, l_name: String, val year: Int) {
  def fullname(): String = {
    f_name + " " + l_name
  }
}

class Novel(Name: String, release_year: Int, author: Writer) {
  def author_age(): Int = release_year - author.year

  def isWrittenBy(auth: Writer = this.author): String = auth.fullname()

  def new_year_of_release(year: Int): Novel = new Novel(Name, year, author)
}