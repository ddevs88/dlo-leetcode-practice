package dataStructure.sorting

object BubbleSort extends App{

  def bubbleSort(list: Array[Int]): Array[Int] = {
    var last_index = list.length-1
    println(last_index)
    var sorted = false

    while(sorted == false){
      sorted = true
      for(i <- 0 to last_index-1){
        if(list(i) > list(i+1)){
          sorted = false
          var temp = list(i)
          list(i) = list(i+1)
          list(i+1) = temp
          last_index = last_index-1
        }
      }
    }
    list
  }
  bubbleSort(Array(1, 3, 2, 4, 5, 6, 8, 7)).foreach(println)
}
