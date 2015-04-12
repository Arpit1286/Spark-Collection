// Partition by status code from Apache logs
import org.apache.spark.{Partitioner, SparkContext, SparkConf}

// case class statusCode(StatusCode: Array[Int])

class StatusCodePartitioner(partitions: Int) extends Partitioner {
  override def numPartitions = partitions
  override def getPartition(key: Any): Int = {
    val code = key.hashCode % numPartitions
    if (code < 0) {   // java hashcode can return negative values, offset those negative values
      code + numPartitions
    } else code
  }
}

object PartitionByStatusCode {
  def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("PartitionByStatusCode")
    val sc = new SparkContext(conf)

    val input = sc.textFile("/path/to/LogFile")
    val statusCode = input.map(line => getStatusCode(line)).collect.distinct  // get all the unique status codes
    val partitionedInput = input.map(line => (line.split(" ")(7),line)).partitionBy(new StatusCodePartitioner(statusCode.length))\
  }

  def getStatusCode(input: String): Int = {
    val status = input.split(" ")(7).toInt
    status
  }
}




