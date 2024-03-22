package basics

import scala.util.Try

case class Emp(id: Int, sal: Double, name: String)
case class Dept(id: Int, departmentName: String, band: Int)
case class Range(band: Int, min: Double, max: Double)

object Test {

  val empData  = new Array[Emp](6)
  empData(0) = Emp(1, 10000, "A")
  empData(1) = Emp(2, 40000, "B")
  empData(2) = Emp(3, 55000, "C")
  empData(3) = Emp(4, 80000, "D")
  empData(4) = Emp(5, 30000, "E")
  empData(5) = Emp(6, 100000, "E")

  val deptData = new Array[Dept](4)
  deptData(0) = Dept(1, "DataPlatfrom", 9)
  deptData(1) = Dept(2, "DataFramework", 8)
  deptData(2) = Dept(3, "Delivery", 7)
  deptData(3) = Dept(4, "SRE", 6)

  val rangeData = new Array[Range](4)
  rangeData(0) = Range(6, 60000.0, 70000.0)
  rangeData(1) = Range(7, 50000.0, 60000.0)
  rangeData(2) = Range(8, 40000.0, 50000.0)
  rangeData(3) = Range(9, 30000.0, 40000.0)

  def getBand(id: Int): Int={
    var res = -1
    for(x <- deptData){
      if(id == x.id){
        res = x.band
      }
    }
    res
  }

  def getRange(band: Int): (Double, Double)={
    var res = (-1.0, -1.0)
    for(i <- rangeData){
      if(band == i.band){
        res = (i.min, i.max)
      }
    }
    res
  }


  def main(args: Array[String]): Unit = {

    println("Hello")

    val data = Seq(1, "abc")
    val newData = data.map {
      case x: Int => x
      case _ => "str"
    }.filter(_!="str")

    println(newData)


    /*
    * Method throws exception but i am not interested.
    * I want a default value if exception occurred.
    * Write code.*/
    val data1 = Seq(1, "abc")
    val res = data1.map(
      x => {
        Try {
          x.toString.toInt
        }.getOrElse(0)
      }
    )

    println(res.toList)

    /*
    */

//1. All employee whose salary is out of the range.
    val fempData = empData.filter(i => {
      val band = getBand(i.id)
      val range = getRange(band)
      i.sal<range._1||i.sal>range._2
    })

    println(fempData.toList)

    //2. List of employee whose department details are not updated.

    val idListOfDept = deptData.map(x=> x.id)
    val res2 = empData.filter(x=> {
      !idListOfDept.contains(x.id)
    })
    println(res2.toList)

  }
}
