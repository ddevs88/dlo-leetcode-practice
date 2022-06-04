package leetCode.easy

import scala.collection.mutable

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

    println("=============")

    val startTime1 = System.currentTimeMillis()
    twoSum_hashMap(Array(2, 11, 7, 15), 9)

    val endTime1 = System.currentTimeMillis()
    println(s"Consumed time: ${endTime1 - startTime1}")
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

  def twoSum_hashMap(nums: Array[Int], target: Int): Unit = {
    var map = mutable.HashMap[Int, Int]()
    for(n <- 0 to nums.length-1){
      var diff = target - nums(n)
      if(map.contains(diff)) {
        println(s"(${map.get(diff).get}, $n)")
      }
      else {
        map.put(nums(n), n)
      }
    }
  }
}
