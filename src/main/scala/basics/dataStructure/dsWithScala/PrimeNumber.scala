package basics.dataStructure.dsWithScala

object PrimeNumber {

  def main(args: Array[String]): Unit = {
    primes.take(5).foreach(println)
  }

  val primes: LazyList[Int] = 2 #:: LazyList.from(3)
    .filter{
      x => {
        val sqrtOfPrimes = primes.takeWhile(y =>
        y <= math.sqrt(x))
        !sqrtOfPrimes.exists( y => x % y == 0)
      }
    }

}
