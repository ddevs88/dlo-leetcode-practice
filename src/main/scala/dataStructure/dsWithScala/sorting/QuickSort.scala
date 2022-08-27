package dataStructure.dsWithScala.sorting

object QuickSort {

  def quickSort(list: List[Double]): List[Double] = {
    list match {
      case Nil => list
      case h::Nil => list
      case pivot::tail =>
        val (less, greater) = tail.partition(_ < pivot)
        quickSort(less) ::: (pivot::quickSort(greater))
    }
  }

  def main(args: Array[String]): Unit = {
    println(quickSort(List.fill(10000000)(math.random())))
  }
}
