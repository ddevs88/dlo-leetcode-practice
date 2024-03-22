package basics.w3ResourceScala.basic

object basicExercise13 {

  def checkStr(str: String): Boolean = {
    if (str.startsWith("Sc")) true else false
  }

  def main(args: Array[String]): Unit = {
    println(s"Result: ${checkStr("Hello")}")
    println(s"Result: ${checkStr("Sc is present")}")
  }
}
