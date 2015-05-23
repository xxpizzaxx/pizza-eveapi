package moe.pizza.eveapi

import scala.concurrent.{Await, Future, ExecutionContext}
import scala.concurrent.duration._


class EVEAPI(baseurl: String = "https://api.eveonline.com/")(implicit val key: Option[ApiKey] = None, implicit val ec: ExecutionContext) {
  val account = new endpoints.Account(baseurl, key)
  val char = new endpoints.Character(baseurl, key)
  val eve = new endpoints.Eve(baseurl)


}
