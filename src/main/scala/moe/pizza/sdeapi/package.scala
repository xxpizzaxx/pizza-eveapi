package moe.pizza

import slick.driver.MySQLDriver
import slick.jdbc.JdbcBackend

import scala.concurrent.{Await, Future}
import scala.concurrent.duration._

/**
 * Created by Andi on 05/11/2015.
 */
package object sdeapi {
  /**
   * Provide a simple .sync() function on all the futures we return
   */
  implicit class SyncableFuture[T](f: Future[T]) {
    def sync(duration: Duration = 10 seconds): T = {
      Await.result(f, duration)
    }
  }
  implicit class RunnableMysqlStreamingAction[+R, +T, -E <: slick.dbio.Effect](m: MySQLDriver.StreamingDriverAction[R, T, E]) {
    def run(d: JdbcBackend.DatabaseDef) = {
      d.run(m)
    }
  }
}
