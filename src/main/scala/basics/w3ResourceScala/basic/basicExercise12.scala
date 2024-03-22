package basics.w3ResourceScala.basic

object basicExercise12 {

  def createStr(str: String): String = {
    val l = str.length
    if (l < 3) str else str.take(3) + str + str.take(3)
  }

  def main(args: Array[String]): Unit = {
    println(s"Result: ${createStr("hello")}")
  }
}
