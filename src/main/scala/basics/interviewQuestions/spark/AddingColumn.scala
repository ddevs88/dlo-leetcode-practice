package basics.interviewQuestions.spark

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.functions._

case class Data(frame_number: Int, distance_bet_frame: Double, speed_bet_frame: Double)

object AddingColumn {

  val spark = SparkSession
    .builder()
    .appName("AddingColumn")
    .master("local")
    .getOrCreate()

  def main(args: Array[String]): Unit = {

    import spark.implicits._
    val data = Seq(
      Data(1, 0.884142543, 0.138632761),
        Data(2, 0.675608568, 0.860386426),
        Data(3, 0.385928086, 0.004187843),
        Data(4, 0.04240749, 0.463777804),
        Data(5, 0.427491096, 0.371487001),
        Data(6, 0.584536847, 0.895427726),
        Data(7, 0.640139736, 0.964172107),
        Data(8, 0.626871192, 0.964669418),
        Data(9, 0.110870412, 0.614034374),
        Data(10, 0.418231175, 0.002165155),
        Data(11, 0.821305096, 0.514677276)
    ).toDF()

    var start = Window.unboundedPreceding
    var winSpec = Window.rowsBetween(start, Window.currentRow)
    data
      .withColumn("new_col",
        when(sum("distance_bet_frame")
          .over(winSpec) >= 2, $"frame_number" ))
      .show(false)
  }
}
