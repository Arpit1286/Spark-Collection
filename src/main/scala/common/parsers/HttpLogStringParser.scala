package common.parsers

import com.github.nscala_time.time.Imports._

// takes in the logLine and can be called to return IP, timestamp, requestPage and statusCode as strings


class HttpLogStringParser(logLine: String) {
  // Regex Pattern matching the logLine
  val pattern = """^([\d.]+) (\S+) (\S+) \[(.*)\] \"(.+?)\" (\d{3}) (\d+) \"(\S+)\" \"([^\"]+)\"$""".r
  val matched = pattern.findFirstMatchIn(logLine)

  def getIP: String = {
    val IP = matched match {
      case Some(m) => m.group(1)
      case _ => None
    }
    IP.toString
  }

  def getTimeStamp: DateTime = {
    val timeStamp = matched match {
      case Some(m) => m.group(4)
      case _ => None
    }
    stringToDate(timeStamp.toString)
  }

  def getRequestPage: String = {
    val requestPage = matched match {
      case Some(m) => m.group(5)
      case _ => None
    }
    requestPage.toString
  }

  def getStatusCode: String = {
    val statusCode = matched match {
      case Some(m) => m.group(6)
      case _ => None
    }
    statusCode.toString
  }

  // change here for a different date Time string
  def stringToDate(timeStampString: String): DateTime = {
    val timeStamp = DateTime.parse(timeStampString.replace("\'",""))
    timeStamp
  }
}


/* case class HttpLogStringParser(ip: String,
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
  val pattern = """^([\d.]+) (\S+) (\S+) \[(.*)\] \"(.+?)\" (\d{3}) (\d+) \"(\S+)\" \"([^\"]+)\"$""".r
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
      referer,
      browserInfo))
    case _ => None
  }
}

*/
