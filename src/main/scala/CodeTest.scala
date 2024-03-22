object CodeTest {
// Create a collection with (1, "2")

  /*
  * If nums = [2,7,11,15, 9] and target = 9,
  then we should return 0 and 1 because 2 + 7 = 9*/

  def findPair(arr: Array[Int], target: Int): Unit={

    var temp = arr(0)
    for(i <- 1 until arr.length){
      if(target == arr(i)){
        println(s"target found at :${i}")
      }
      else if (target-arr(i) == temp){
        println(arr.indexOf(temp), i)
      }
      else {
        temp = arr(i)
      }
    }
  }
  def main(args: Array[String]): Unit = {

    //println("Check")
    findPair(Array(2, 7, 11, 15, 9), 9)

  }
}
