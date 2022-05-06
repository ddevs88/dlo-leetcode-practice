package handsOnScalaBook

import scala.collection.immutable.Range

/*
"Fizzbuzz" programming challenge:
Write a short program that prints each number from 1 to 100 on a new line.
For each multiple of 3, print "Fizz" instead of the number.
For each multiple of 5, print "Buzz" instead of the number.
For numbers which are multiples of both 3 and 5, print "FizzBuzz" instead of the number.*/

object FizzBuzz {

  def fizzBuzz: Unit = {
    for(i <- Range.inclusive(1,100)){
      if(i%3 == 0 && i%5 == 0) println("FizzBuzz")
      else if(i%3 == 0) println("Fizz")
      else if(i%5 == 0) println("Buzz")
      else println(i)
    }
  }

  def fizzBuzzIfElseExpr: Unit = {

    for(i <- Range.inclusive(1, 100))
    println(
      if(i%3 == 0 && i%5 == 0) "FizzBuzz"
      else if(i%3 == 0) "Fizz"
      else if(i%5 == 0) "Buzz"
      else i
    )
  }

  def main(args: Array[String]): Unit = {

    // fizzBuzz
    fizzBuzzIfElseExpr
  }
}
