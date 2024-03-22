package basics.leetCode.easy

object Palindrom extends App {

  def isPalindrome(x: Int): Boolean = {
    val y = x.toString
    if(y.reverse == y) true else false
  }

  def isPalindrome1(x: Int): Boolean = {
    var n = x
    val temp = x
    var sum = 0

    while(n >0) {
      var r = n%10
      sum = sum*10 + r
      n = n/10
    }
    if(temp.equals(sum)) true else false
  }

  println(isPalindrome(121))
  println(isPalindrome1(121))
}
