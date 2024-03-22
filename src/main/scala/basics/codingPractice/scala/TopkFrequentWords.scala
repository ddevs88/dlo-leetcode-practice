package basics.codingPractice.scala

object TopkFrequentWords extends App{

  def topKFrequent(words: Array[String], k: Int): List[String] = {
    val hm = scala.collection.mutable.Map[String, Int]()

    for(w <- words){
      if(!hm.contains(w)){
        hm.addOne((w,1))
      }
      else {
        hm.addOne((w,hm(w)+1))
      }
    }
    hm.toSeq.sortBy(_._2).toMap.keySet.toList.reverse.take(k)
  }

  println(topKFrequent(Array("i","love","leetcode","i","love","coding"), 2))
}
