package basics.dataStructure.dsWithScala.searching

object BinarySearch {

  def binarySearch(a: Array[Int], n: Int): Int = {
    var start = 0
    var end = a.length
    var mid = (start + end)/2
    while(end > start && a(mid) != n){
      if(n < a(mid)){
        end = mid
      }
      else{
        start = mid + 1
      }
      mid = (start + end)/2
    }
    if(end > start) mid else -1
  }

  // Using recursive approach
  def binarySearch2(a: Array[Int], n: Int): Int = {
    def binarySearchRec(a: Array[Int], n: Int, start: Int, end: Int): Int = {
      if(end <= start) -1
      else {
        val mid = (start+end)/2
        if(n == a(mid)) mid
        else if(n < a(mid)) binarySearchRec(a, n, start, mid)
        else binarySearchRec(a, n, mid+1, end)
      }
    }
    binarySearchRec(a, n, 0, a.length)
  }

  def main(args: Array[String]): Unit = {
    val arr = Array(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
    println(binarySearch(arr, 4))
    println(binarySearch2(arr, 4))
  }
}
