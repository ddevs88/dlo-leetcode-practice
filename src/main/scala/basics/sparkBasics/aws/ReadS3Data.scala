package basics.sparkBasics.aws

import org.apache.spark.sql.SparkSession

object ReadS3Data extends App{

  val spark = SparkSession
    .builder()
    .master("local[1]")
    .appName("ReadS3Data")
    .getOrCreate()

  spark.sparkContext.hadoopConfiguration.set("fs.s3a.access.key", "AKIARHVJFCPR356XRC3P")
  spark.sparkContext.hadoopConfiguration.set("fs.s3a.secret.key", "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")
  spark.sparkContext.hadoopConfiguration.set("fs.s3a.endpoint", "s3.amazonaws.com")

  val rdd = spark.sparkContext
    .textFile("s3a://word-count-001/data1/helloCount.txt")

  val count = rdd.count()
  println(s"AWS-s3 count : $count")
}
