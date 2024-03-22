package basics.w3ResourceScala.basic

object basicExercise7 {

  def removeCharAt(str: String, i: Int) = {
    println(str.take(4))
    str.take(i) + str.drop(i + 1)
  }

  def main(args: Array[String]): Unit = {
    println(s"${removeCharAt("Hello world", 4)}")
  }
}
