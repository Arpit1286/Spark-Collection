import org.apache.spark.{SparkContext, SparkConf}

// this gives seriliazation exception, look deep into it
//class TextPair(var first: String, var second: String) {
//  val returnTuple = (first, second)
//}  try using 'case class' to see if it works

case class TextPair(first: String, second: String)

object TextPairCount {
  def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("TextPairCount")
    val sc = new SparkContext(conf)

    val input = sc.textFile("/path/to/Inputfile")
    val textPairs = input.map(line => parse(line))
    val pairCount = textPairs.map(x => (x,1)).reduceByKey(_ + _)
    pairCount.saveAsTextFile("/path/to/output")
  }

  def parse(input: String): TextPair = {
    val parts = input.split(" ")
    val first = parts(0)
    val second = parts(1)
    TextPair(first, second)
  }
}


/*
object TextPairCount {
  def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("TextPair")
    val sc = new SparkContext(conf)

    val input = sc.textFile("/path/to/pair.txt")
    val textPairRDD = input.map(x => (x.split(" ")(0), x.split(" ")(1)))  // make them into a tuple
    val pairCount = textPairRDD.map(x => (x,1)).reduceByKey(_ + _)  // collect and aggregate
    pairCount.saveAsTextFile("/path/to/output.txt")
  }
}
*/
