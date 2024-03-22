package basics.interviewQuestions.spark

import org.apache.spark.sql.SparkSession

object CountMemoryException {

  val spark = SparkSession
    .builder()
    .master("local")
    .appName("CountMemoryException")
    .getOrCreate()

  def main(args: Array[String]): Unit = {
    val data = Seq(
      ("hello memory exception one memory exception hello"),
      ("hello memory exception one hello"),
      ("hello memory exception one memory exception hello"),
      ("hello memory exception one hello"),
      ("hello memory exception one hello"),
      ("hello exception one hello")
    )

    val rdd = spark.sparkContext.parallelize(data)

    val res = rdd
      .map(x => {
        var c = 0
        ("me", x.split("memory exception").length-1)
      })
      .filter(_._1 == "me").map(x => x._2)
      .reduce(_+_)

    println(res)
  }

}
