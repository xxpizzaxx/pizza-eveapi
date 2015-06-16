package moe.pizza

import scala.concurrent.{Await, Future}
import scala.concurrent.duration._

package object eveapi {
  /**
   * Provide a simple .sync() function on all the futures we return
   */
  implicit class SyncableFuture[T](f: Future[T]) {
    def sync(duration: Duration = 10 seconds): T = {
      Await.result(f, duration)
    }
  }
}
