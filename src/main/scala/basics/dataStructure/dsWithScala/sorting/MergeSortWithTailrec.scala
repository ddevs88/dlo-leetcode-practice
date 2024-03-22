package basics.dataStructure.dsWithScala.sorting

import scala.annotation.tailrec

object MergeSortWithTailrec {

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
  def main(args: Array[String]): Unit = {
    println(mergeSortWithTailrec(List.fill(20000)(math.random())))
    val list = List(9.0, 1.0, 6.0, 3.0, 4.0, 5.0, 6.0, 7.0, 0.0, 8.0, 2.0)
    println(mergeSortWithTailrec(list))
  }
}
