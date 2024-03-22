package basics.dataStructure.dsWithScala.fundamentalAlgorithms

object DevideAndConquer {

  def findContSubArrayMax(data: Vector[Int]): Int = {

    data match {
      case Vector(x) => x
      case _ => {
        val (l, r) = data.splitAt(data.length/2)
        val leftMax = findContSubArrayMax(l)
        val rightMax = findContSubArrayMax(r)
        val crossMax = findCrossMax(l, r)
        List(leftMax, rightMax, crossMax).max
      }
    }
  }

  def findCrossMax(l: Vector[Int], r: Vector[Int]): Int = {
    val collLeftSum = for(i <- 1 to l.length) yield l.takeRight(i).sum
    val collRightSum = for(i <- 1 to r.length) yield r.take(i).sum
    collLeftSum.max + collRightSum.max
  }

  def main(args: Array[String]): Unit = {

    val stockPriceDiff = Vector(1, -2, 5, 6, -1, 4, 9, -3, 2, 5)
    val stockPrice = Vector(-2, -3, 4, -1, -2, 1, 5, -3)
    println(findContSubArrayMax(stockPriceDiff))
    println(findContSubArrayMax(stockPrice))
  }

}
