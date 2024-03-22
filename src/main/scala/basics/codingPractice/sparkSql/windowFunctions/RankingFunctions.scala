package basics.codingPractice.sparkSql.windowFunctions

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.functions.{col, dense_rank, ntile, percent_rank, rank, row_number}

// case class Salary(depName: String, empNo: Long, salary: Long)

object RankingFunctions {

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

    //The employee with the highest salary will have rank 1,
    // and the one with the least salary will rank last.
    // Here we will partition the data based on department (column: depname)
    // and within the department, we will sort the data based on salary in descending order.
    val winSpec = Window.partitionBy($"depName").orderBy(col("salary").desc)
    empsalary
      .withColumn("rank", rank.over(winSpec))
      .withColumn("dense_rank", dense_rank().over(winSpec))
      .withColumn("row_num", row_number().over(winSpec))
      .withColumn("percent_rank", percent_rank().over(winSpec))
      .withColumn("ntile", ntile(3).over(winSpec))
      .show(false)

  }
}
