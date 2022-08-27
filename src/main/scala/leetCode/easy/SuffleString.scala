package leetCode.easy

import scala.collection.immutable.ListMap

object SuffleString {

  def restoreString(s: String, indices: Array[Int]): Unit = {
    val arr = indices.map(x => (x -> s(indices.indexOf(x))))
    val str = ListMap(arr.toSeq.sortBy(_._1): _*)
      .values.foldLeft("")((x, y) => x ++ y.toString)
    println(str)
  }

  def main(args: Array[String]): Unit = {
    val s = "codeleet"
    val indices: Array[Int] = Array(4, 5, 6, 7, 0, 2, 1, 3)

    restoreString(s, indices)

  }
}
