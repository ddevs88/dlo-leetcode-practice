package basics.dataStructure.dsWithScala.tree

import scala.annotation.tailrec
import scala.language.postfixOps

trait TreePreorder[+A] {
  def value: Option[A] = this match {
    case n: Node[A] => Some(n.v)
    case l: Leaf[A] => Some(l.v)
    case Empty => None
  }

  def left: Option[TreePreorder[A]] = this match {
    case n: Node[A] => Option(n.l)
    case l: Leaf[A] => None
    case Empty => None
  }

  def right: Option[TreePreorder[A]] = this match {
    case n: Node[A] => Option(n.r)
    case l: Leaf[A] => None
    case Empty => None
  }

  private case class Eval[A](v: A) extends TreePreorder[A]

  @tailrec
  private def foldLoop[A, B]
  (a: List[TreePreorder[A]], z: B)
  (f: (B, A)=> B)
  (o: (Node[A], List[TreePreorder[A]]) => List[TreePreorder[A]]): B = a match {
    case (n: Node[A])::tl => foldLoop(o(n, tl), z)(f)(o)
    case (l: Leaf[A])::tl => foldLoop(tl, f(z, l.v))(f)(o)
    case (e: Eval[A])::tl => foldLoop(tl, f(z, e.v))(f)(o)
    case Empty::tl => foldLoop(tl, z)(f)(o)
    case _ => z
  }

  def foldPreorder[B](z: B)(f: (B,A)=> B):B ={
    foldLoop(List(this), z)(f){(n, tl) => Eval(n.v)::n.l::n.r::tl}
  }

  def toSeqPreorder: Seq[A] = foldPreorder(List[A]()) { (l, v) => v :: l } reverse
}

case class Node[A](v: A, l: TreePreorder[A], r: TreePreorder[A]) extends TreePreorder[A]
case class Leaf[A](v: A) extends TreePreorder[A]
case object Empty extends TreePreorder[Nothing]

object Run extends App {
  println("Hello Tree Test!")
  /*val t: TreePreorder[Int] = Node(6, Node(2, binary.Leaf(1), Node(4, binary.Leaf(3), binary.Leaf(5))), Node(7, Empty, Node(10, binary.Leaf(9), Empty)))

  for {
    b <- t.left
    value <- b.value
  } println("B node: " + value)

  println("as seqPreorder: " + t.toSeqPreorder)*/
}
