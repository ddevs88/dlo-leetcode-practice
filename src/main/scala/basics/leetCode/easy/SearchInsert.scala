package basics.leetCode.easy

import scala.util.control.Breaks.break

object SearchInsert {

  def searchInsert(nums: Array[Int], target: Int): Int = {
    var n = -1
    for(i <- 0 until nums.length){
      if(target >= nums(i)){
        n = i
        break
      }
      else{
        n = nums.length + 1
      }
    }
    n
  }

  def main(args: Array[String]): Unit = {


  }
}
