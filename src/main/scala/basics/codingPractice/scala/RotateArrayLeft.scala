package basics.codingPractice.scala

object RotateArrayLeft extends App{

  def rotateLeft[A](n: Int, list: List[Int]): List[Int]={
    val nbound = if(list.isEmpty) 0 else n%list.length
    if(nbound < 0) rotateLeft(nbound+list.length, list)
    else (list.drop(nbound)):::(list.take(nbound))
  }

  println(rotateLeft(3, List(3, 2, 5, 6, 4, 1)))

}
