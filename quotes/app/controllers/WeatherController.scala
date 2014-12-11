package controllers

import play.api.mvc._
import scala.concurrent.Future
import services.weather.WeatherService
import play.api.libs.json.Json

import scala.concurrent.ExecutionContext.Implicits.global

object WeatherController extends Controller {
  
  def index = Action {
    Ok(views.html.weather(None))
  }
  
  def getWeather(city: String, country: Option[String]) = Action.async {
    WeatherService.find(city, country).map(result => result match {
      case Left(weather) => Ok(Json.arr(Json.toJson(weather)))
      case Right(error) => BadRequest(error)
    }
  )}

}