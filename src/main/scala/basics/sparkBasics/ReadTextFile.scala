package basics.sparkBasics

import org.apache.spark.sql.{Row, SparkSession}
import org.apache.spark.sql.types.{StringType, StructField, StructType}
import basics.sparkBasics.schema.User

object ReadTextFile extends App {

  val spark = SparkSession
    .builder()
    .master("local[1]")
    .appName("ReadTexFile")
    .getOrCreate()

  val schemaString = spark
    .read.textFile("src/main/scala/basics.sparkBasics/resources/userData")
    .collect.head

  println(s"schemaString: ${schemaString}")

  val schemas = StructType(
    schemaString.split(" ").map(f => StructField(f, StringType, false))
  )

  val header = spark.sparkContext
    .textFile("src/main/scala/basics.sparkBasics/resources/userData")
    .first()

  val rows = spark.sparkContext
    .textFile("src/main/scala/basics.sparkBasics/resources/userData")
    .filter(line => line != header)
    .map(line => Row.fromSeq(line.split(" ")))


  spark.createDataFrame(rows, schemas)
    .show()


  val dataUsingCaseClass =
    spark.sparkContext
      .textFile("src/main/scala/basics.sparkBasics/resources/userData")
      .filter(line => line != header)
      .map(line => line.split(" "))
      .map(line => User(Some(line(0)), Some(line(1))))

  val df = spark.createDataFrame(dataUsingCaseClass)
  df.show()

  /*df.coalesce(1)
    .write
    .option("header","true")
    .option("sep",",")
    .mode("overwrite")
    .csv("src/main/scala/basics.sparkBasics/resources/")*/






}


