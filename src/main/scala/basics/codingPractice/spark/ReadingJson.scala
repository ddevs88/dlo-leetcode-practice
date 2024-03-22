package basics.codingPractice.spark

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.explode

object ReadingJson {

  val spark = SparkSession
    .builder()
    .appName("ReadingJson")
    .master("local")
    .getOrCreate()

  def main(args: Array[String]): Unit = {

    val jsonDf = spark
      .read
      .option("inferSchema", true)
      .option("multiline", true)
      .json("src/main/scala/basics.codingPractice/test.json")

    jsonDf.show(false)
    import spark.implicits._
    val ordersDf = jsonDf.withColumn("orders", explode($"datasets"))

    val parseOrdersDf = ordersDf.withColumn("orders", explode($"datasets"))
    // Step 3: Fetch Each Order using getItem on explode column
    val parseOrdersDf1 = parseOrdersDf
      .withColumn("customerId", $"orders".getItem("customerId"))
      .withColumn("orderId", $"orders".getItem("orderId"))
      .withColumn("orderDate", $"orders".getItem("orderDate"))
      .withColumn("orderDetails", $"orders".getItem("orderDetails"))
      .withColumn("shipmentDetails", $"orders".getItem("shipmentDetails"))

    val parseOrdersDf2 = parseOrdersDf1.withColumn("orderDetails", explode($"orderDetails"))



    val finalDf = parseOrdersDf2.withColumn("productId", $"orderDetails".getItem("productId"))
      .withColumn("quantity", $"orderDetails".getItem("quantity"))
      .withColumn("sequence", $"orderDetails".getItem("sequence"))
      .withColumn("totalPrice", $"orderDetails".getItem("totalPrice"))
      .withColumn("city", $"shipmentDetails".getItem("city"))
      .withColumn("country", $"shipmentDetails".getItem("country"))
      .withColumn("postalcode", $"shipmentDetails".getItem("postalCode"))
      .withColumn("street", $"shipmentDetails".getItem("street"))
      .withColumn("state", $"shipmentDetails".getItem("state"))
      .withColumn("gross", $"totalprice".getItem("gross"))
      .withColumn("net", $"totalprice".getItem("net"))
      .withColumn("tax", $"totalprice".getItem("tax"))

      finalDf.select($"orderId"
        ,$"customerId"
        ,$"orderDate"
        ,$"productId"
        ,$"quantity"
        ,$"sequence"
        ,$"gross"
        ,$"net"
        ,$"tax"
        ,$"street"
        ,$"city"
        ,$"state"
        ,$"postalcode"
        ,$"country")
      .show(false)
  }

}
