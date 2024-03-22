package basics.leetCode.arrayListProgrmas

object LeetCode1295 {

  def findNumbers(nums: Array[Int]): Int = {
    nums.count(_.toString.length % 2 == 0)
  }
  def main(args: Array[String]): Unit = {
    println(findNumbers(Array(12,345,2,6,7896)))
  }
}
