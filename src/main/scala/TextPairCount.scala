import org.apache.spark.{SparkContext, SparkConf}

// this gives seriliazation exception, look deep into it
//class TextPair(var first: String, var second: String) {
//  val returnTuple = (first, second)
//}

object TextPairCount {
  def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("TextPair")
    val sc = new SparkContext(conf)

    val input = sc.textFile("/path/to/pair.txt")  // add command line options instead of hard coded path
    val textPairRDD = input.map(x => (x.split(" ")(0), x.split(" ")(1)))
    val pairCount = textPairRDD.map(x => (x,1)).reduceByKey(_ + _)
  }
}

