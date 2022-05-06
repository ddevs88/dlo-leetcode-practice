package leetCode.easy

object TwoSum {

  def main(args: Array[String]): Unit = {
    println("Hello test!!")
    println(s"${util.Properties.versionString}")

    val startTime = System.currentTimeMillis()
    twoSum_brute_force(Array(2, 11, 7, 15), 9)
      .foreach(println)

    val endTime = System.currentTimeMillis()
    println(s"Consumed time: ${endTime - startTime}")

    twoSum_brute_force(Array(2, 11, 7, 15), 10)
      .foreach(println)
  }

  def twoSum_brute_force(nums: Array[Int], target: Int): Array[Int] = {

    var arr: Array[Int] = Array[Int]()
    val l = nums.length
    for (i <- 0 until l) {
      for (j <- i + 1 until l) {
        if (nums(i) + nums(j) == target) {
          arr = Array(i, j)
        }
      }
    }
    arr
  }
}
