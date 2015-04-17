// secondary sort in Spark
package MapReduceUseCases

import common.parsers.HttpLogStringParser
import com.github.nscala_time.time.Imports._
import org.apache.spark.{SparkContext, SparkConf}


object SortIPandTimestamp {
  val conf = new SparkConf().setAppName("SortByCompositeKey")
  val sc = new SparkContext(conf)

  def createCompositeKey(line: String): compositeKey = {
    val ip = new HttpLogStringParser(line).getIP
    val timeStamp = new HttpLogStringParser(line).getTimeStamp
    compositeKey(ip, timeStamp)
  }

  // composite key sorted by timestamp
  val input = sc.textFile("/path/to/textFile")
  // RDD on composite key
  val splitRDD = input.map(line => (createCompositeKey(line),line))

}



case class compositeKey(IP: String, TimeStamp: DateTime)

