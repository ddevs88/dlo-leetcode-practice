object InfoTest {

  def reverse(str: String): String = {
    val l = str.length
    var fstr = ""
    for(i <- l-1 to 0 by -1){
      fstr = fstr ++ str.charAt(i).toString
    }
    fstr
  }

  def findEqui(arr: Array[Int]): Int = {
    if(arr.length <=1) arr(0)
    else{
      val e = 0
      for(i <- 0 until arr.length-1){
        var left = sum(arr, e, i)
        var right = sum(arr, i+1, arr.length-1)
        if(left == right) {
         return i
        }
      }
      -1
  }

  }
  def sum(arr: Array[Int], start: Int, end: Int): Int = {
    var sum = 0
    for(i <- start to end){
      sum += arr(i)
    }
    println(sum)
    sum
  }

  // abc cba
  def checkAnagram(s1: String, s2: String): Boolean = {
    if(s1.length != s2.length) {
      false
    }
    else {
      var flag = true
      var arr = s2.toCharArray
      for(i <- 0 until s1.length-1){
        if(!arr.contains(s1.charAt(i))){
          flag = false
        }
      }
      flag
    }
  }


  def main(args: Array[String]): Unit = {
    val str = "hello"
    println(reverse(str))

    val arr = Array(1,2,3,1,1,1,0)
    println(findEqui(arr))

    val s1 = "abc"
    val s2 = "bcd"
    println(checkAnagram(s1, s2))

  }
}
