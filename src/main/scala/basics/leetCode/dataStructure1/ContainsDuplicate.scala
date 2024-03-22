package basics.leetCode.dataStructure1

object ContainsDuplicate {

  //Brute force using two loop n^2
  def containsDuplicate(nums: Array[Int]): Boolean = {
    val flag = false
    for(i <- 0 until nums.length){
      for(j <- i+1 until nums.length){
        if(nums(i)==nums(j)){
          return true
        }
      }
    }
    flag
  }

  def checkDup(arr: Array[Int]): Boolean = {
    var temp = arr(0)
    var k = 1
    var flag = false
    while(!flag && k<arr.length){
      for(i <- k until arr.length){
        if(temp==arr(i)){
          flag = true
          return flag
        }
      }
      temp = arr(k)
      k+=1
    }
    flag
  }

  def spliCol(str: String): Array[String]={
    val n = str.length/15
  val arr = new Array[String](n)
    var start = 0
    var end = 15
  for(i <- 0 until n){
    arr(i) = str.substring(start, end)
    start+=15
    end+=15
    println(s"start: ${start}")
    println(s"start: ${end}")
  }
  arr
}

  def main(args: Array[String]): Unit = {

    //println(containsDuplicate(Array(2,14,18,22,22)))
    //println(checkDup(Array(2,14,18,22,2)))

    println(spliCol("1001DevBareilly1002RahBanglore1003RamBareilee1004SamBareille").toList)
  }
}
