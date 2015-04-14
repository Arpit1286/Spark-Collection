package MapReduceUseCases

import org.apache.spark.{SparkConf, SparkContext}

object CustomPartitionerForApacheLogs {
  def main(args: Array[String]) {
    val conf = new SparkConf().setAppName()
    val sc = new SparkContext(conf)

    val logInput = sc.textFile("/path/to/logTextFile") //make it use log file from command line
    val
  }
}

