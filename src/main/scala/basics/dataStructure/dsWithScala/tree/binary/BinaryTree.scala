package basics.dataStructure.dsWithScala.tree.binary

sealed trait BinaryTree[+A]
case object Leaf extends BinaryTree[Nothing]
case class Branch[A](value: A, left: BinaryTree[A], right: BinaryTree[A]) extends BinaryTree[A]

object BinaryTreeApp {
  def main(args: Array[String]): Unit = {
    val myList: List[Int] = List(1,2,3,4,5,6)
    val myBinaryTree = createTree(myList)
    println(s"Size of the tree: ${size(myBinaryTree)}")
    println(s"Depth of the tree: ${depth(myBinaryTree)}")
    println(s"pre-order:${preorder(myBinaryTree)}")
    println(s"in-order:${inorder(myBinaryTree)}")
    println(s"post-order:${postorder(myBinaryTree)}")
    println(s"find max path sum: ${findMaxPathSum(myBinaryTree)}")

  }

  def createTree[A](list: List[A]): BinaryTree[A]={
    list match {
      case Nil => Leaf
      case x :: xs => {
        val halfLength = xs.length/2
        Branch(x, createTree(xs.take(halfLength)), createTree(xs.drop(halfLength)))
      }
    }
  }

  def size[A](binTree: BinaryTree[A]): Int = {
    binTree match {
      case Leaf => 0
      case Branch(_, leftBranch, rightBranch) => {
        1 + size(leftBranch)+size(rightBranch)
      }
    }
  }

  def depth[A](binTree: BinaryTree[A]): Int = {
    binTree match {
      case Leaf => 0
      case Branch(_, left, right) => {
        1 + (depth(left) max depth(right))
      }
    }
  }

  //pre-order traversal
  def preorder[A](binTree: BinaryTree[A]): List[A]={
    binTree match {
      case Leaf => Nil
      case Branch(value, left, right) =>
        value :: (preorder(left) ++ preorder(right))
    }
  }

  //in-order traversal
  def inorder[A](binaryTree: BinaryTree[A]): List[A]={
    binaryTree match {
      case Leaf => Nil
      case Branch(value, left, right) =>
        inorder(left) ++ (value :: inorder(right))
    }
  }

  //post-order traversal
  def postorder[A](binTree: BinaryTree[A]): List[A]={
    binTree match {
      case Leaf => Nil
      case Branch(value, left, right) => (postorder(left)++postorder(right)) ++ List(value)
    }
  }

  //find max path sum
  def findMaxPathSum[A](root: BinaryTree[A]): Int = {
    var res = 0
    root match {
      case Leaf => 0
      case Branch(value, left, right) => {
        var leftMax = findMaxPathSum(left)
        var rightMax = findMaxPathSum(right)
        leftMax = Math.max(leftMax, 0)
        println(s"leftMax:${leftMax}")
        rightMax = Math.max(rightMax, 0)
        println(s"rightMax:${leftMax}")
        res = Math.max(res, leftMax+rightMax)
        res
      }
    }
  }
}
