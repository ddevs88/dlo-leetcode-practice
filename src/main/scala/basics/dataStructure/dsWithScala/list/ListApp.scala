package basics.dataStructure.dsWithScala.list

object ListApp extends App {

  //Test Append
  println(List(1,2,3).append(4))

  //Test concat
  val list1 = List(1,2,3)
  val list2 = List(4,5,6)
  println(s"Concat two list: ${list1.concat(list2)}")
  println(s"2nd element in list1: ${list1(1)}")
}
