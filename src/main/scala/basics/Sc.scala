package basics

object Sc {

  /*
2. Given a string, write a function recurring_char to find its first recurring character.
Return None if there is no recurring character.
input = "interviewquery"
output = "i"
input = "interv"
output = "None"
*/

  def findOccur(str: String): Unit = {
    val len = str.toList
    var count = 1
    var res = len(0)
    while (count <= 1) {
      for (i <- len.indices) {
        for (j <- i + 1 until len.size - 1) {
          if (len(i) == len(j)) {
            println(s"${i}:${j}")
            res = len(i)
            count += 1
          }
        }
      }
    }
    if (count > 1) {
      println(count)
      println(res)
    }
    else {
      println("none")
    }
  }

  /*input : {3,4,5,6}
outpput : {1,2,3,5}*/
  // 0 1 1 2 3 5 8 13

  def createFeb(n: Int): Array[Int] = {
    var res = new Array[Int](n)
    res(0) = 0
    res(1) = 1
    for (i <- 2 until n) {
      res(i) = res(i - 1) + res(i - 2)
    }
    res
  }

  def getFeb(arr: Array[Int]): Array[Int] = {
    val res = new Array[Int](arr.length)
    for (x <- arr.indices) {
      res(x) = createFeb(arr(x)).last
    }
    res
  }


  def main(args: Array[String]): Unit = {
    //findOccur("nterviewquenryt")
    //findOccur("interv")
    //println(getFeb(Array(3, 4, 5, 10)).toList)
    println(createFeb(3).toList)
  }
}
