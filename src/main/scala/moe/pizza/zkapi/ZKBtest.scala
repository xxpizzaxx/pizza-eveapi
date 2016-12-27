package moe.pizza.zkapi

import org.http4s.client.blaze.PooledHttp1Client

import scala.concurrent.ExecutionContext.Implicits.global

/**
  * Created by andi on 12/11/15.
  */
import moe.pizza.eveapi._

object ZKBtest extends App {

  implicit val c = PooledHttp1Client()

  val zkb = new ZKBAPI(useragent = "test-client")
  val r   = zkb.query.kills().solarSystemID(31002377).build()
  val sr  = r.unsafePerformSync
  println(sr.last.attackers)

  val result = zkb.stats.alliance(1727758877).unsafePerformSync
  println(result.supers.supercarriers.data ++ result.supers.titans.data)

  val result2 = zkb.stats.corporation(828800677).unsafePerformSync
  println(result2.supers.supercarriers.data ++ result2.supers.titans.data)

  val result25 = zkb.stats.character(90758388).unsafePerformSync
  println(result25)

  /*
  val result3 = zkb.autocomplete(zkb.autocomplete.Filters.solarSystemID, "jita").unsafePerformSync
  println(result3)
   */

  // streaming
  val redisqr = zkb.redisq.poll().unsafePerformSync
  println(redisqr)

  val stream = zkb.redisq.stream()
  val ten    = stream take (10)
  ten.foreach { println }
}
