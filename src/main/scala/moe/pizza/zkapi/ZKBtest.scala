package moe.pizza.zkapi

import scala.concurrent.ExecutionContext.Implicits.global

/**
 * Created by andi on 12/11/15.
 */
import moe.pizza.eveapi._

object ZKBtest extends App {
  val zkb = new ZKBAPI(useragent = "test-client")
  /*
  val r = zkb.query.kills().solarSystemID(31002377).build()
  val sr = r.sync()
  println(sr.get.head.attackers)
  */

  val result = zkb.stats.alliance(1727758877).sync()
  println(result.get.supers.supercarriers.data ++ result.get.supers.titans.data)

  val result2 = zkb.stats.corporation(828800677).sync()
  println(result2.get.supers.supercarriers.data ++ result2.get.supers.titans.data)

  val result3 = zkb.autocomplete(zkb.autocomplete.Filters.corporationID, "jita").sync()
  println(result3)

  // streaming
  val redisqr = zkb.redisq.poll().sync()
  println(redisqr)

  val stream = zkb.redisq.stream()
  val ten = stream take(10)
  ten.foreach{println}
}
