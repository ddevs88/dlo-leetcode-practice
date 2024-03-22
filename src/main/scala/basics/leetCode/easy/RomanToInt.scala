package basics.leetCode.easy

  import scala.collection.immutable.HashMap

object RomanToInt extends App {

  def romanToInt(str: String): Int = {
    val hm = HashMap('I' -> 1, 'V' -> 5, 'X' -> 10, 'L' -> 50, 'C' -> 100, 'D' -> 500, 'M' -> 1000)
    var res = hm(str(str.length - 1))
    for(i <- (0 to str.length-2).reverse){
      val x = hm(str(i))
      val y = hm(str(i + 1))
      if(x < y) {
        res = res - x
      }
      else {
        res = res + x
      }
    }
    res
  }

  println(romanToInt("MCMXCIV"))
  println(romanToInt("III"))
}
