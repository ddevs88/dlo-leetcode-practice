package basics.leetCode.arrayListProgrmas

/*1287. Element Appearing More Than 25% In Sorted Array
* Given an integer array sorted in non-decreasing order,
* there is exactly one integer in the array that occurs more than 25% of the time, return that integer.
* */
object LeetCode1287 {

  def findSpecialInt(arr: Array[Int]): Int = {
    val percentage = arr.length/4
    var res = arr(0)
    for(i <- 0 until arr.length){
      val k = arr(i)
      var v = 0
      for(j <- 0 until arr.length){
        if(k==arr(j)){
          v+=1
        }
      }
      if(v>percentage){
        res = arr(i)
      }
    }
    res
  }

  def findSpecialEle(a: Array[Int]): Int = {
    val quarter = a.length/4
    for(i <- 0 until a.length-quarter){
      if(a(i)==a(i+quarter)){
        return a(i)
      }
    }
    -1
  }
  def main(args: Array[String]): Unit = {

    println(findSpecialInt(Array(1,2,2,6,6,6,6,7,10)))
    println(findSpecialEle(Array(1,2,2,6,6,6,6,7,10)))
  }

}
