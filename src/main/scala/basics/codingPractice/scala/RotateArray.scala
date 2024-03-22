package basics.codingPractice.scala

object RotateArray extends App{

  def rotate(arr: Array[Int], k: Int): Array[Int]={
    val n = arr.length
    if(n<k){
      return arr.reverse
    }
    else{
      val temp = arr.slice(arr.length-k, arr.length)
      val first = arr.slice(0, arr.length-k)
      println(temp.toList)
      println(first.toList)
      for(i <- 0 until arr.length){
        if(i<temp.length){
          arr(i)=temp(i)
        }
        else{
          arr(i)=first(i-temp.length)
        }
      }
    }
    arr
  }

  def rotateNew(arr: Array[Int], k: Int): Array[Int]={
    var p = 1
    val n = arr.length
    while(p<=k){
      val first = arr(0)
      for(i <- 0 until n-1){
        arr(i)=arr(i+1)
      }
      arr(n-1)=first
      p+=1
    }
    arr
  }

  println(rotate(Array(1,2), 3).toList)
  println(rotateNew(Array(1,2,3,4,5,6,7), 3).toList)
  println(rotate(Array(-1,-100,3,99), 2).toList)
}
