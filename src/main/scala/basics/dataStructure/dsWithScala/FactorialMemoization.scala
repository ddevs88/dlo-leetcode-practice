package basics.dataStructure.dsWithScala

class FactorialMemoization {
  var cache: Map[Int, Int] = Map()
  def lookup(num: Int): Int =
    cache.getOrElse(num, 0)

  def calcFactMemoiz(x: Int): Int = {
    if(x == 0 || x ==1)
    1
    else if(lookup(x) > 0) {
      println("Performing lookup")
      lookup(x)
    } else {
      println("Performing calculation")
      val factorial = x * calcFactMemoiz((x - 1))
      cache += x -> factorial
      factorial
    }
  }
}
object FactorialMemoizApp {
  def main(args: Array[String]): Unit = {
    val factMem = new FactorialMemoization()
    println(factMem.calcFactMemoiz(3))
    println(factMem.calcFactMemoiz(5))
  }
}
