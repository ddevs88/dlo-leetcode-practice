package basics.codingPractice.sparkSql.sqlJoins

import org.apache.spark.sql.{DataFrame, SparkSession}
import org.apache.spark.sql.functions.{col, lit}

import java.sql.Date

case class Salesman(salesman_id: Int, name: String, city: String, commission: Double)
case class Customer(customer_id: Int, cust_name: String, city: String, grade: Int,salesman_id: Int)

object SqlJoins extends App{

  val spark = SparkSession
    .builder()
    .config("spark.sql.warehouse.dir", "src/main/scala/basics.codingPractice/sparkSql/warehouse")
    .master("local[1]")
    .appName("SqlJoins")
    .getOrCreate()

  spark.sparkContext.setLogLevel("ERROR")

  def intFormat(str: String): Int = {
    try{
      str.toInt
    }
    catch {
      case _ : NumberFormatException => -1
    }
  }

  // Salesman
  val salesmanInput = spark
    .sparkContext
    .textFile("src/main/scala/basics.codingPractice/sparkSql/sqlJoins/data/salesman.txt")
    .map(line => line.split("\\|"))
    .map(rec => Salesman(rec(0).trim.toInt, rec(1).trim, rec(2).trim, rec(3).trim.toDouble))

  val salesmanDf = spark.createDataFrame(salesmanInput)
  salesmanDf.show(false)
  spark.createDataFrame(salesmanInput).createTempView("salesman_table")

  //Customer
  val customerInput = spark
    .sparkContext
    .textFile("src/main/scala/basics.codingPractice/sparkSql/sqlJoins/data/customer")
    .map(line => line.split("\\|"))
    .map(rec => Customer(rec(0).trim.toInt, rec(1).trim, rec(2).trim, intFormat(rec(3).trim), rec(4).trim.toInt))

  val customerDf = spark.createDataFrame(customerInput)
  customerDf.show(false)
  spark.createDataFrame(customerInput).createTempView("customer_table")

  /*Queries*/
  // 1. From the following tables write a SQL query to find the salesperson and customer who reside in the same city.
  // Return Salesman, cust_name and city.
  println("=====Query-1============")
  spark.sql("select * from salesman_table").show(false)
  spark.sql("select * from customer_table").show(false)
  spark.sql("select s.name as Salesman, c.cust_name, c.city " +
    "from salesman_table s, customer_table c " +
    "where s.city = c.city").show(false)

  println("=========Using Dataframe=============")
  salesmanDf.join(customerDf, salesmanDf.col("city") === customerDf.col("city"))
    .drop(salesmanDf.col("city"))
    .withColumnRenamed("name", "Salesman")
    .select("Salesman", "cust_name", "city")
    .show(false)

  /* 2. From the following tables write a SQL query to find those orders where the order amount exists between 500 and 2000.
   Return ord_no, purch_amt, cust_name, city.*/

  case class Orders(ord_no: Int, purch_amt: Double, ord_date: Date, customer_id: Int, salesman_id: Int)
  val ordersInput = spark.sparkContext.textFile("src/main/scala/basics.codingPractice/sparkSql/sqlJoins/data/orders")
    .map(line => line.split(","))
    .map(
      rec =>
        Orders(
          rec(0).trim.toInt,
          rec(1).trim.toDouble,
          Date.valueOf(rec(2).trim),
          rec(3).trim.toInt,
          rec(4).trim.toInt
        )
    )
  val ordersDf = spark.createDataFrame(ordersInput)
  ordersDf.createTempView("orders_table")
  println("=============Query2===================")
  ordersDf.show(false)

  /*case class Customer1(customer_id: Int, cust_name: String, city: String, grade: Int, salesman_id: Int )
  val customer1Df = spark
    .read
    .option("header", true)
    .option("inferSchema", true)
    .option("sep", ",")
    .csv("src/main/scala/basics.codingPractice/sparkSql/sqlJoins/data/customer1.csv")
    .as(ExpressionEncoder[Customer])
  customer1Df.show(false)*/

