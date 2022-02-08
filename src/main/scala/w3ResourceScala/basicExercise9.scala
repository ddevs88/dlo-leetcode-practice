package w3ResourceScala

/*
* Write a Scala program to create a new string which is 4 copies of the 2 front characters of a given string.
* If the given string length is less than 2 return the original string.*/

object basicExercise9 {

  def test(str: String): String = {
    val l = str.length
    if(l < 2) str
    else {
      str.take(2)*4
    }
  }

  def main(args: Array[String]): Unit = {
    println(s"Result: ${test("okay")}")
  }

}
