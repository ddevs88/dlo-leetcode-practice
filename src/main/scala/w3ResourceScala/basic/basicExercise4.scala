package w3ResourceScala.basic

object basicExercise4 {

  def checkInt(i: Int, i1: Int): Boolean = {
    if (i == 30 || i1 == 30) true
    else if (i + i1 == 30) true else false
  }

  def main(args: Array[String]): Unit = {
    println(s"${checkInt(3, 30)}")
  }

}
