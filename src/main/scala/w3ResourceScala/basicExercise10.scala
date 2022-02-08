package w3ResourceScala

/*
*
* Write a Scala program to create a new string
* with the last char added at the front and back of a given string of length 1 or more. */

object basicExercise10 {


  def getStr(str: String): String = {
    val l = str.length
    if(l < 1) "Empty string"
    else str.last + str + str.last
  }

  def main(args: Array[String]): Unit = {
    println(s"Result: ${getStr("Hello")}")

    println("Result: " + getStr("Scala"))
    println("Result: " + getStr("abcd"))
    println("Result: " + getStr("ab"))
    println("Result: " + getStr("a"))

    println("Result: " + getStr(""))
  }
}
