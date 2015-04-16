package common.parsers

import com.github.nscala_time.time.Imports._

class HttpLogStringParser {

  // regular expression for the log format used. minor variations in the format would require this to change
  val pattern = """^([\d.]+) (\S+) (\S+) \[(.*)\] \"([^\s]+) (/[^\s]*) HTTP/[^\\s]+\" (\d{3}) (\d+) \"([^\"]+)\" \"([^\"]+)\"$""".r

  def getTimeStamp(input: String): DateTime = {

  }

  def getIp(input: String): String = {

  }

  def getRequestPage(input: String): String = {

  }

}
