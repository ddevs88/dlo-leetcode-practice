package w3ResourceScala

/*
* Write a Scala program to remove the character in a given position of a given string.
* The given position will be in the range 0...string length -1 inclusive.*/

object basicExercise7 {

  def removeCharAt(str: String, i: Int) = {
    println(str.take(4))
    str.take(i) + str.drop(i+1)
  }

  def main(args: Array[String]): Unit = {
    println(s"${removeCharAt("Hello world", 4)}")
  }
}
