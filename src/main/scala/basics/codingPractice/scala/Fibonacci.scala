package basics.codingPractice.scala

object Fibonacci {

  def fib(n: Int): Array[Int] ={
    val arr = new Array[Int](n)
    arr(0) = 0
    arr(1) = 1

    for(i <- 2 until n){
      arr(i) = arr(i-1)+arr(i-2)
    }
    arr
  }

  def main(args: Array[String]): Unit = {
    println(s"Fibonacci for 5: ${fib(5).toList}")
  }

}
