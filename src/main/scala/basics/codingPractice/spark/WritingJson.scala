package basics.codingPractice.spark

import org.apache.hadoop.shaded.org.eclipse.jetty.websocket.common.frames.DataFrame
import org.apache.spark.sql.SparkSession

object WritingJson {

  implicit val spark = SparkSession
    .builder()
    .appName("WritingJson")
    .master("local")
    .getOrCreate()

  def writeFile(df: DataFrame, format: Option[String]=Some("csv")): Unit = {

  }
  def main(args: Array[String]): Unit = {
    val data = Seq(
      (1, "Dev", "Bareilly"),
      (2, "Varsha", "Bokaro"),
      (3, "Rahul", "Bareilly")
    )

    import spark.implicits._
    val dataDf = data.toDF("id", "name", "city")

    /*dataDf
      .write
      .format("parquet")
      .save("C:/dev_personal/code_repos/Interviews-2022/leetcode/src/main/scala/basics.codingPractice/spark/parquet")
    */
    spark.read
      .parquet("C:/dev_personal/code_repos/Interviews-2022/leetcode/src/main/scala/basics.codingPractice/spark/parquet")
      .show(false)
  }
}
