package interviewQuestions.spark

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.functions.{collect_set, row_number}

object DistinctCites {

  val spark = SparkSession
    .builder()
    .appName("DistinctCities")
    .master("local")
    .getOrCreate()

  def main(args: Array[String]): Unit = {
    import spark.implicits._
    val data = Seq(
      ("bareilly"),
      ("blr"),
      ("blr"),
      ("pune"),
      ("pune"),
      ("bareilly")
    ).toDF("city")

    println("First: Using collect_set")
    data.select(collect_set("city")).show(false)

    println("Second: Using ROW_NUMBER")
    val windowSpec = Window.partitionBy("city").orderBy("city")
    val df = data.withColumn("rank", row_number().over(windowSpec))
      .where($"rank" === 1)
      .select("city")
    df.show(false)

    println("Third: Using intersect")
    data.intersect(data).show(false)
  }
}
