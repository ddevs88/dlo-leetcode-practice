package dataStructure.dsWithScala.searching

object SequentialSearch {

  def indexOf(a: Array[Int], n: Int): Int = {
    var i = 0
    while(i < a.length && a(i) != n) i += 1
    if(i < a.length) i else -1
  }

  def find(a: Array[Int], p:Int => Boolean): Option[Int] = {
    var i = 0
    while(i < a.length && !p(a(i))) i+=1
    if(i < a.length) Some(a(i)) else None
  }

  def main(args: Array[String]): Unit = {
    val arr = Array(3, 2, 4, 5, 9, 6, 8, 1, 7, 0)
    println(indexOf(arr, 9))
    println(find(arr, _%3==0))
  }
}
