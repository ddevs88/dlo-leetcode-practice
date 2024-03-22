package basics.leetCode.easy

object ImplementStrStr {

  def strStr(haystack: String, needle: String): Int = {
    needle.isEmpty match {
      case true => 0
      case _ => {
        haystack.contains(needle) match {
          case false => -1
          case _ => haystack.sliding(needle.length, 1)
            .zipWithIndex
            .filter(n => n._1 == needle)
            .map(_._2)
            .next
        }
      }
    }
  }
  def main(args: Array[String]): Unit = {

    val haystack = "aaa"
    val needle = "a"
    println("Result: " + strStr(haystack, needle))

    haystack.sliding(needle.length, 1)
      .zipWithIndex
      .filter(n => n._1 == needle)
      .map(_._2)
      // .next()
      .foreach(println)

    println("Next: " + Iterator(0,1,2).next)
  }
}
