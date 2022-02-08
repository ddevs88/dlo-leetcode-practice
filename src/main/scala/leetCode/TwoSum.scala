package leetCode

object TwoSum {

  def main(args: Array[String]): Unit = {
    println("Hello test!!")
    println(s"${util.Properties.versionString}")
    twoSum_brute_force(Array(2, 11, 7, 15), 9)
      .foreach(println)
  }

  def twoSum_brute_force(nums: Array[Int], target: Int): Array[Int] = {

    var arr: Array[Int] = Array()
    val l = nums.length
    for (i <- 0 to l - 1) {
      for (j <- i + 1 to l - 1) {
        if (nums(i) + nums(j) == target) {
          println(s"${nums(i)}:${nums(j)}")
          arr :+ nums(i) :+ nums(j)
        }
      }
    }
    arr
  }
}
