package w3ResourceScala

/*Write a Scala program to compute the sum of the two given integer values.
If the two values are the same, then return triples their sum.*/

object basicExercise2 {
  def main(args: Array[String]): Unit = {
    println(s"${sumTwo(2, 5)}")
  }

  def sumTwo(n1: Int, n2: Int): Int = {
    (n1+n2)*3
  }
}
