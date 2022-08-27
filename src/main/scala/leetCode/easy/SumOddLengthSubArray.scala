package leetCode.easy

object SumOddLengthSubArray {

  def sumOddLengthSubArrays(arr: Array[Int]): Int = {
    (1 to arr.size by 2)
      .map( oddNumber => {
        arr.sliding(oddNumber).flatten.sum
      }
    ).sum
  }

  def main(args: Array[String]): Unit = {
    val arr = Array(1,4,2,5,3)
    (1 to arr.size by 2).foreach(println)
    println(sumOddLengthSubArrays(arr))
  }
}
