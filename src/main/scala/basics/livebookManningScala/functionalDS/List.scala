package basics.livebookManningScala.functionalDS

sealed trait List[+A]
case object Nil extends List[Nothing]
case class Cons[A](head: A, tail: List[A]) extends List[A]


object List {

  def apply[A](as: A*): List[A]={
    if(as.isEmpty){
      Nil
    }
    else {
      Cons(as.head, apply(as.tail: _*))
    }
  }

  def sum[A](as: List[Int]): Int ={
    as match {
      case Nil => 0
      case Cons(head, tail) => head + sum(tail)
    }
  }

  def product[A](ds: List[Double]): Double = {
    ds match {
      case Nil => 1.0
      case Cons(0.0, _) => 0.0
      case Cons(head, tail) => head * product(tail)
    }
  }

  def append[A](l1: List[A], l2: List[A]): List[A]={
    l1 match {
      case Nil => l2
      case Cons(h, t) => Cons(h, append(t, l2))
    }
  }

  def dropWhile[A](list: List[A])(f: A => Boolean): List[A]={
    list match {
      case Cons(h, t) if f(h) => dropWhile(t)(f)
      case _ => list
    }
  }

  def foldRight[A, B](as: List[A], z: B)(f: (A,B)=> B): B ={
    as match {
      case Nil => z
      case Cons(h, t) => f(h, foldRight(t, z)(f))
    }
  }

  def sumWithFold(as: List[Int]): Int= {
    foldRight(as, 0)((x, y) => x + y)
  }

  def productWithFold(as: List[Int]): Int= {
    foldRight(as, 1)((x, y) => x * y)
  }
}

object ListApp extends App{
  //Creating list
  println(List(1, 2, 3))
  //sum of list elements
  println(List.sum(List(1, 2, 3)))
  //product of elements
  println(List.product(List(1.0, 2.0, 3.0, 4)))
  //append two list
  println(List.append(List(1, 2, 3), List(1, 2, 3)))
  //drop while
  val xs = List(1, 2, 3, 4, 5)
  println(List.dropWhile(xs)(x => x<4))
  println(List.sumWithFold(xs))
  println(List.productWithFold(xs))
}
