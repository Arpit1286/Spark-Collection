import java.net.InetAddress
import java.net.InetAddress.getByName
import com.maxmind.geoip2.WebServiceClient.Builder

case class location(CountryCode: String, Country: String, City: String, region: String, postalCode: String)

// call the webservice client

val webClient = new Builder(42, "licenseKey").build()

// naive implementation
object GeoLocationLookup {

  // geolookup method, yet to add exception cases

  // to be added, 1. make sure the IP string is correct
  // 2. make sure null values returned are taken care of
  // 3. Add none options
  def geoLookup(IP: String): location ={
    val IPAddress = new InetAddress(getByName(IP))
    val insights = webClient.insights(IPAddress)
    // get the country name, City name, Country Code and Zip code as String
    val Country = insights.getCountry.getName
    val City = insights.getCity.getName
    val CountryCode = insights.getCountry.getIsoCode
    val region = insights.getMostSpecificSubdivision.getName
    val zipCode = insights.getPostal.getCode
    location(CountryCode, Country, City, region, zipCode)
  }

}
