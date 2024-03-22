package basics.leetCode.arrayListProgrmas

import scala.collection.mutable.ArrayBuffer

object LeetCode118PascalTriangle {

  def generate(k: Int): Array[List[Int]]={
    val result = new Array[List[Int]](k)
    val row = new ArrayBuffer[Int]
    for(i <- 0 until k){
      row.insert(0, 1)
      for(j <- 1 until row.size-1){
        row.update(j, row(j)+row(j+1))
      }
      result(i)= row.toList
    }
    result
  }

  def generateNew(k: Int): List[List[Int]] = {
    val res = new Array[List[Int]](k)
    val row = new ArrayBuffer[Int]()
    for(i <- 0 until k){
      row.insert(0,1)
      for(j <- 1 until row.size-1){
        row.update(j, row(j)+row(j+1))
      }
      res(i) = row.toList
    }
    res.toList
  }

  def main(args: Array[String]): Unit = {

    generate(8).foreach(println)
    println("===============")
    generateNew(5).foreach(println)
  }
}
