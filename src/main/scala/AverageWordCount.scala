import org.apache.spark.{SparkContext, SparkConf}


object AverageWordCount {
  def main (args: Array[String]) {
    val conf = new SparkConf().setAppName("AverageWordCount")
    val sc = new SparkContext(conf)

    val input = sc.textFile("/path/to/inputFile")
    val wordsRDD = input.flatMap(line => line.split("[\\s\\.\\,\\:\\,]+")).map(x => (x,1));
    val wordCount = wordsRDD.combineByKey(
      (v) => (v, 1),    // collect the values into tuples
      (acc: (Int, Int), v) => (acc._1 + v, acc._2 + 1),  // perform aggregation of values and keys
      (acc1: (Int, Int), acc2: (Int, Int)) => (acc1._1 + acc2._1, acc1._2 + acc2._2)  // collect results from the partitions
    ).map{case (key, value) => (key, value._1 / value._2.toFloat) }  // map into word and its average

  }
}

