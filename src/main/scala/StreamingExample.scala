import org.apache.spark.SparkConf
import org.apache.spark.streaming.{Seconds, StreamingContext}
import org.apache.spark.streaming.kafka.

// reading from Kafka and writing to local disk


object StreamingExample {
  def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("kafkaStreamWriter")
    val ssc = new StreamingContext(conf, Seconds(2))
    val
  }
}


