package MapReduceUseCases

import org.apache.spark.{SparkConf, SparkContext}

object ApacheLogStatusCount {
  def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("ApacheLogStatusCount")
    val sc = new SparkContext(conf)

    val inputLogRDD = sc.textFile("/path/to/logFile")
    // improve by taking in status code from user and outputting the count
    val errorStatus = "404"
    val errorStatusRDD = inputLogRDD.filter(line => line.contains("404"))
    val errorStatusCount = errorStatusRDD.count()

  }
}

