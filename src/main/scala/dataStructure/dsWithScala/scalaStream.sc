val myStream = LazyList("message1", "message2",
  "message3")

val myNums = List(1,2,3,4,5,6,7,8,9)
myNums.sliding(2, 1).toList
myNums.sliding(3, 1).toList
myNums.sliding(2, 2).toList

val primes = LazyList(2) ++ LazyList()
primes.foreach(print)

