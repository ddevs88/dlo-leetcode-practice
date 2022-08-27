package leetCode.easy

object PlusOne {

  def pwr(n: Int): Int ={
    var result = 1
    var num = n
    while(num > 0){
      result *= 10
      num -= 1
    }
    println("power: "+ result)
    result
  }

  //This will work only if Number in integer range
  def plusOne(digits: Array[Int]): Array[Int] = {
    val l = digits.length
    var s = 0L
    for(i <-0 until l){
      if(l > 1){
        s = s + digits(i)*pwr(l - (i+1))
      }
      else {
        s = s + digits(i).toLong
      }
    }
    s = s+1
    println(s)
    val l1 = s.toString.length
    val newArr = new Array[Int](l1)
    for(j <- 0 until l1){
      val d = pwr(l1 - (j + 1))
      if(d > 0){
        newArr(j) = (s/d).toInt
        s = s%d
      }
    }
    newArr
  }

  // Final solution
  def onePlusNew(arr: Array[Int]): Array[Int] ={
    val l = arr.length
    for(i <- l-1 to 0 by -1){
      if(arr(i) == 9){
        arr(i) = 0
      }
      else {
        arr(i) = arr(i)+1
        return arr
      }
    }
    val nArr = new Array[Int](l+1)
    nArr(0) = 1
    nArr
  }


  def main(args: Array[String]): Unit = {

    val arr = Array(8,7,6,5,4,3,2,1,0)
    println(plusOne(arr).toList)
    println(onePlusNew(Array(8,7,6,5,4,3,2,1,0)).toList)
    println(onePlusNew(Array(9,8,7,6,5,4,3,2,1,0)).toList)
    println(onePlusNew(Array(8,9,9)).toList)
    println(onePlusNew(Array(9,9,9,9)).toList)

  }
}
