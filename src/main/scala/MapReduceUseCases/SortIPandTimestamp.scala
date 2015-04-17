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
  val input = sc.textFile("/path/to/textFile")
  // RDD on composite key
  val splitRDD = input.map(line => ((new HttpLogStringParser(line).getIP, new HttpLogStringParser(line).getTimeStamp),line))

}


case class compositeKey(IP: String, TimeStamp: DateTime)