  ordersDf
    .join(customerDf, ordersDf.col("customer_id") === customerDf.col("customer_id"))
    .where(col("purch_amt") >= lit(500) && col("purch_amt") <= lit(2000))
    .select("ord_no", "purch_amt", "cust_name", "city")
    .show(false)


  /* 3. From the following tables write a SQL query to find the salesperson(s) and the customer(s) he represents.
   Return Customer Name, city, Salesman, commission.*/
  println("==============Query3=================")
  salesmanDf
    .drop("city")
    .join(customerDf, salesmanDf.col("salesman_id") === customerDf.col("salesman_id"),
    "left")
    .withColumnRenamed("name", "salesman")
    .select("cust_name", "city", "salesman", "commission")
    .show(false)


  /*4. From the following tables write a SQL query to find salespeople who received commissions of more than
  12 percent from the company. Return Customer Name, customer city, Salesman, commission. */
  println("==============Query4=================")
  salesmanDf
    .drop("city")
    .join(customerDf, salesmanDf.col("salesman_id") === customerDf.col("salesman_id"),
      "left")
    .withColumnRenamed("name", "salesman")
    .select("cust_name", "city", "salesman", "commission")
    .where(col("commission") > 0.12)
    .show(false)


  /*5. From the following tables write a SQL query to locate those salespeople who do not live in the same city
  where their customers live and have received a commission of more than 12% from the company.
  Return Customer Name, customer city, Salesman, salesman city, commission.*/
  println("==============Query5=================")
  salesmanDf
    .withColumnRenamed("city", "salesman_city")
    .withColumnRenamed("name", "salesman")
    .join(customerDf, salesmanDf.col("salesman_id") === customerDf.col("salesman_id"))
    .where(col("salesman_city") =!= col("city") &&
    col("commission") > 0.12)
    .select("cust_name", "city", "salesman", "salesman_city", "commission")
    .show(false)


  /*7. Write a SQL statement to join the tables salesman, customer and orders
  so that the same column of each table appears once and only the relational rows are returned.*/
  println("==============Query7=================")
  // Supported join types include: 'inner', 'outer', 'full', 'fullouter', 'full_outer', 'leftouter', 'left',
  // 'left_outer', 'rightouter', 'right', 'right_outer', 'leftsemi', 'left_semi', 'semi', 'leftanti', 'left_anti', 'anti', 'cross'.
  //	at org.apache.spark.sql.catalyst.plans.JoinType$.apply(joinTypes.scala:44)
  val join1 = natjoin(ordersDf, customerDf)
  natjoin(join1, salesmanDf).show(false)

  def natjoin(left: DataFrame, right: DataFrame): DataFrame = {
    val leftCols = left.columns
    val rightCols = right.columns

    val commonCols = leftCols.toSet intersect rightCols.toSet

    if(commonCols.isEmpty)
      left.limit(0).join(right.limit(0))
    else
      left
        .join(right, commonCols.map {col => left(col) === right(col) }.reduce(_ && _))
        .select(leftCols.collect { case c if commonCols.contains(c) => left(c) } ++
          leftCols.collect { case c if !commonCols.contains(c) => left(c) } ++
          rightCols.collect { case c if !commonCols.contains(c) => right(c) } : _*)
  }

  println("======= using spark SQL ==========")
  spark.sql("SELECT * FROM orders_table NATURAL JOIN customer_table  NATURAL JOIN salesman_table;").show(false)

  /* 10. Write a SQL statement to make a report with customer name, city, order number, order date, and order amount in
  ascending order according to the order date to determine whether any of the existing customers have
  placed an order or not. */
  println("===========Query10 ====================")
  customerDf
    .join(ordersDf, customerDf.col("customer_id") === ordersDf.col("customer_id"), "left_outer")
    .select(customerDf("cust_name"),customerDf("city"), ordersDf("ord_no"), ordersDf("ord_date"), ordersDf("purch_amt")
      .as("Order Amount"))
    .orderBy("ord_date")
    .show(false)
}
