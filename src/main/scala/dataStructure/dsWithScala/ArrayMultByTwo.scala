package dataStructure.dsWithScala

object ArrayMultByTwo extends App{

  val arr = Array(1, 2, 3, 4)

  def arrayMultByTwo(arr: Array[Int]): Array[Int] = {
    val len = arr.length
    val tempArr = new Array[Int](len)
    var i = 0
    while(i < len) {
      tempArr(i) = arr(i)*2
      i += 1
    }
    tempArr
  }

  arrayMultByTwo(arr).foreach(println)
  println("========")
  arr.map(n => n*2).foreach(println)

  val fruits = Array("banana", "apple","orange")

  println(s"Apple present in array: ${fruits.exists(_ == "apple")}")

  val counts = Array("900,google.com",
    "60,mail.yahoo.com",
    "10,mobile.sports.yahoo.com",
    "40,sports.yahoo.com",
    "10,stackoverflow.com",
    "2,en.wikipedia.org",
    "1,es.wikipedia.org",
    "1,mobile.sports")

  val countsMap = counts.map(_.split(",")).map{
    case Array(s1, s2) => (s1, s2)
  }
  counts.foreach(println)

}
