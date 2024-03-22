package basics.sparkBasics.spark.sql

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.functions.{rank, row_number}

object WindowFunctions extends App {

  val spark = SparkSession
    .builder()
    .master("local[1]")
    .appName("WindowFunctions")
    .getOrCreate()

  import spark.implicits._

  val simpleData = Seq(("James", "Sales", 3000),
    ("Michael", "Sales", 4600),
    ("Robert", "Sales", 4100),
    ("Maria", "Finance", 3000),
    ("James", "Sales", 3000),
    ("Scott", "Finance", 3300),
    ("Jen", "Finance", 3900),
    ("Jeff", "Marketing", 3000),
    ("Kumar", "Marketing", 2000),
    ("Saif", "Sales", 4100))

  val df = simpleData.toDF("employee_name", "department", "salary")
  df.show()

  // row_number Window Function
  val windowSpec = Window.partitionBy("department").orderBy("salary")
  df.withColumn("row_number", row_number.over(windowSpec))
    .filter($"row_number" === 1)
    .drop("row_number")
    .show(false)

  // rank Window Function
  df.withColumn("rank", rank.over(windowSpec))
    // .filter($"rank" === 1)
    // .drop(rank)
    .show(false)
}
