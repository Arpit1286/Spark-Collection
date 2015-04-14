package MapReduceUseCases
import MapReduceUseCases.GeoLocationLookup.geoLookup
import org.apache.spark.{SparkContext, SparkConf}

// Number of visits by each country, city and region

object VisitsByLocation {

  val conf = new SparkConf().setAppName("Visits-By-Location")
  val sc = new SparkContext(conf)

  val input = sc.textFile("/path/to/inputLog")
  val IPInput = input.map(line => line.split(" ")(0)) // has Ips as string array
  val locationFromLogRDD = IPInput.map(IPString => geoLookup(IPString)) // this gives us the location as defined in the geolookup
  // do the wordCount to get the number of visits from each country, city and so on, complete it after figuring out the next set


}

