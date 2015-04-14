package MapReduceUseCases

import org.apache.spark.{SparkConf, SparkContext}

/**
 * Created by Arpit on 4/14/2015.
 */
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
