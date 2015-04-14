import java.net.InetAddress
import java.net.InetAddress.getByName
import com.maxmind.geoip2.WebServiceClient.Builder

case class location(CountryCode: String, Country: String, City: Option[String], region: Option[String], postalCode: Option[String])

// call the webservice client

val webClient = new Builder(42, "licenseKey").build()


class GeoLocationLookup {
  var IPString = "0.0.0.0"
  val IPAddress = new InetAddress(getByName(IPString))
  val insights = webClient.insights(IPAddress)
  // yet to add the exception cases
  def geoLookup(IP: String): Unit ={
    val Country = insights.getCountry.getName
    val City = insights.getCity.getName
    val CountryCode = insights.getCountry.getIsoCode
    val region = insights.getMostSpecificSubdivision.getName
    val zipCode = insights.getPostal.getCode
  }

}
