package basics.codingPractice.sparkSql

import org.apache.spark.sql.{Row, SparkSession}
import org.apache.spark.sql.types._

import java.sql.Date


object SqlTop10 extends App {

  def intFormat(str: String): Int = {
    try {
      str.toInt
    }
    catch {
      case _: NumberFormatException => -1
    }
  }

  def doubleFormat(str: String): Double = {
    try {
      str.toDouble
    }
    catch {
      case _: NumberFormatException => -1.0
    }
  }

  def dateFormat(str: String): Date = {
    try {
      Date.valueOf(str)
    }
    catch {
      case _: Exception => Date.valueOf("2022-06-13")
    }
  }


  val spark = SparkSession
    .builder()
    .config("spark.sql.warehouse.dir", "src/main/scala/basics.codingPractice/sparkSql/warehouse")
    .master("local[1]")
    .appName("SqlTop10")
    .getOrCreate()

  val input = spark.sparkContext.textFile("src/main/scala/basics.codingPractice/sparkSql/data/employee")

  val rddOfRow = input.map(line => line.split("\\|"))
    .map(arr => Row(intFormat(arr(0).trim), arr(1).trim, arr(2).trim, intFormat(arr(3).trim),
      dateFormat(arr(4).trim), doubleFormat(arr(5).trim), doubleFormat(arr(6).trim), intFormat(arr(7).trim)))

  val schema = StructType(
    Array(
      StructField("emp_id", IntegerType),
      StructField("emp_name", StringType),
      StructField("job_name", StringType),
      StructField("manager_id", IntegerType),
      StructField("hire_date", DateType),
      StructField("salary", DoubleType),
      StructField("commission", DoubleType),
      StructField("dep_id", IntegerType)
    )
  )

  val df = spark.createDataFrame(rddOfRow, schema)

  println("========Applied schema using StructType=============")
  df.schema.printTreeString()
  df.show(false)

  // Applying schema using case class
  case class Employee(
                       emp_id: Int,
                       emp_name: String,
                       job_name: String,
                       manager_id: Int,
                       hire_date: Date,
                       salary: Double,
                       commission: Double,
                       dep_id: Int
                     )

  val rddOfEmployee = input.map(line => line.split("\\|"))
    .map(arr => Employee(intFormat(arr(0).trim), arr(1).trim, arr(2).trim, intFormat(arr(3).trim),
      dateFormat(arr(4).trim), doubleFormat(arr(5).trim), doubleFormat(arr(6).trim), intFormat(arr(7).trim)))

  val empDf = spark.createDataFrame(rddOfEmployee)
  println("=========Apllied schema using case class=========")
  empDf.schema.printTreeString()
  empDf.show(false)


  // SQL query
  /*write a SQL query to find those employees whose salaries are greater than the salaries of their managers. */
  empDf.createTempView("employee_table")
  empDf.createTempView("manager_table")

  println("Result: query1")
  spark.sql("select * " +
    "from employee_table e, manager_table m " +
    "where e.manager_id = m.emp_id " +
    "and e.salary > m.salary")
    .show(false)

  spark.sql("select * " +
    "from employee_table e, manager_table m " +
    "where e.manager_id = m.emp_id ").show(false)

  spark.sql("select id")
}