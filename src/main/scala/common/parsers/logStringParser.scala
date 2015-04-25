package common.parsers

import java.text.SimpleDateFormat

import com.github.nscala_time.time.Imports._

case class logStringParser(ip: String, clientID: String, userID: String,
                           timeStamp: DateTime, requestLine: String, statusCode: Int,
                            size: Long, referer: String, browserInfo: String)

object logStringParser {
  val pattern = """^([\d.]+) (\S+) (\S+) \[(.*)\] \"(.+?)\" (\d{3}) (\d+) \"(\S+)\" \"([^\"]+)\"$""".r
  // I changed the method here to comply with the style guide prescribed by Spark Developers
  // method to parse log line into a case class
  def parseLogString(log: String): logStringParser = {
    val matched = pattern.findFirstMatchIn(log)
    val m = matched.get

    logStringParser(m.group(1), m.group(2),m.group(3), convertToDateTime(m.group(4)),
      m.group(5),m.group(6).toInt, m.group(7).toLong, m.group(8), m.group(9))
  }

  def convertToDateTime(timeStamp: String): DateTime = {
    val formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    val timeOfRequest = new DateTime(formatter.parse(timeStamp))
    timeOfRequest
  }

}

