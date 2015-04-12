// Partition by status code from Apache logs
import org.apache.spark.{Partitioner, SparkContext, SparkConf}

case class statusCode(StatusCode: Int)

class StatusCodePartitioner(partitions: Int) extends Partitioner {
  val statusCode =  // parse into a status code file
}

object PartitionByStatusCode {
  def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("PartitionByStatusCode")
    val sc = new SparkContext(conf)

    val input = sc.textFile("/path/to/LogFile")


  }

  def getStatusCode(input: String): statusCode = {
    val status = input.split(" ")(7).toInt
    statusCode(status)
  }
}




