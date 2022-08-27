package codingPractice.sparkSql.windowFunctions

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.functions._

case class Salary(depName: String, empNo: Long, salary: Long)

object AggregateFunctions {

  val spark = SparkSession
    .builder()
    .appName("AggregateFunctions")
    .master("local")
    .getOrCreate()

  def main(args: Array[String]): Unit = {

    import spark.implicits._
    val empsalary = Seq(
      Salary("sales", 1, 5000),
      Salary("personnel", 2, 3900),
      Salary("sales", 3, 4800),
      Salary("sales", 4, 4800),
      Salary("personnel", 5, 3500),
      Salary("develop", 7, 4200),
      Salary("develop", 8, 6000),
      Salary("develop", 9, 4500),
      Salary("develop", 10, 5200),
      Salary("develop", 11, 5200)).toDF

    // find the max and min salary in each department

    val byDeptName = Window.partitionBy("depName")
    empsalary
      .withColumn("max_salary", max("salary")
        .over(byDeptName))
      .withColumn("min_salary", min("salary")
      .over(byDeptName))
      .show(false)
  }

}
