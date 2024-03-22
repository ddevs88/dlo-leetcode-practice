package basics.dataStructure.dsWithScala.tree

import scala.collection.mutable

//Definition for a binary tree node.
 class TestNode(var data: Int=0, var left: TestNode = null, var right: TestNode = null) {

  var root: TestNode = null

  def buildTree(r: TestNode): TestNode={
    println("Enter Data:")
    val d = scala.io.StdIn.readInt()
    if(d == -1){
      null
    }
    else {
      val root = new TestNode(d)
      println(s"Inserting left of ${d}")
      root.left = buildTree(root.left)
      println(s"Inserting right of ${d}")
      root.right = buildTree(root.right)
      root
    }
  }

  def levelOrderTraversal(r: TestNode): List[TestNode]={
    val q = mutable.Queue[TestNode]()
    q.addOne(r)
    while(q.nonEmpty){
      val temp = q.front
      println(temp.data)
      if(temp.left != null){
        q.addOne(temp.left)
      }
      else if(temp.right !=null){
        q.addOne(temp.right)
      }
    }
    q.toList
  }

 }

object TestNode{
  def main(args: Array[String]): Unit = {
    val root: TestNode = null
    val obj = new TestNode()
    // 1 3 7 -1 -1 11 -1 -1 5 17 -1 -1 -1
    val res = obj.buildTree(root)

    println(obj.levelOrderTraversal(res))

  }
}


/*trait Node[T] {
  val value: T
  val children: Seq[Node[T]]
  def preOrder: Queue[T]
}

case class Tree[T](value: T, children: Seq[Node[T]]) extends Node[T] {
  def preOrder: Queue[T] = {
    @tailrec
    def inner(queue: Queue[T], nodes: Seq[Node[T]]): Queue[T] = nodes match {
      case Nil => queue
      case tn :: tns => inner(queue.enqueue(tn.value), tn.children ++ tns)
    }
    inner(Queue.empty.enqueue(value), children)
  }
}*/