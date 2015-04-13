import org.apache.spark.SparkConf
import org.apache.spark.streaming.kafka._
// reading from Kafka and writing into local disk


object StreamingExample {
  def main(args: Array[String]) {
    val conf = new SparkConf()
    val kafkaStream = KafkaUtils.createStream()
  }
}


