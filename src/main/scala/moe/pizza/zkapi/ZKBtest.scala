package moe.pizza.zkapi

import scala.concurrent.ExecutionContext.Implicits.global

/**
 * Created by andi on 12/11/15.
 */
import moe.pizza.eveapi._

object ZKBtest extends App {
  val r = new ZKBRequest(useragent = "test-client").kills().solarSystemID(31002377).build()
  val sr = r.sync()
  println(sr.get.head.attackers)

}
