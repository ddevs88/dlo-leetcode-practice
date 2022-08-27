package dataStructure.dsWithScala.fundamentalAlgorithms

object PrimeNumber {

  val primes: LazyList[Int] = 2 #:: LazyList.from(3)
    .filter{
      x => {
        val sqrtOfPrimes = primes.takeWhile(y => y <= math.sqrt(x))
        !sqrtOfPrimes.exists(y => x%y == 0)
      }
    }

  def checkPrime(x: Int): Boolean = {
    val primes = 2 #:: LazyList.from(3)
    val sqrtOfPrimes = primes.takeWhile(y => y <= math.sqrt(x))
    !sqrtOfPrimes.exists(y => x%y == 0)
  }

  def checkPrimeFor(x: Int): Boolean = {
    val l = x/2
    var count = 0
    for(i <- 2 until l){
      if(x%i == 0){
        count = count +1
      }
    }
    if(count > 0){
      false
    }
    else{
      true
    }
  }

  def main(args: Array[String]): Unit = {

    val t1 = System.currentTimeMillis()
    println(primes.take(100).toList)
    val t2 = System.currentTimeMillis()
    println(t2-t1)

    val t3 = System.currentTimeMillis()
    println(checkPrime(999999999))
    val t4 = System.currentTimeMillis()
    println(t4-t3)


    val t5 = System.currentTimeMillis()
    println(checkPrimeFor(999999999))
    val t6 = System.currentTimeMillis()
    println(t6-t5)

  }
}
