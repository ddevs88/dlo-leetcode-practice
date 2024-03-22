package basics.w3ResourceScala.basic

object basicExercise2 {
  def main(args: Array[String]): Unit = {
    println(s"${sumTwo(2, 5)}")
  }

  def sumTwo(n1: Int, n2: Int): Int = {
    (n1 + n2) * 3
  }
}
