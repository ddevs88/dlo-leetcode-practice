package dataStructure.dsWithScala.sorting

object SelectionSort {

  def minSort(a: Array[Int]): Array[Int] = {
    for (i <- 0 until a.length - 1) {
      var min = i
      for (j <- i + 1 until a.length) {
        if (a(j) < a(min)) {
          min = j
        }
      }
      val temp = a(i)
      a(i) = a(min)
      a(min) = temp
    }
    a
  }


  def main(args: Array[String]): Unit = {
    val arr = Array(3, 2, 4, 5, 9, 6, 8, 1, 7, 0)
    println(minSort(arr).toList)
  }

}
