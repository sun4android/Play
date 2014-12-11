import play.api._
import play.api.db.slick._
import play.api.Play.current
import scala.slick.driver.H2Driver.simple._
import models.Quote
import models.Quotes

/**
 * Just to populate database with some quotes
 */
object Global extends GlobalSettings {

  override def onStart(app: Application) {
    val quotes = TableQuery[Quotes]

    DB.withSession { implicit session =>
      if (quotes.list.size == 0) {
        quotes += Quote(None, "Albert Einstein", "You have to learn the rules of the game. And then you have to play better than anyone else.")
        quotes += Quote(None, "Albert Einstein", "The only source of knowledge is experience.")
        quotes += Quote(None, "Henry David Thoreau", "It's not what you look at that matters, it's what you see.")
        quotes += Quote(None, "David Ben-Gurion", "If an expert says it can't be done, get another expert.")
        quotes += Quote(None, "Henry David Thoreau", "Success usually comes to those who are too busy to be looking for it.")
        quotes += Quote(None, "David Frost", "Don't aim for success if you want it; just do what you love and believe in, and it will come naturally.")
      }
    }
  }

}