// Higher order function that return a function
(i: Int) => i%2 == 0

// _ % 2 == 0

val oneToTen = List.range(0, 10)
val evens = oneToTen.filter(_ % 2 == 0)

//foreach
val zahlen = Vector("Eins", "Zwei", "Drei")
zahlen.foreach(println)
zahlen.foreach(s=>println(s))

//for/yield construct is called for comprehension
val smack = Array("Spark", "Mesos", "Akka", "Cassandra", "Kafka")

for(x <- smack) yield x.toUpperCase

val smack1 = Map("S" ->"Spark", "M" -> "Mesos", "A" -> "Akka", "C" ->"Cassandra", "K" -> "Kafka")

for ((k, v) <- smack1) println(s"${k}, ${v}")

//Iterators in scala
val iter = Iterator("S","M","A","C","K")
iter.foreach(println)

//Mapping
val smack2 = Vector("spark", "mesos", "akka", "cassandra", "kafka")
// smack2.map(x => <li>{smack}</li>)

smack2.map(_.toUpperCase)

//Flattening
val allies = List(List("Java","Scala"), List("Javascript","PHP"))
allies.flatten
allies.flatten.map(_.toUpperCase).sorted

val stuff = List("SMACK", "Scala")
stuff.flatten
stuff.flatten.map(_.toUpper).sorted

val boxes = Vector(Some("Something"), None, Some(3.14), None)
boxes.flatten

//Extracting
val magic = (0 to 9).toArray
magic.drop(3)
magic.dropWhile(_ < 8)
magic.headOption

//spiltting
val sample = List(-12, -9, -3, 12, 18, 15)
sample.groupBy(_>10)

val t = res15(true)
sample.partition(_>10)
res16._1
res16._2

//Unicity
//If you want to remove duplicates in a collection, only use unique elements. The following are some examples.
val duplicated = List("A", "Y", "Y", "X", "X", "Z")
duplicated.distinct
duplicated.toSet

//Merging
// The ++= method could be used in any mutable collection
val nega = collection.mutable.ListBuffer(-30, -20, -10)
nega ++= Seq(10, 20, 30)


//Sorting
List("San Francisco", "London", "New York", "Tokio").sortWith(_ < _)

List("San Francisco", "London", "New York", "Tokio").sortWith(_.length < _.length)


//Stack
import scala.collection.mutable.Stack
var smack = Stack[String]()
smack.push("Hi")
smack.push(", Sir")

Array("flower","flow","flight").sortWith(_.length < _.length)

