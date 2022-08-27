package leetCode.easy

object LengthOfLastWord {

  def lengthOfLastWord(s: String): Int ={
    s.split(" ").last.length
  }
  def main(args: Array[String]): Unit = {

    val s = "Hello world"
    println(lengthOfLastWord(s))
  }
}
