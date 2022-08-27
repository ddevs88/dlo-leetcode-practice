package dataStructure.dsWithScala.fundamentalAlgorithms

object DecimalToBinary {

  def deciToBin(x: Int): String = {
    val seqOfDivByTwo = Iterator.iterate(x)(a => a/2)
    val binList = seqOfDivByTwo.takeWhile(a => a > 0).map(a => a % 2)
    binList.mkString.reverse
  }
  def main(args: Array[String]): Unit = {

    println(deciToBin(5))
    Iterator.iterate(5)(a => a/2).foreach(println)
  }
}
