package basics.interviewQuestions.spark

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.functions.row_number

case class Movies(id: Int, name: String, rating: Int, Year: String)

object TopTenMoviesPerYear {

  val spark = SparkSession
    .builder()
    .master("local")
    .appName("TopTenMoviesPerYear")
    .getOrCreate()

  def main(args: Array[String]): Unit = {

    val rdd = spark
      .sparkContext
      .textFile("src/main/scala/basics.interviewQuestions/data/moviesData.txt")

    import spark.implicits._
    val df = rdd
      .map(x => x.split("::"))
      .map(x => Movies(x(0).toInt, x(1), x(2).toInt, x(3)))
      .toDF

    df.show(false)
    val windowSpec = Window.partitionBy("year").orderBy($"rating".desc )

    df
      .withColumn("row_number", row_number().over(windowSpec))
      .filter($"row_number" <= 10 )
      .show(false)



  }
}
