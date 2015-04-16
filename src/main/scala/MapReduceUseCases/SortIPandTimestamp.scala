// secondary sort in Spark
package MapReduceUseCases

import org.apache.spark.{SparkContext, SparkConf}
import java.text.SimpleDateFormat


object SortIPandTimestamp {
  val conf = new SparkConf().setAppName("SortByCompositeKey")
  val sc = new SparkContext(conf)

  // composite key sorted by timestamp



}

case class compositeKey(IP: String, TimeStamp: DateTime)

