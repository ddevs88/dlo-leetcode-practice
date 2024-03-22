package basics.leetCode.easy

object LongestCommonPrefix extends App {

  def longestCommonPrefix(strs: Array[String]): String = {
    if(strs.length == 0) {return ""}
    var res = strs(0)
    for(i <- 1 until strs.length){
      while(strs(i).indexOf(res)!=0) {
        res = res.substring(0, res.length - 1)
      }
    }
    res
  }

  def longestCommonSuffix(strs: Array[String]): String = {
    if(strs.length == 0) {return ""}
    var res = strs(0).reverse
      for(i <- 1 until strs.length){
        while(strs(i).reverse.indexOf(res)!=0) {
          res = res.substring(0, res.length - 1)
        }
      }
    res.reverse
  }

  println(longestCommonSuffix(Array("abcded","def","hgded", "iklndef", "gghabc",
  "ytiabc", "ioabc")))
  println("=====================================================")
  println(longestCommonSuffix(Array("def","flidef", "likedef")))
  println("=====================================================")
  println(longestCommonPrefix(Array("dog","doecar","dogcar")))

}
