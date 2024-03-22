package basics.leetCode.easy

object KidsWithGreatestNum {

    def kidsWithCandies(candies: Array[Int], extraCandies: Int): List[Boolean] = {
      val n = candies.length
      var ans: Array[Boolean] = new Array(n)

      val extraC = candies.map(x => x+extraCandies)
      for(i <- 0 until n){
        var flag = true
        for(j <- 0 until n){
          if(extraC(i) < candies(j)){
            flag = false
          }
        }
        ans(i) = flag
      }
      ans.toList
    }

  def main(args: Array[String]): Unit = {

    val candies = Array(2,3,5,1,3)
    val extraCandies = 3
    kidsWithCandies(candies, extraCandies).foreach(println)
  }
}
