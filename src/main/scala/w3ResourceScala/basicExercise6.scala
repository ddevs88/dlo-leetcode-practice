package w3ResourceScala

/*
* Write a Scala program to create a new string where 'if' is added to the front of a given string.
* If the string already begins with 'if', return the string unchanged.*/

object basicExercise6 {

  def createString(str: String): String = {
    if(str.toLowerCase.startsWith("if")) str else s"if: ${str}"
  }

  def main(args: Array[String]): Unit = {
    println(s"${createString("not available")}")
    println(s"${createString("If is available")}")
  }
}
