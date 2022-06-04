package RandomProblems

import scala.collection.mutable

object IsUniqueTest extends App {

  val arr = Array(1, 2, 3, 4, 5, 6, 7, 8, 2)
  def isUniqueFunc(array: Array[Int]): Boolean = {
    val hs = mutable.HashSet[Int]()
    for(i <- 0 to arr.length-1){
      if(hs.contains(arr(i))){
        return false
      }
      else {
        hs.add(arr(i))
      }
    }
    true
  }
  println(isUniqueFunc(arr))
}
