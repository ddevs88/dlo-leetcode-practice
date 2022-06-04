package sparkBasics

object WordCount {

  def main(args: Array[String]): Unit = {

    val sc = SparkSessionTes.spark

    val rdd = sc.sparkContext.textFile("src/main/scala/sparkBasics/resources/helloCount")
    val word = rdd.flatMap(line => line.split(" "))
    val mWord = word.map(x => (x, 1))
    val count = mWord.reduceByKey(_+_).count()

    println(s"Count is : $count")
  }

}
