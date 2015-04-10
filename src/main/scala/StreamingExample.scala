import org.apache.spark.streaming.{Seconds, StreamingContext, Duration}
import org.apache.spark.streaming.StreamingContext._
import org.apache.spark.streaming.dstream.DStream
import org.apache.spark.SparkConf

val conf = new SparkConf()
val ssc = new StreamingContext(conf, Seconds(1))
//create a Dstream using data recieved after connecting to port 7777 on local machine
val lines = ssc.socketTextStream("localhost", 7777)
// filter our Dstream for lines with "error"
val errorLines = lines.filter(_.contains("error"))

errorLines.print()


