package basics.leetCode.dataStructure1

import scala.collection.mutable

object IntersactionOfTwoArrays {

  def intersection(nums1: Array[Int], nums2: Array[Int]): Array[Int] = {
    var hs = new mutable.HashSet[Int]()
    for(i <- nums1){
      for(j <- nums2){
        if(i == j){
          hs.add(i)
        }
      }
    }
    hs.toArray
    //hs.add()
  }
  def main(args: Array[String]): Unit = {
    println(intersection(Array(1,2,2,1), Array(2,2)).toList)
  }
}
