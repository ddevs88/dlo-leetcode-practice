package basics.leetCode.easy

object RemoveDuplicateInSortedArray {

  def removeDuplicate(nums: Array[Int]): Int = {
    var temp = nums(0)
    var j = 1
    for(i <- 1 until nums.length){
      if(temp != nums(i)){
        temp = nums(i)
        nums(j) = nums(i)
        j += 1
      }
    }
    nums.indexOf(temp) + 1
  }

  def main(args: Array[String]): Unit = {
    val nums = Array(1,1,2)
    val nums1 = Array(0,0,1,1,1,2,2,3,3,4)
    // println(removeDuplicate(nums1))
    println(removeDuplicate(nums1))
  }
}
