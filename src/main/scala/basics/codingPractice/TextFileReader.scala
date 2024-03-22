package basics.codingPractice

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.{explode, udf}

object TextFileReader {


  def main(args: Array[String]): Unit = {
    val spark = SparkSession
      .builder()
      .master("local")
      .appName("SQLPractice")
      .getOrCreate()

    spark.sparkContext.setLogLevel("ERROR")

    // val range = udf((i: Int, j: Int)=> (1 to i).toArray)
    val splitCol = udf((str: String) => {
      val n = str.length/15
      val arr = new Array[String](n)
      var start = 0
      var end = 15
      for(i <- 0 until n){
        arr(i) = str.substring(start, end)
        start+=15
        end+=15
      }
      arr
    })
    val df = spark.read.text("src/main/scala/basics/codingPractice/sparkSql/data.txt")

    import spark.implicits._
    df
      .withColumn("lines", explode(splitCol($"value")))
      .withColumn("id", $"lines".substr(0, 4))
      .withColumn("name", $"lines".substr(5, 3))
      .withColumn("city", $"lines".substr(8, 8))
      .drop("value", "lines")
      .show(false)

  }
}