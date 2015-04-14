package MapReduceUseCases
import MapReduceUseCases.

import org.apache.spark.{SparkContext, SparkConf}

// Number of visits by each country, city and region

object VisitsByLocation {

  val conf = new SparkConf().setAppName("Visits-By-Location")
  val sc = new SparkContext(conf)

  val input = sc.textFile("/path/to/inputLog")
  val IPInput = input.map(line => line.split(" ")(0)) // has Ips as string array
  val locationFromLogRDD = IPInput.map(IPString => geoLocationLookup. )

}

