package basics.w3ResourceScala.basic

object basicExercise11 {

  def multipleOf(i: Int): Boolean = {
    if (i % 3 == 0 || i % 7 == 0) true else false
  }

  def main(args: Array[String]): Unit = {
    println(s"Multiple of: ${multipleOf(12)}")
    println(s"Multiple of: ${multipleOf(14)}")
    println(s"Multiple of: ${multipleOf(21)}")

    println("Result: " + multipleOf(3))
    println("Result: " + multipleOf(14))
    println("Result: " + multipleOf(12))
    println("Result: " + multipleOf(37))
  }
}
