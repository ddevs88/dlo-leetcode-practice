import basics.interviewQuestions.spark.Movies
import org.apache.spark.sql.SparkSession

object demo extends App{
  val spark = SparkSession.builder().master("local").
    appName("top_10_movie_rating").getOrCreate()
  val rdd = spark
    .sparkContext
    .textFile("src/main/scala/basics/interviewQuestions/data/moviesData.txt")

  import spark.implicits._
  val df = rdd
    .map(x => x.split("::"))
    .map(x => Movies(x(0).toInt, x(1), x(2).toInt, x(3)))
    .toDF

  df.show(false)
  df.createTempView("movie")
  val df1 = spark.sql("select a.name from ( select id,name ,rating,Year, dense_rank() over (partition by Year order by" +
    " rating desc) as drank from movie ) a where a.drank < 11")
  df1.show


}
