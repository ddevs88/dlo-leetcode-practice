package basics.leetCode.dataStructure1

class ListNode(_x: Int=0, _next: ListNode=null){
  var next: ListNode = _next
  var x: Int = _x
}
object AddTwoNumbers {

  def addTwoNumbers(l1: ListNode, l2: ListNode): ListNode={
    var n1 = l1
    var n2 = l2
    var head: ListNode = null
    var temp: ListNode = null
    var carry = 0

    while(n1 != null || n2 != null){
      var sum = carry
      if(n1!=null){
        sum+=n1.x
        n1 = n1.next
      }
      if(n2 != null){
        sum+=n2.x
        n2 = n2.next
      }

      var node = new ListNode(sum%10)
      carry = sum/10
      if(temp==null){
        head = node
        temp = head
      }
      else {
        temp.next = node
        temp = temp.next
      }
    }
    if(carry > 0){
      temp.next = new ListNode(carry)
    }
    head
  }
  def main(args: Array[String]): Unit = {

  }
}
