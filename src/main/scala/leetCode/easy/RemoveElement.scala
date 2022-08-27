package leetCode.easy

object RemoveElement {

  def removeElement(nums: Array[Int], n: Int): Int ={
    var count = 0
    for(i <- 0 until nums.length){
      if(n != nums(i)) {
        nums(count) = nums(i)
        count += 1
      }
    }
    println(nums.toList)
    count
  }
  def main(args: Array[String]): Unit = {
    val nums = Array(3,2,2,3)
    val n = 3
    println(removeElement(nums, n))
  }
}
