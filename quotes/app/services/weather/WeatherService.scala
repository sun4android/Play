package services.weather

import models.Weather
import play.api.libs.ws.WS
import play.api.Play.current
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import play.api.libs.json.JsError
import play.api.libs.json.JsObject


object WeatherService {
  val openweathermap = "http://api.openweathermap.org/data/2.5/find?q=%s&units=metric"
  
  def find(city: String, countryCode: Option[String] = None) : Future[Either[Weather, String]] = {
    WS.url(openweathermap.format(city + countryCode.map(cc => "," + cc).getOrElse(""))).get().map { response => 
      response.json.validate[Weather].fold(
          errors => Right(JsError.toFlatJson(errors).toString),          
          weather => Left(weather)
      )
    }
  }

}