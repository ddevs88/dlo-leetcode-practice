

val counts = Array("900,google.com",
  "60,mail.yahoo.com",
  "10,mobile.sports.yahoo.com",
  "40,sports.yahoo.com",
  "10,stackoverflow.com",
  "2,en.wikipedia.org",
  "1,es.wikipedia.org",
  "1,mobile.sports")
val countsMap = counts.map(_.split(",")).map {
  case Array(s1,s2) => (s1,s2)}

val countForCom = countsMap.map{
  case(x, y) if(y.endsWith(".com")) => x.toInt
  case _ => 0
}.reduceLeft(_ + _)

val myWords = List("dog", "cat", "rat",
  "goat", "horse")

myWords groupBy(x => x.length)

def calFact(n: Int): Int = {
  if(n == 0 || n == 1) 1
  else {
    println("computing factorial")
    n * calFact(n-1)
  }
}
calFact(4)

val n=50/3
List.fill(n)(3)

