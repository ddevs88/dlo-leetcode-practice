package dataStructure.dsWithScala.sorting

object MergeSort {

  def merge(l1: List[Double], l2: List[Double]): List[Double] =
    (l1, l2) match {
      case (_, Nil) => l1
      case (Nil, _) => l2
      case (h1::t1, h2::t2) =>
        if(h1 < h2) h1::merge(t1, l2)
        else h2::merge(l1, t2)
    }
  def mergeSort(list: List[Double]): List[Double] =
    list match {
      case Nil => list
      case h::Nil => list
      case _ =>
        val (l1, l2) = list.splitAt(list.length/2)
        merge(mergeSort(l1), mergeSort(l2))
    }
  def main(args: Array[String]): Unit = {
    val list = List(9.0, 1.0, 6.0, 3.0, 4.0, 5.0, 6.0, 7.0, 0.0, 8.0)
    println(mergeSort(list))
    // println(mergeSort(List.fill(10000)(math.random()))) // this produce stack over flow error
  }
}
