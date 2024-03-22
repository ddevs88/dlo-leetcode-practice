package basics.w3ResourceScala.basic

object basicExercise14 {

  def checkInt(x: Int, y: Int, z: Int): Boolean = {

    if (x >= 20 && x <= 50 || y >= 20 && y <= 50 || z >= 20 && z <= 50) true else false
  }

  def main(args: Array[String]): Unit = {
    println(s"Result: ${checkInt(30, 40, 50)}")
    println(s"Result: ${checkInt(19, 40, 51)}")
    println(s"Result: ${checkInt(19, 10, 100)}")
  }
}
