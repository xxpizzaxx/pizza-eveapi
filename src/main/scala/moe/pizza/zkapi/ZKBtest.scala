package moe.pizza.zkapi

/**
 * Created by andi on 12/11/15.
 */
import moe.pizza.eveapi._

object ZKBtest extends App {
  import scala.concurrent.ExecutionContext.Implicits.global
  val r = new ZKBRequest(useragent = "test-client").kills().solarSystemID(31002377).build(global)
  val sr = r.sync()
  println(sr.get.head.attackers)

}
