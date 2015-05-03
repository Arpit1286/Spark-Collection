package MapReduceUseCases


import common.parsers._
import org.apache.spark.{HashPartitioner, Partitioner, SparkConf, SparkContext}

// based on Sandy Ryza's implementation of the Custom Partitioner when we have composite keys
// composite key secondary partittioner
class FirstKeyPartitioner[K1, K2](partitions: Int) extends Partitioner {
  override def numPartitions = partitions
  override def getPartition(key: Any): Int = {
    val keyPartitioner = new HashPartitioner(partitions)
    val k = key.asInstanceOf[(K1, K2)]
    keyPartitioner.getPartition(k._1)
  }
}

// implementing mapreduce style secondary sort with composite key and sorting on secondary key
object SortIPbyTimeStamp {

  val sc = new SparkContext(conf)
  val conf = new SparkConf().setAppName("SparkSecondarySort")

  val input = sc.textFile("/path/to/LogFile").map(logStringParser.parseLogString).cache()

  // create a key value pair RDD
  val IPTImeStampRDD = input.map(line => ((line.ip, line.timeStamp),line))
  val 




}

