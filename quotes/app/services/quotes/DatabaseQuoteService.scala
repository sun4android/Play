package services.quotes

import models.Quote
import scala.slick.lifted.TableQuery
import models.Quotes

import play.api.Play.current
import play.api.db.slick.Config.driver.simple._
import play.api.db.slick.DB

object DatabaseQuoteService extends QuoteService {
  private val quotes = TableQuery[Quotes]

  override def find(predicate: String => Boolean): Seq[Quote] = {
    DB.withSession { implicit session =>
      quotes.list.filter(quote => predicate(quote.text))
    }
  }

}