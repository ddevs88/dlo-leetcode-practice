package basics.dataStructure.dsWithScala.sorting

object TestingSort {

  def isSort(arr: Array[Double]): Boolean = {
    arr.zip(arr.tail).forall(t => t._1 <= t._2)
    //(arr, arr.tail).zipped.forall(_ <= _)
  }
  def main(args: Array[String]): Unit = {

    val arr = Array(3, 2, 4, 5, 9, 6, 8, 1, 7, 0)
    println(isSort(Array.fill(10)(math.random())))
    println(util.Properties.versionString)

    val x = (4/2.2).round.toInt
    println(x)
  }
}
