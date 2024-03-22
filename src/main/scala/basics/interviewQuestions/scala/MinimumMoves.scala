package basics.interviewQuestions.scala

object MinimumMoves {

  def countMoves(arr1: Array[Int], arr2: Array[Int]): Int={
    var res=0
    for(i <- arr1.indices){
      val n1 = arr1(i).toString
      val n2 = arr2(i).toString
      for(j <- 0 until n1.length){
        var d1 = n1(j).asDigit
        val d2 = n2(j).asDigit
        println(s"d1:${d1} and d2:${d2}")
        while(d1!=d2){
          if(d1<d2){
            res+=1
            d1+=1
          }
          else {
            res+=1
            d1-=1
          }
          println(s"final d1:${d1} and d2:${d2} ${d1==d2}")
        }
      }
    }
    res
  }
  def main(args: Array[String]): Unit = {

    val arr1 = Array(123, 1234)
    val arr2 = Array(321, 1211)
    println(countMoves(arr1, arr2))
  }
}
