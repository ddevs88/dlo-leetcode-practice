package leetCode.easy

class ListNode(_x: Int = 0, _next: ListNode = null) {
  var next: ListNode = _next
  var x: Int = _x
  }

object MergeTwoLists extends ListNode {

  def mergeTwoLists(i: List[Int], j: List[Int]): List[Int] = {
    (i, j) match {
      case (Nil, Nil) => Nil
      case (x :: xs, Nil) => i
      case (Nil, y :: ys) => j
      case (x :: xs, y :: ys) => {
        if (x <= y)
          x :: mergeTwoLists(i.tail, j)
        else
          y :: mergeTwoLists(i, j.tail)
      }
    }
  }

  def mergeTwoListsLeetCode(l1: ListNode, l2: ListNode): ListNode = {

    (l1, l2) match {
      case (null, null) => null
      case (null, l2) => l2
      case (l1, null) => l1
      case (l1, l2) => {
        if(l1.x < l2.x) {
          new ListNode(l1.x, mergeTwoListsLeetCode(l1.next, l2))
        }
        else{
          new ListNode(l2.x, mergeTwoListsLeetCode(l1, l2.next))
        }
      }
    }
  }

  def main(args: Array[String]): Unit = {
    val l1 = List(1,2,4)
    val l2 = List(1,3,4)

    println(mergeTwoLists(l1, l2))
  }
}
