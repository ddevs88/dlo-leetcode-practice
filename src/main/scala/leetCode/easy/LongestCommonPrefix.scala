package leetCode.easy

object LongestCommonPrefix extends App {

  def longestCommonPrefix(strs: Array[String]): String = {
    var res = ""
    println(strs.length)
      if(strs.length > 0){
        res = strs(0)
        for(i <- 1 until strs.length){
          println(i)
          while(!strs(i).startsWith(res)) {
            if(res.length > 1){
              res = res.substring(0, res.length - 1)
              println(res)
            }
            else{
              return ""
            }
          }
        }
      }
    res
  }

  println(longestCommonPrefix(Array("flower","flow","flight")))
  println("=====================================================")
  println(longestCommonPrefix(Array("reflower","flow","flight")))
  println("=====================================================")
  println(longestCommonPrefix(Array("dog","racecar","car")))

}
