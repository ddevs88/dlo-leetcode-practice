package basics.codingPractice.sparkSql.windowFunctions

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.functions._

/*
cume_dist
first_value
last_value
lag
lead
*/

object AnalyticalFunctions {

  val spark = SparkSession
    .builder()
    .appName("AnalyticalFunctions")
    .master("local")
    .getOrCreate()

  def main(args: Array[String]): Unit = {

    val data = Seq(
      (8,444,10000),
      (5,111,50000),
      (6,111,90000),
      (1,111,100000),
      (7,333,110000),
      (2,111,150000),
      (3,222,150000),
      (4,222,250000),
      (5,222,890000)
    )
    val rdd = spark.sparkContext.parallelize(data)

    import spark.implicits._
    val df = rdd.toDF("pat_id", "dept_id", "ins_amt")

    val windowSpec = Window.orderBy("ins_amt") //rank
    val windowSpec1 = Window.partitionBy("dept_id").orderBy("ins_amt") //dense_rank
    val windowSpec2 = Window.orderBy("ins_amt") // percent_rank

    //rank
    df.withColumn("rk", rank().over(windowSpec))
      .show(false)

    //dense_rank
    df.withColumn("dense_rank", dense_rank().over(windowSpec1))
      .show(false)

    //percent_rank
    df.withColumn("percent_rank", percent_rank().over(windowSpec2))
      .show(false)

    //ntile
    df.withColumn("ntile", ntile(4).over(Window.orderBy("ins_amt")))
      .show(false)

    //row_number
    df.withColumn("row_num", row_number().over(Window.orderBy("ins_amt")))
      .show(false)

    //cume_dist -- The CUME_DIST calculates the cumulative distribution of a value in a group of values. The range of values returned by CUME_DIST is >0 to <=1.
    // Tie values always evaluate to the same cumulative distribution value.
    df.withColumn("cume_dist", cume_dist().over(Window.orderBy("ins_amt")))
      .show(false)

    //first and last
    df.withColumn("low_ins_amt", first("ins_amt")
      .over(
        Window
          .partitionBy("dept_id")
          .orderBy("ins_amt")))
      .withColumn("high_ins_amt", last("ins_amt")
        .over(
          Window
            .partitionBy("dept_id")
            .orderBy("ins_amt")))
      .show(false)

    //lead and lag
    df.withColumn("lead", lead("ins_amt", 1, 0)
      .over(
        Window
          .partitionBy("dept_id")
          .orderBy("ins_amt")))
      .withColumn("lag", lag("ins_amt", 1, 0)
        .over(
          Window
            .partitionBy("dept_id")
            .orderBy("ins_amt")))
      .show(false)

    /*Just like Apache Hive, you can write Spark SQL query to calculate cumulative sum.
    Syntax is similar to analytic functions, only difference is you have to include
    ‘unbounded preceding’ keyword with window specs.*/
    df.withColumn("ins_sum", sum("ins_amt")
      .over(
        Window
          .partitionBy("dept_id")
          .orderBy("ins_amt")
          .rowsBetween(0, 1)

      ))
      .withColumn("lag", lag("ins_amt", 1, 0)
        .over(
          Window
            .partitionBy("dept_id")
            .orderBy("ins_amt")))
      .show(false)

    //Custom window functions

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

    val customWinSpec = Window
      .partitionBy($"depName")
      .orderBy($"salary")
      .rangeBetween(100L, 300L)

    println("Custom window functions::")
    empsalary.withColumn("max_salary", max("salary").over(customWinSpec))
      .show(false)

    val unboundedWinSpec = Window
      .partitionBy($"depName")
      .orderBy($"salary")
      .rangeBetween(300L, Window.unboundedFollowing)

    empsalary.withColumn("max_salary", max("salary").over(unboundedWinSpec))
      .show(false)

  }
}
