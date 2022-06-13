val list = 1:: List(2, 4 , List(3 , 5 , List(1) ) ,0 )
val  list1 = 2:: List(2, 4 , List(3 , 5 , List(1, List(9)) ) ,0 )

// Get numbers from a nested list to a single list
def flatList(list: List[_]): List[Any] = {
  list match {
    case Nil => Nil
    case (head: List[_]) :: tail => flatList(head) ::: flatList(tail)
    case head :: tail => head :: flatList(tail)
  }
}

flatList(list).foreach(println)
flatList(list1).foreach(println)