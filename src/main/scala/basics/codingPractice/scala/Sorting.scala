package basics.codingPractice.scala

object Sorting {

  def main(args: Array[String]): Unit = {
    println("===selectionSort===")
    val arr = Array(3, 2, 4, 5, 9, 6, 8, 1, 7, 0)
    println(selectionSort(arr).toList)

    println("===insertionSort===")
    println(insertionSort(arr).toList)
  }

  //InsertionSort
  //1/4 N^2 compares and 1/4N^2 exchanges
  def insertionSort(arr: Array[Int]): Array[Int]={
    val n = arr.length
    for(i <- 0 until n){
      var temp:Int = arr(i)
      var j = i
      while(j>=0 && temp < arr(j)){
        arr(i)=arr(j)
        arr(j)=temp
        temp = arr(j)
        j-=1
      }
    }
    arr
  }

  //selectionSort
  //N^2/2 compares and N exchanges (Quadratic time and linear number of exchanges)
  def selectionSort(array: Array[Int]): Array[Int]={
    val n = array.length
    for(i <- 0 until n){
      var temp = array(i)
      for(j <- i+1 until n){
        if(array(j)<temp){
          array(i) = array(j)
          array(j)=temp
          temp = array(i)
        }
      }
    }
    array
  }

}
