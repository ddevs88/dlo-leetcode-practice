package basics.dataStructure.sorting

import scala.collection.mutable

object FindDuplicate extends App {

  def hasDuplicate(arr: Array[Int]): Boolean = {
    var flag = false
    var arrSet = mutable.HashSet[Int]()
    for(i <- 0 to arr.length-1){
      if(arrSet.contains(arr(i))){
        flag = true
      }
      else {
        arrSet.add(arr(i))
      }
    }
    flag
  }

  println(hasDuplicate(Array(1, 2, 3, 4, 5, 6, 7, 4)))

}
