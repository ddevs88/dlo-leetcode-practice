package basics.codingPractice.scala

object FlattenList extends App{

  def flatList[A](list: List[Any]): List[Any]={
    list flatMap {
      case ms: List[_] => flatList(ms)
      case e => List(e)
    }
  }

  println(flatList(List(1, List(2,3), List(4, List(5,6)))))
}
