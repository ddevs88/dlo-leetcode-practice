package basics.sparkBasics

import org.apache.spark.sql.SparkSession

object SparkSessionTes extends App {
  def spark = SparkSession.builder()
    .master("local[1]")
    .appName("SparkByExamples.com")
    .getOrCreate();
  /*println(spark)
  println("spark session created with Version : "+spark.version)*/
}

