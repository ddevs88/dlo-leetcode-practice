package w3ResourceScala

/*Write a Scala program to get the absolute difference between n and 51.
If n is greater than 51 return triple the absolute difference.*/

object basicExercise3 {

  def main(args: Array[String]): Unit = {
    println(s"${absoluteDiff(55)}")
  }

  def absoluteDiff(n: Int): Int = {
    val abs_diff = math.abs(n-51)
    if(abs_diff > 0) abs_diff*3 else abs_diff
  }
}
