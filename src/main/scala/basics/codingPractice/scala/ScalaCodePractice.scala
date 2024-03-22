package basics.codingPractice.scala

import scala.collection.mutable

object ScalaCodePractice {


  def main(args: Array[String]): Unit = {

    //Count occurrence of char in string
    println("===Count occurrence of char in string===")
    val str = "aaabbccdde"
    findOccurrence(str).foreach(println)

    //Find multiple duplicates in array
    println("===Find multiple duplicates in array===")
    println(findMultipleDuplicates(Array(2,3,4,2,3,4,5,5,6,7,9,3)).toList)

    //Find duplicate in array
    println("===FInd duplicate in array===")
    println(findDuplicate(Array(1,2,3,4,5,3)))

    //Find all pair in array is equal to k
    println("===FInd pairs in array===")
    println(findPair(Array(1,2,3,4,5,6), 6).toList)



  }

  def findPair(arr: Array[Int], k: Int): Array[(Int, Int)]={
    val res = new mutable.ArrayBuffer[(Int, Int)]
    for(x <- arr){
      for(i <- arr.indexOf(x)+1 until arr.length){
        if(k-x == arr(i)){
          res.addOne((x, arr(i)))
        }
      }
    }
    res.toArray
  }

  def findDuplicate(arr: Array[Int]): Int={
    var res = -1
    var count = 1
    for(x <- arr){
      for(i <- arr.indexOf(x)+1 to arr.length-1){
        if(x == arr(i)){
          res = x
        }
      }
    }
    /*while(count <=1){
      for(x <- arr){
        for(i <- arr.indexOf(x)+1 to arr.length-1){
          if(x == arr(i)){
            count+=1
            res = x
          }
        }
      }
    }*/
    res
  }

  def findMultipleDuplicates(arr: Array[Int]): Map[Int, Int]={
    val m = scala.collection.mutable.Map[Int, Int]()
    var c: Char = '\''
    for(x <- arr){
      if(m.contains(x)){
        m.put(x, m(x)+1)
      }
      else{
        m.put(x, 1)
      }
    }
    m.toMap[Int, Int].filter(_._2>1)
  }

  def findOccurrence(str: String): scala.collection.mutable.Map[Char, Int]={

    val map = scala.collection.mutable.Map[Char, Int]()
    for(c <- str.toList){
      if(map.contains(c)){
        val v = map.getOrElse(c, 0)+1
        map.addOne(c -> v)
      }
      else {
        map.addOne(c -> 1)
      }
    }
    map
  }
}
