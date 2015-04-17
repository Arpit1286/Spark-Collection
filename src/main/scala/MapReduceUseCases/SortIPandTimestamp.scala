// secondary sort in Spark
package MapReduceUseCases

import java.text.SimpleDateFormat

import common.parsers._
import com.github.nscala_time.time.Imports._

import org.apache.spark.{SparkContext, SparkConf}


object SortIPandTimestamp {
  val formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ")  // date formatter
  val conf = new SparkConf().setAppName("SortByCompositeKey")
  val sc = new SparkContext(conf)

  // composite key sorted by timestamp
  val input = sc.textFile("F:\\Personal\\")
  val logInfoRDD = input.map(line => HttpLogStringParser.getHttpLogString(line.toString))
  val KeyValuePair = logInfoRDD.map(line => (line.ip, line.TimeStamp))
}

case class compositeKey(IP: String, TimeStamp: DateTime)

