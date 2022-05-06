package w3ResourceScala.basic

object basicExercise6 {

  def createString(str: String): String = {
    if (str.toLowerCase.startsWith("if")) str else s"if: ${str}"
  }

  def main(args: Array[String]): Unit = {
    println(s"${createString("not available")}")
    println(s"${createString("If is available")}")
  }
}
