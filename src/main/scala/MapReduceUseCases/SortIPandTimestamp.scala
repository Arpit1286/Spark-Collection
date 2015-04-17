// secondary sort in Spark
package MapReduceUseCases


import com.github.nscala_time.time.Imports
import common.parsers.HttpLogStringParser
import org.apache.spark.{HashPartitioner, Partitioner, SparkContext, SparkConf}


object SortIPandTimestamp {
  val conf = new SparkConf().setAppName("SortByCompositeKey")
  val sc = new SparkContext(conf)

  def createCompositeKey(line: String): (String, Imports.DateTime) = {
    val ip = new HttpLogStringParser(line).getIP
    val timeStamp = new HttpLogStringParser(line).getTimeStamp
    Tuple2(ip, timeStamp)
  }

  // composite key sorted by timestamp
  val input = sc.textFile("/path/to/textFile")
  val ipAddress = input.map(line => new HttpLogStringParser(line).getIP).distinct()
  // RDD on composite key
  val splitRDD = input.map(
    line => (createCompositeKey(line),line
      )).partitionBy(new FirstKeyPartitioner(ipAddress.count().toInt))



}

// based on Sandy Ryza's implementation of the Custom Partitioner when we have composite keys
class FirstKeyPartitioner[K1, K2](partitions: Int) extends Partitioner {
  override def numPartitions = partitions
  override def getPartition(key: Any): Int = {
    val keyPartitioner = new HashPartitioner(partitions)
    val k = key.asInstanceOf[(K1, K2)]
    keyPartitioner.getPartition(k._1)
  }
}

