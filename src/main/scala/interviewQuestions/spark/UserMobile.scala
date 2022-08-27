package interviewQuestions.spark

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.{countDistinct, explode, split}

object UserMobile {

  val spark = SparkSession
    .builder()
    .appName("UserMobile")
    .master("local")
    .getOrCreate()

  def main(args: Array[String]): Unit = {
    import spark.implicits._
    val data = Seq(
      ("user1","999999991:888888882"),
      ("user3","777777771"),
      ("user2","777777234:823232351"),
      ("user5","734452343:943433434:834323434"),
    ("user1","999999991:9994433777")
    ).toDF("user", "mobile")

    //data.show(false)

    val df = data
      .withColumn("mobile", split($"mobile", ":"))
      .withColumn("mobile", explode($"mobile"))
      //.dropDuplicates("user", "mobile")
      .groupBy("user")
      .agg(countDistinct("mobile").as("numberOfMobile"))

    df.show(false)

  }
}
