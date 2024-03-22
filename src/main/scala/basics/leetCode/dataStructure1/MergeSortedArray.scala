package basics.leetCode.dataStructure1

object MergeSortedArray {

  def merge(a1: Array[Int], m: Int, a2: Array[Int], n: Int): Array[Int]={
    var i, j, k = 0
    val res = new Array[Int](m+n)
    // Array(1,2,3), Array(2,5,6))
    while(i<m && j<n){
      if(a1(i)<a2(j)){
        res(k) = a1(i)
        i+=1
        k+=1
      }
      else{
        res(k) = a2(j)
        j+=1
        k+=1
      }
    }
    while(i<m){
      res(k) = a1(i)
      i+=1
      k+=1
    }
    while(j<n){
      res(k) = a2(j)
      j+=1
      k+=1
    }
    res
  }

  def mergeNew(a1: Array[Int], m: Int, a2: Array[Int], n: Int): Array[Int]={
    var i, j, k = 0
    // Array(1,2,3), Array(2,5,6))
    while(i<m && j<n){
      if(a1(i)<a2(j)){
        a1(k) = a1(i)
        i+=1
        k+=1
      }
      else{
        a1(k) = a2(j)
        j+=1
        k+=1
      }
      println(a1.toList)
    }
    while(i<m){
      a1(k) = a1(i)
      i+=1
      k+=1
    }
    while(j<n){
      a1(k) = a2(j)
      j+=1
      k+=1
    }
    a1
  }

  def main(args: Array[String]): Unit = {
    println(merge(Array(1,2,3), 3, Array(2,5,6), 3).toList)
    println(mergeNew(Array(1,2,3,0,0,0), 3, Array(2,5,6), 3).toList)
  }
}
