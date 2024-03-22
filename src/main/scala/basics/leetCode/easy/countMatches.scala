package basics.leetCode.easy

object countMatches {

  def countMatches(items: List[List[String]], ruleKey: String, ruleValue: String): Int = {
    val n = items.length
    var count = 0

    var i = 0
    if (ruleKey == "color") {
      i = 1
    }
    else if (ruleKey == "name") {
      i = 2
    }

    val res = items.map(x => if (x(i) == ruleValue) {
      count = count + 1
    })
    count
  }

  def main(args: Array[String]): Unit = {
    val items = List(List("phone", "blue", "pixel"), List("computer", "silver", "lenovo"), List("phone", "gold", "iphone"))
    val ruleKey = "color"
    val ruleValue = "silver"

    println(countMatches(items, ruleKey, ruleValue))
  }
}
