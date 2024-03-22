package basics.dataStructure.dsWithScala.list

abstract sealed class List[+A] {

  def head: A
  def tail:List[A]
  def isEmpty: Boolean

  def append[B>:A](x: B): List[B] =
    if(isEmpty) List.make(x)
    else List.make(head, tail.append(x))

  def prepend[B >: A](x: B): List[B] = List.make(x, this)

  def concat[B >: A](xs: List[B]): List[B] = {
    if(isEmpty) xs
    else tail.concat(xs).prepend(head)
  }

  def fail(m: String) = throw new NoSuchElementException(m)

  def remove[B >: A](x: B): List[B] = {
    if(isEmpty) fail(s"element ${x} is not found in List")
    else if(x != head) List.make(head, tail.remove(x))
    tail
  }

  //Search for nth element
  def apply(n: Int): A = {
    if(isEmpty) fail(s"Index out of bound")
    else if(n < 0) fail(s"Index is less then 0")
    else if(n==0) head
    else tail(n-1)
  }

  override def toString: String = {
    def loop(h: A, t: List[A], s: String): String =
      if (!t.isEmpty) loop(t.head, t.tail, s + h + ", ")
      else s + h

    if (isEmpty) "List[]"
    else "List[" + loop(head, tail, "") + "]"
  }
}
case object Nil extends List[Nothing] {
  def head: Nothing = fail("An empty list.")
  def tail: List[Nothing] = fail("An empty list.")
  def isEmpty: Boolean = true
}

case class Cons[A](head: A, tail: List[A]) extends List[A]{
  def isEmpty: Boolean = false
}

object List {

  def empty[A]: List[A] = Nil

  def make[A](x: A, t: List[A] = Nil): List[A] = Cons(x, t)

  def apply[A](xs: A*): List[A] = {
    var r: List[A] = List.empty
    for (x <- xs.reverse) r = r.prepend(x)
    r
  }
}
