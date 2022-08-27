package interviewQuestions.spark

import org.apache.spark.sql.SparkSession

object StudentScores {

  val spark = SparkSession
    .builder()
    .master("local")
    .appName("StudentScores")
    .getOrCreate()


  def main(args: Array[String]): Unit = {
    import spark.implicits._
    val data = Seq(
      (1, "Dev", 55, 65, 68),
      (2, "Ankur", 70, 75, 78),
      (3, "Rahul", 65, 79, 79),
      (4, "Sam", 55, 65, 68)
    ).toDF("id", "name", "class9score", "class10score", "class11score")


    data.selectExpr(
      "id", "name",
      "Stack(3, 'class9score', class9score, 'class10score', class10score, 'class11score', class11score)"
    )
      .withColumnRenamed("col0", "class")
      .withColumnRenamed("col1", "score")
      .groupBy("id", "name")
      .sum("score")
      .orderBy("id")
      .withColumnRenamed("sum(score)", "totalScore")
      .show(false)

  }
}
