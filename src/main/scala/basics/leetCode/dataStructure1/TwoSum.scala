package basics.leetCode.dataStructure1

object TwoSum {

  def twoSumBruteForce(array: Array[Int], target: Int): Array[Int] = {
    val result = new Array[Int](2)
    for(i <- 0 until array.length) {
      for(j <- i+1 until array.length){
        if(array(i)+array(j) == target){
          result(0) = i
          result(1) = j
          return  result
        }
      }
    }
    result
  }

  def binSearch(arr: Array[Int], left: Int, right: Int, key: Int): Int = {
    var res = -1
    var l = left
    var r = right
    while(l<=r){
      val mid = (l+r)/2
      if(key == arr(mid)){
        res = mid
        return res
      }
      else if(key < arr(mid)){
        r = mid - 1
      }
      else {
        l = mid + 1
      }
    }
    res
  }

  def twoSum(arr: Array[Int], target: Int): Array[Int]={
    val newArray = arr.sorted
    println(s"Sorted array: ${newArray.toList}")
    val res = new Array[Int](2)
    for(i <- 0 until newArray.length-1){
      val key = target-newArray(i)
      val binVal = binSearch(newArray, i+1, arr.length-1, key)
      println(s"key:${key}")
      println(s"binVal:${binVal}")
      if(binVal != -1){
        res(0) = arr.indexOf(newArray(i))
        res(1) = arr.indexOf(newArray(binVal))
        return res
      }
    }
    res
  }
  def main(args: Array[String]): Unit = {
    println(twoSum(Array(2,7,11,15), 9).toList)
    println(twoSum(Array(3,2,3), 6).toList)
    println(twoSum(Array(3,2,4), 6).toList)
    println(twoSumBruteForce(Array(3,2,3), 6).toList)
  }
}
