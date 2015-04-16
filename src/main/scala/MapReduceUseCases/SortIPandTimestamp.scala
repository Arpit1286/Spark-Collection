// secondary sort in Spark
package MapReduceUseCases
import common.parsers.HttpLogStringParser

import org.apache.spark.{SparkContext, SparkConf}


object SortIPandTimestamp {
  val conf = new SparkConf().setAppName("SortByCompositeKey")
  val sc = new SparkContext(conf)

  // composite key sorted by timestamp
  val input = sc.textFile("/path/to/Input")
  val


}

case class compositeKey(IP: String, TimeStamp: String)

