package basics.codingPractice.sparkSql

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.functions._

object SqlPractice {

  def main(args: Array[String]): Unit = {

    val spark = SparkSession
      .builder()
      .master("local")
      .appName("SQLPractice")
      .getOrCreate()

    spark.sparkContext.setLogLevel("ERROR")

    /*======================================================================================================*/
    // 176. Second Highest Salary
    val data = Seq(
      (1, 100),
      (2, 200),
      (3, 300),
      (4, 300),
      (5, 400),
      (6, 600)
    )
    import spark.implicits._
    val dataDf = data.toDF("id", "salary")

    val windowSpec = Window.orderBy($"salary".desc)

    dataDf.withColumn("rank", rank().over(windowSpec))
      .filter($"rank" === 3).show(false)



    //
    val d = Seq(
      (1,3.50),
      (2,3.65),
      (3,4.00),
      (4,3.85),
      (5,4.00),
      (6,3.65)
    )

    val dDf = d.toDF("id", "score")
    val w = Window.orderBy($"score".desc)
    dDf.withColumn("dense_rank", dense_rank().over(w))
      .show(false)

/*======================================================================================================*/
    //180. Consecutive Numbers
    val d180 = Seq(
      (1,1),
      (2,1),
      (3,1),
      (4,2),
      (5,1),
      (6,2),
      (7,2),
      (8,2)
    )

    println("180. Consecutive Numbers")
    val d180Df = d180.toDF("id", "num")
    d180Df.withColumn("cNum",
      when(
        (lead("num", 1, null).over(Window.orderBy("id")) === $"num") &&
        (lead("num", 2, null).over(Window.orderBy("id")) === $"num"),
        $"num"))
      .filter($"cNum".isNotNull)
      .show(false)


    //Frame count
    println("//Frame count")
    val fData = Seq(
      (1, 0.884142543, 0.138632761),
      (2, 0.675608568, 0.860386426),
      (3, 0.385928086, 0.004187843),
      (4, 0.04240749 , 0.463777804),
      (5, 0.427491096, 0.371487001),
      (6, 0.584536847, 0.895427726),
      (7, 0.640139736, 0.964172107),
      (8, 0.626871192, 0.964669418),
      (9, 0.110870412, 0.614034374),
      (10, 0.418231175, 0.002165155),
      (11, 0.821305096, 0.514677276)
    )

    val frameDf = fData.toDF("fNum", "fDistence", "fSpeed")
    frameDf.withColumn("cSum1", sum("fDistence")
      .over(Window.orderBy("fNum")
        .rowsBetween(Window.unboundedPreceding, Window.currentRow)
    )).show(false)

/*=======================================================================================================*/
    //Solera 2nd Round
    //Write a spark program to provide - for each event type top 5 Driver Names ,
    // based on number of occurrences of that event for the driver driving vehicle in that particular day.
    val eventData = Seq(
      (123, "ImpulsiveBraking", "2022-07-25"),
      (123, "ImpulsiveBraking", "2022-07-25"),
      (234, "RearSightBlocked", "2022-07-25"),
      (234, "RearSightBlocked", "2022-07-25"),
      (123, "SuddenAcceleration", "2022-07-25"),
      (123, "ImpulsiveBraking", "2022-07-25"),
      (123, "ImpulsiveBraking", "2022-07-25"),
      (234, "ImpulsiveBraking", "2022-07-25"),
      (129, "SuddenAcceleration", "2022-07-25"),
      (129, "DrowsinessDetected", "2022-07-25")
    )

    val eventDf = eventData.toDF("cameraId", "eventType", "eventDate")
    eventDf.show(false)

    val camAllocation = Seq(
      (123, "23451"),
      (234, "12456"),
      (129, "23421")
    )
    val camAllocationDf = camAllocation.toDF("cameraId", "vehicleId")
    camAllocationDf.show(false)

    val vehicleAlloction = Seq(
      ("23451", "Alex"),
      ("12456", "Daniel"),
      ("23421", "Bob")
    )
    val vehiclAllocationDf = vehicleAlloction.toDF("vehicleId", "driverName")
    vehiclAllocationDf.show(false)

    eventDf
      .groupBy("eventDate", "cameraId")
      .agg(count("cameraId").as("count"))
      .join(camAllocationDf, "cameraId")
      .join(vehiclAllocationDf, "vehicleId")
      .orderBy($"count".desc)
      .show(5)

/*=====================================================================================================*/
    /*2)Generate output from the given input in spark
input-
c1 c2 c3
a  2  2020-01-02
b  1  2020-01-01
c  5  2020-01-05

output-
c1 c2 c3
a  1  2020-01-02
a  2  2020-01-03
b  1  2020-01-01
c  1  2020-01-05
c  2  2020-01-06
c  3  2020-01-07
c  4  2020-01-08
c  5  2020-01-09 */
    val dupData = Seq(
      ("a", 2, "2020-01-02"),
      ("b", 1, "2020-01-01"),
      ("c", 5, "2020-01-05")
    ).toDF("id", "num", "date")

    // using udf
    val range = udf((i: Int)=> (1 to i).toArray)
    val dupDataDf = dupData.withColumn("num", explode(range($"num")))
      .withColumn("date", to_date($"date").plus($"num"-1))
    dupDataDf.show(false)

    // using sequence
    val dupDataDfNew = dupData
      .withColumn("num", explode(sequence(lit(1), lit($"num"))))
      .withColumn("date", to_date($"date").plus($"num"-1))
    dupDataDfNew.show(false)

    /*==================================================================================*/
    /*1)Given a json file find sum of the counts for each department using python.
{
  "country1": {
  "dept1":{"count": 50},
  "dept2": {"count": 20},
  "dept3": {"count": 5},
  "dept4": {"count":55}
  },
  "country2": {
  "dept1":{"count": 50},
  "dept2": {"count": 20},
  "dept3": {},
  "dept4": {"count":55}
}
}*/
    println("1)Given a json file find sum of the counts for each department using python")

    val countryDf = spark.read
      .option("inferSchema", true)
      .option("multiline", true)
      .json("src/main/scala/basics.codingPractice/sparkSql/data/country.json")

    countryDf
      .withColumn("countries", explode($"country"))
      .withColumn("c1", $"countries".getItem("country1"))
      .withColumn("c2", $"countries".getItem("country2"))
     /* .withColumn("c1dept1", $"c1".getItem("dept1"))
      .withColumn("c1dept2", $"c1".getItem("dept2"))
      .withColumn("c1dept4", $"c1".getItem("dept4"))
      .withColumn("c2dept1", $"c2".getItem("dept1"))
      .withColumn("c2dept2", $"c2".getItem("dept2"))
      .withColumn("c2dept4", $"c2".getItem("dept4"))*/
      .show(false)

/*====================================================================================*/
    /*
    * 3)Generate output from the given input in spark sql
input-
id p_id
1 null
2 1
3 1
4 2
5 2

output-
id  type of node
1   root
2   intermidiate
3   leaf
4   leaf
5   leaf*/

    val treeData = Seq(
      (1, 0),
      (2, 1),
      (3, 1),
      (4, 2),
      (5, 2)
    ).toDF("id", "p_id")

    val pIdList = treeData.select($"p_id").map(x => x.getInt(0)).collect.toList
    println("3)Generate output from the given input in spark sql")
    treeData.withColumn("type",
      when($"p_id" === lit(0), "root")
        .when(($"p_id"=!=0 && $"id".isin(pIdList: _*)), "intermediate")
        .otherwise("leaf")
    ).show(false)


    /*======================================================================================*/

    /*5)From given file content find count of words 'collagen' with its line number*/

    def countWords(str: Array[String]): Int = {
      var count = 0
      for(s <- str){
        if(s.equals("collagen")){
          count+=1
        }
      }
      count
    }

    println("From given file content find count of words 'collagen' with its line number")
    val rdd = spark.sparkContext.textFile("src/main/scala/basics.codingPractice/sparkSql/data/coleganData.txt")
    rdd.map(x => (countWords(x.split(" ")), row_number()))
      .foreach(println)

    println("============")
    val collagenDf = spark.read.text("src/main/scala/basics.codingPractice/sparkSql/data/coleganData.txt")
    collagenDf
      .withColumnRenamed("value", "record")
      .withColumn("line", split($"record", " "))
      .withColumn("exLine", explode($"line"))
      .filter($"exLine".like("%collagen"))
      .groupBy("record").agg(count("exLine").as("count"))
      .withColumn("row_num", row_number().over(Window.orderBy("record")))
      .show(1000)


    /*
    * FROM,|,TO,|,DIST
SEA,SF,300
CHI,SEA,2000
SF,SEA,300
SEA,CHI,2000
SEA,LND,500
LND,SEA,500
LND,CHI,1000
CHI,NDL,180

Output:
SEA,SF,600,Shuttle
CHI,SEA,4000,Shuttle
SEA,LND,1000,Shuttle
*/
    val s1 =
      Seq(
        ("SEA","SF",300),
        ("CHI","SEA",2000),
        ("SF","SEA",300),
        ("SEA","CHI",2000),
        ("SEA","LND",500),
        ("LND","SEA",500),
        ("LND","CHI",1000),
        ("CHI","NDL",180)
      ).toDF("from", "to", "dist")

    val s2 = s1
    println("find the shulttle service between two places?")
    s1.as("a").join(s2.as("b"),
      $"a.from"===$"b.to" &&
        $"a.to"===$"b.from")
      .dropDuplicates("dist")
      .select("a.*")
      .withColumn("service", lit("shuttle"))
      .withColumn("dist", $"dist"*2)
      .show(false)

  }
}

