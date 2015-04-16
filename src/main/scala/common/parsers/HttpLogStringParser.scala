package common.parsers

import com.github.nscala_time.time.Imports._

case class HttpLogStringParser(ip: String,
                               RFC1413: String,
                               UserID: String,
                               TimeStamp: DateTime,
                               RequestLine: String,
                               StatusCode: Int,
                               Size: Double,
                               Referer: String,
                               BrowserInfo: String)


object HttpLogStringParser {
  // regular expression for the log format used. minor variations in the format would require this to change
  val pattern = """^([\d.]+) (\S+) (\S+) \[(.*)\] \"([^\s]+) (/[^\s]*) HTTP/[^\\s]+\" (\d{3}) (\d+) \"([^\"]+)\" \"([^\"]+)\"$""".r
  def getHttpLogString(logLine: String) = logLine match {
    case pattern(ip,
    rfc1413,
    userID,
    timeStamp,
    requestLine,
    statusCode,
    size,
    referer,
    browserInfo) => Some(HttpLogStringParser(ip,
      rfc1413,
      userID,
      timeStamp.toDateTime,
      requestLine,
      statusCode.toInt,
      size.toDouble,
      referer,browserInfo))
    case _ => None
  }
}
