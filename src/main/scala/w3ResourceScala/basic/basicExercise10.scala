package w3ResourceScala.basic

object basicExercise10 {


  def getStr(str: String): String = {
    val l = str.length
    if (l < 1) "Empty string"
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
