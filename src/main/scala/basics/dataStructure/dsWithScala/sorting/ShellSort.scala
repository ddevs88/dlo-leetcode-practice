package basics.dataStructure.dsWithScala.sorting

object ShellSort {

  def shellSort(arr: Array[Int]): Array[Int] = {
    var gap = arr.length/2
    while(gap>=1){
      for(i <- gap until arr.length){
        val temp = arr(i)
        var j = i-gap
        while(j >= 0 && temp < arr(j)){
          arr(j+gap) = arr(j)
          j -= gap
        }
        arr(j+gap) = temp
      }
      gap = (gap/2.2).round.toInt
    }
    arr
  }

  def main(args: Array[String]): Unit = {

    val arr = Array(3, 2, 4, 5, 9, 6, 8, 1, 7, 0)
    println(shellSort(arr).toList)
  }
}
