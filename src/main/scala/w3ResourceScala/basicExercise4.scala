package w3ResourceScala

/*Write a Scala program to check two given integers,
and return true if one of them is 30 or if their sum is 30*/

object basicExercise4 {

  def checkInt(i: Int, i1: Int): Boolean = {
    if(i == 30 || i1 == 30) true
    else if(i+i1 == 30) true else false
  }

  def main(args: Array[String]): Unit = {
    println(s"${checkInt(3, 30)}")
  }

}
