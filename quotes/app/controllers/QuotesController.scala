package controllers

import play.api.mvc.Controller
import play.api.mvc.Action
import services.quotes.QuoteService
import services.quotes.DatabaseQuoteService
import play.api.libs.json.Json

object QuotesController extends Controller {
  val service: QuoteService = DatabaseQuoteService
  
  def index = Action {
    Ok(views.html.index(None))
  }
  
  def getQuotes(keyword: String) = Action {
    Ok(Json.toJson(service.findByKeyword(keyword)))
  }

}