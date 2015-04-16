// secondary sort in Spark
package MapReduceUseCases

import java.text.SimpleDateFormat

import common.parsers.HttpLogStringParser
import com.github.nscala_time.time.Imports._

import org.apache.spark.{SparkContext, SparkConf}


object SortIPandTimestamp {
  val formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ")  // date formatter
  val conf = new SparkConf().setAppName("SortByCompositeKey")
  val sc = new SparkContext(conf)

  // composite key sorted by timestamp
  val input = sc.textFile("/path/to/Input")
  val logInfoRDD = input.map(line => HttpLogStringParser.getHttpLogString(line.toString))



}

case class compositeKey(IP: String, TimeStamp: DateTime)

