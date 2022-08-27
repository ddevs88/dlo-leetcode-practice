import org.apache.spark.sql.SparkSession

object InfoTestSpark {


  val spark = SparkSession
    .builder()
    .master("local")
    .appName("InfoTestSpark")
    .getOrCreate()


  def main(args: Array[String]): Unit = {

    val data = Seq(
      "Hello emp is there",
      "This is second time emp",
      "nothing here"
    )
    //count num of occurances of class name = "emp" in
    val rdd = spark.sparkContext.parallelize(data)
    val c = rdd.flatMap(line => line.split(" "))
      .map(w => (w, 1))
      .filter(x => x._1 == "emp")
      .count()

    println(c)

  }
}
