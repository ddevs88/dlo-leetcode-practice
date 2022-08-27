package leetCode.binarySearch

object SquarRoot {


  def findSqrt(n: Int): Int = {

    for(i <- 1 until(n)){
      val x = i*i;
      if(x == n){
        return i
      }
    }
    0
  }
  def main(args: Array[String]): Unit = {

    println("Check :"+findSqrt(9));
  }
}
