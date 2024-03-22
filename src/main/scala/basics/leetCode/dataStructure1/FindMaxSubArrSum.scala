package basics.leetCode.dataStructure1

import scala.annotation.tailrec

object FindMaxSubArrSum {

  /* Kadane’s Algorithm
    Initialize:
    max_so_far = INT_MIN
    max_ending_here = 0

Loop for each element of the array

  (a) max_ending_here = max_ending_here + a[i]
  (b) if(max_so_far < max_ending_here)
            max_so_far = max_ending_here
  (c) if(max_ending_here < 0)
            max_ending_here = 0
return max_so_far
*/
  def maxSubArray(nums: Array[Int]): Int = {
    var max = Int.MinValue
    var maxTemp = 0
    for(i <- nums.indices){
      maxTemp = maxTemp + nums(i)
      if(max<maxTemp){
        max = maxTemp
      }
      if(maxTemp<0){
        maxTemp=0
      }
    }
    max
  }

  // pure scala solution
  def maxSubArrayNew(nums: Array[Int]): Int = {
    @tailrec
    def _maxSubArray(nums: List[Int], max: Int, sum: Int): Int =
      nums.headOption match {
        case Some(value) =>
          _maxSubArray(
            nums.tail,
            Math.max(max, sum),
            Math.max(value, sum + value)
          )
        case None => Math.max(max, sum)
      }

    val list = nums.toList

    _maxSubArray(list.tail, list.head, list.head)
  }

  def main(args: Array[String]): Unit = {
    println(maxSubArray(Array(5,4,-1,7,8)))
    println(maxSubArrayNew(Array(5,4,-1,7,8)))
  }
}
