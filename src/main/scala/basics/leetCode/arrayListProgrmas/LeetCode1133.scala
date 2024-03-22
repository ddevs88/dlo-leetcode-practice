package basics.leetCode.arrayListProgrmas

import scala.collection.mutable

object LeetCode1133 {

  // Using map
  def findElement(array: Array[Int]): Int = {
    val map = new mutable.HashMap[Int, Int]()
    for(x <- array){
      map.put(x, map.getOrElse(x, 0)+1)
    }
    var max = -1
    max = map.filter(_._2==1).keySet.max
    max
  }

  def findEle(a: Array[Int]): Int = {
    var counts = new Array[Int](1000)
    for(i <- a){
      counts(i) = counts(i)+1
    }
    for(i <- 999 to 0 by -1){
      if(counts(i)==1){
        return i
      }
    }
    -1
  }
  def main(args: Array[String]): Unit = {
    println(findElement(Array(5,7,3,9,4,9,8,3,1)))
    println(findEle(Array(5,7,3,9,4,9,8,3,1)))
  }

}
