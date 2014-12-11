package models

import play.api.libs.json._
import play.api.libs.functional.syntax._

case class Quote(id: Option[Long] = None, author: String, text: String)
object Quote {
  implicit val quoteFormat = Json.format[Quote]
}

/** 
 *  {"message":"accurate","cod":"200","count":1,
 *    "list":[{
 *      "id":3099434,"name":"Gdansk","coord":{"lon":18.64637,"lat":54.352051},
 *      "main":{"temp":0.48,"pressure":1026,"temp_min":0,"temp_max":0.9,"humidity":100},
 *      "dt":1418142648,
 *      "wind":{"speed":2.1,"deg":240,"var_beg":200,"var_end":280},
 *      "sys":{"country":"PL"},"clouds":{"all":0},
 *      "weather":[{"id":800,"main":"Clear","description":"Sky is Clear","icon":"01n"}]}
 *  ]}
 */
case class Weather(city: String, country: String, temperature: Double)
object Weather {
  implicit val weatherReads: Reads[Weather] = (
    ((__ \ "list")(0) \ "name").read[String] and
    ((__ \ "list")(0) \ "sys" \ "country").read[String] and
    ((__ \ "list")(0) \ "main" \ "temp").read[Double])(Weather.apply _)
  
  implicit val weatherWrites: Writes[Weather] = (
    (__ \ "city").write[String] and
    (__ \ "country").write[String] and
    (__ \ "temp").write[Double])(unlift(Weather.unapply))
}