package basics.interviewQuestions.scala

object PrintArray {

  def generateArray(arr: Array[Int]): Array[Int]={
    val l = arr.length
    println(l)
    val res = new Array[Int](l)
    val sortedArr = arr.sorted
    println(sortedArr.toList)
    var arrIndex = 0
    for(i <- 1 to l/2){
      if(arrIndex < l){
        res(arrIndex) = sortedArr(i-0)
        arrIndex+=1
      }

      if(arrIndex <= l){
        res(arrIndex) = sortedArr(l-i)
        arrIndex+=1
      }
    }
    res
  }

  def main(args: Array[String]): Unit = {
    val arr = Array(5, 8, 1, 4, 2, 9, 3, 7, 6)
    println(generateArray(arr).toList)
  }
}
