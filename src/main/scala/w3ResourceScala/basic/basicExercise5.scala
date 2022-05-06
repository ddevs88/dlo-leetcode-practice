package w3ResourceScala.basic

object basicExercise5 {

  def test(x: Int): Boolean = {
    Math.abs(100 - x) <= 20 || Math.abs(300 - x) <= 20
  }

  def main(args: Array[String]): Unit = {
    println("Result: " + test(115));
    println("Result: " + test(200));
    println("Result: " + test(250));
    println("Result: " + test(70));
  }
}
