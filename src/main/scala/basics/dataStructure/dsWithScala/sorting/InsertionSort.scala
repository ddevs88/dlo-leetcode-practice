package basics.dataStructure.dsWithScala.sorting

object InsertionSort {

  def insertionSort(arr: Array[Int]): Array[Int] = {
    for(i <- 1 until arr.length){
      var j = i-1
      val tmp = arr(i)
      while(j>=0 && tmp < arr(j)){
        arr(j+1) = arr(j)
        j -= 1
      }
      arr(j+1) = tmp
    }
    arr
  }
  def main(args: Array[String]): Unit = {

    val arr = Array(3, 2, 4, 5, 9, 6, 8, 1, 7, 0)
    println(insertionSort(arr).toList)
  }
}
