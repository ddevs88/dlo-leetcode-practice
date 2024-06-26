package w3ResourceScala

/*
* Write a Scala program to exchange the first and last characters
* in a given string and return the new string.*/

object basicExercise8 {

  def exchange(str: String): String = {
    val l = str.length
    if(l <= 1) str else {
    println(str.substring(1, str.length-1))
      str.last + str.substring(1, str.length-1) + str.charAt(0)
    }
  }

  def main(args: Array[String]): Unit = {
    println(s"${exchange("hello")}")

    println("Result: " + exchange("Scala"))
    println("Result: " + exchange("abcd"))
    println("Result: " + exchange("ab"))
    println("Result: " + exchange("a"))
  }
}
