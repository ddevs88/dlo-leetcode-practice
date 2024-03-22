package basics.leetCode.easy

object DecompressRleList {

    def decompressRLElist(nums: Array[Int]): Array[Int] = {

      def helper(inpArr: Array[Int], acc: Array[Int]): Array[Int] = {
        if (inpArr.size == 0) {
          acc
        } else {
          helper(inpArr.slice(2, inpArr.length), acc ++ Array.fill(inpArr(0)){inpArr(1)})
        }
      }
      helper(nums, Array.empty[Int])
    }

  def main(args: Array[String]): Unit = {
    val nums = Array(1, 2, 3, 4)
    decompressRLElist(nums).foreach(println)
  }
}
