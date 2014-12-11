package services.quotes

import models.Quote

trait QuoteService {

  def findByKeyword(keyword: String): Seq[Quote] = {
    find(text => text.toLowerCase.contains(keyword.toLowerCase))
  }
  
  def findByLength(from: Long = 0, to: Long = 128): Seq[Quote] = {
    find(text => text.length() > from && text.length() < to)
  }

  def find(predicate: String => Boolean): Seq[Quote]

}