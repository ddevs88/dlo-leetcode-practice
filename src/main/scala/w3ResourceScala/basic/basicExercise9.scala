package w3ResourceScala.basic

object basicExercise9 {

  def test(str: String): String = {
    val l = str.length
    if (l < 2) str
    else {
      str.take(2) * 4
    }
  }

  def main(args: Array[String]): Unit = {
    println(s"Result: ${test("okay")}")
  }

}
