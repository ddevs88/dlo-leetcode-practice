package leetCode.easy

object SuffleArray {

  def shuffle(nums: Array[Int], n: Int): Array[Int] = {
    var ans: Array[Int] = new Array(n*2)
    var i = 0
    var j = 0
    var k = n
    while (i < n) {
      ans(i) = nums(j)
      i = i+1
      j = j+1
      ans(i) = nums(k)
      i = i+1
      k = k+1
      }
    ans
  }

  def main(args: Array[String]): Unit = {
    val nums = Array(2,5,1,3,4,7)
    val n = 3
    shuffle(nums, n).foreach(println)
  }
}