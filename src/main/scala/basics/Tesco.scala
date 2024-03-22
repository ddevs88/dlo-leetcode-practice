package basics

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.{regexp_replace, split}
import org.apache.spark.sql.types.{DoubleType, StringType, StructField, StructType}

object Tesco {

  val spark = SparkSession
    .builder()
    .master("local")
    .appName("Tesco")
    .getOrCreate()

  def findFact(k: Int): Int = {
    if (k == 1) {
      1
    }
    else {
      k * findFact(k - 1)
    }
  }

  def findMax(l: List[Int]): Int = {
    var max = l(0)
    for (x <- l) {
      if (x > max) {
        max = x
      }
    }
    max
  }

  def printEvOdd(list: List[Int]): Unit = {
    for (x <- list) {
      x match {
        case x => if (x % 2 == 0) println(s"${x}:Even") else println(s"${x}:odd")
      }
    }
  }

  /*
val data=Seq(("abc","xyz@outlook.com"),
            ("bcd","pqr@gmail.com"),
            ("efg","lmn@yahoo.com"),
            ("edf","poc@apple.com"))
    id and domain to be printed from the above input
*/

  def main(args: Array[String]): Unit = {

    println(findFact(5))
    println(findMax(List(1, 2, 3, 4, 6, 7)))

    val list = List(1, 2, 3, 4, 6, 7)
    println(list.map(x => if (x % 2 == 0) x))
    println(list.filter(_ % 2 == 0))
    printEvOdd(list)

    import spark.implicits._
    val data = Seq(("abc", "xyz@outlook.com"),
      ("bcd", "pqr@gmail.com"),
      ("efg", "lmn@yahoo.com"),
      ("edf", "poc@apple.com")).toDF("id", "email")

    data.withColumn("domain",
      regexp_replace(split($"email", "@").getItem(1), ".com", "")
    )
      .select("id", "domain")
      .show(false)
  }


  val schema = StructType(
    Array(
      StructField("empName", StringType),
      StructField("age", DoubleType)
    )
  )
  /*val df = spark.read
    .option("header", true)
    .schema(schema)
    .csv("path")*/
}
