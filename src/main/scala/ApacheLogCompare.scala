// compare if two log events are same

import org.apache.spark.{SparkContext, SparkConf}

case class Events(IP: String, timeStamp: String, request: String)

object ApacheLogCompare {
  val conf = new SparkConf().setAppName("ApacheLogCompare")
  val sc = new SparkContext(conf)
  val logInput = sc.textFile("/path/to/logFile")
  def parse(logLines: String): Events = {
    val parts = logLines.split(" ")  // try building it with regex, it will work here as everything is String type
    val IP = parts(0)
    val timeStamp = parts(3)
    val request = parts(4)
    Events(IP, timeStamp, request)
  }

  val event = logInput.map(line => parse(line))
  val distinctEvents = event.distinct()
}

