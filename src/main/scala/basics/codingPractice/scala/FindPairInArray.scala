package basics.codingPractice.scala

import scala.annotation.tailrec

object FindPairInArray {
  def main(args: Array[String]): Unit = {
    val arr = Array(9.0, 1.0, 6.0, 3.0, 4.0, 5.0, 6.0, 7.0, 0.0, 8.0, 2.0)
    //println(findPair(arr, 5.0))
  }

  def sortArr(arr: Array[Double]): Array[Double]={
    mergeSortWithTailrec(arr.toList).toArray
  }
  /*def findPair(arr: Array[Double], k: Double): List[(Double, Double)]={
    val sortedArr = sortArr(arr)
    var list: List[(Double, Double)] = Nil
    for(x <- sortedArr){
      println(s"${k}-${x}=${k-x}")
      val num = k-x
      println(num)
      val found = binSearch(sortedArr, num)
      println(found)
      if(found){
        println(found)
        list = List((x, k))
      }
    }
    list
  }*/

  @tailrec
  def mergeWithTailrec(l1: List[Double], l2: List[Double], list: List[Double]): List[Double] =
    (l1, l2) match {
      case (Nil, _) => list.reverse ::: l2
      case (_, Nil) => list.reverse ::: l1
      case (h1::t1, h2::t2) =>
        if(h1 < h2) mergeWithTailrec(t1, l2, h1::list)
        else mergeWithTailrec(l1, t2, h2::list)
    }

  def mergeSortWithTailrec(list: List[Double]): List[Double] =
    list match {
      case Nil => list
      case h::Nil => list
      case _ =>
        val (l1, l2) = list.splitAt(list.length/2)
        mergeWithTailrec(mergeSortWithTailrec(l1), mergeSortWithTailrec(l2), Nil)
    }
}
