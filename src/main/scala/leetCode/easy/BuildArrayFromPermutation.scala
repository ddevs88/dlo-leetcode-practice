package leetCode.easy

object BuildArrayFromPermutation {

  def buildArray(nums: Array[Int]): Array[Int] = {
    val ans = new Array[Int](nums.length)
    for(i <- 0 until nums.length){
      ans(i) = nums(nums(i))
    }
    ans
  }

  def mostWordsFound(sentences: Array[String]): Int = {
    sentences.map(arr => arr.split(" ").length).max
  }

  def main(args: Array[String]): Unit = {

    val arr = Array(0,2,1,5,3,4)


    println("==============")
    buildArray(arr).foreach(println)

    val str = Array("alice and bob love leetcode","i think so too","this is great thanks very much")
    println(s"mostWordsFound: ${mostWordsFound(str)}")

    println(3%2)

  }
}
