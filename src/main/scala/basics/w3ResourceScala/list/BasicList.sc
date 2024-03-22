import scala.collection.mutable.ListBuffer

var list = List(1, 2 , 3)
list ++ List(4)
println(res0)

var colors = ListBuffer("Green", "Red")
colors += "Orange"
colors ++= List("Black", "White")
colors ++= List("Hello")
// Remove element
colors -= "Red"
colors --= List("Black", "White")

println(list.sum)
println(list.product)

list.filter(_ !=1)

// Largest number of the said list:
val nums = List(1, 3, 5, 7, 9, 11, 14, 12)

var n = 0
for(i <- 0 to nums.length-1){
  if(i < nums.length-1){
    if(nums(i) > nums(i+1)) {
      n = nums(i)
    }
    else n = nums(i+1)
  }
}
println(n)






