package basics.interviewQuestions.scala

object CountCharsInString {

  def display(string: String): Int ={
    1
  }

  def display(n: Integer): Int ={
    2
  }

  def main(args: Array[String]): Unit = {
    println("Enter string: ")
    var str = scala.io.StdIn.readLine()

    var res = ""
    val s = str.distinct
    for(i <- 0 until s.size){
      val c = str.count(_ == s(i))
      res = res ++ s"${s(i)}${c}"
    }

    println(res)

    println(display(1))

  }

}
