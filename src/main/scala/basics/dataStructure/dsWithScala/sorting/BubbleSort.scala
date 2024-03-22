package basics.dataStructure.dsWithScala.sorting

object BubbleSort {

  def bubbleSort(arr: Array[Int]): Array[Int] = {
    for(i <- 0 until arr.length-1){
      for(j <- 0 until arr.length-1-i){
        if(arr(j) > arr(j+1)){
          val temp = arr(j)
          arr(j) = arr(j+1)
          arr(j+1) = temp
        }
      }
    }
    arr
  }

  def bubbleSortDesc(arr: Array[Int]): Array[Int]={
    var temp = 0
    for(i <- 0 until arr.length-1){
      for(j <- 0 until arr.length -i -1){
        if(arr(j) < arr(j+1)){
          temp = arr(j+1)
          arr(j+1) = arr(j)
          arr(j) = temp
        }
      }
    }
    arr
  }
  def main(args: Array[String]): Unit = {

    val arr = Array(3,2,4,5,9,6,8,1,7,0)
    println(bubbleSort(arr).toList)
    println(bubbleSortDesc(arr).toList)
  }
}
