package models

import play.api.db.slick.Config.driver.simple._

class Quotes(tag: Tag) extends Table[Quote](tag, "quotes") {
      def id = column[Long]("id", O.PrimaryKey, O.AutoInc)
      def author = column[String]("author", O.NotNull)
			def text = column[String]("text", O.NotNull)
			
			def * = (id.?, author, text) <> ((Quote.apply _).tupled, Quote.unapply)
}
