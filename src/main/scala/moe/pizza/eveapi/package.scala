package moe.pizza

import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat

import scala.concurrent.{Await, Future}
import scala.concurrent.duration._
import scala.language.postfixOps

package object eveapi {

  /**
    * Provide a simple .sync() function on all the futures we return
    */
  implicit class SyncableFuture[T](f: Future[T]) {
    def sync(duration: Duration = 10 seconds): T = {
      Await.result(f, duration)
    }
  }

  /**
    * Add a .toDateTime to strings so we can parse XML API style timestamps
    * @param s
    */
  implicit class XmlDate(s: String) {
    def toDateTime = {
      DateTime.parse(s, DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss"))
    }

  }
}
