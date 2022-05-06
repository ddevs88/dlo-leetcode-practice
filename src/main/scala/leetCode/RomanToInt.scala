package leetCode

object RomanToInt {

  def main(args: Array[String]): Unit = {

    println(s"Result: ${romanToInt("IX")}")
  }

  def romanToInt(s: String): Int = {

    val length = s.length
    println(s"Length: $length")
    var sum = 0
    for(i <- 0 until length){
      var s1 = value(s(i))
      println(s"s1: $i = $s1")
      if(i + 1 < length) {
        var s2 = value(s(i+1))
        println(s"s2: ${i+1} = $s2")
        if(s1 >= s2){
          sum += s1
          println(s"Sum inside: (s1 >= s2): $sum")
        }
        else sum += (s2-s1)
        println(s"Sum inside: sum += (s2-s1): $sum")
      }
      else sum += s1
      println(s"Sum inside: sum += s1: $sum")
    }
    sum
  }

  def value(char: Char): Int = {
    char match {
      case 'I' => 1
      case 'V' => 5
      case 'X' => 10
      case 'L' => 50
      case 'C' => 100
      case 'D' => 500
      case 'M' => 1000
      case  _  => -1
    }
  }
}
