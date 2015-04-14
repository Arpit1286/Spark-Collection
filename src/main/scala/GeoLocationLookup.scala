
import com.maxmind.geoip2.WebServiceClient.Builder

case class location(CountryCode: String, Country: String, City: Option[String], region: Option[String])

// call the webservice client
val webClient = new Builder(42, "licenseKey").build()

class GeoLocationLookup {
  var IP = "0.0.0.0"


  def getIP = {

  }

}
