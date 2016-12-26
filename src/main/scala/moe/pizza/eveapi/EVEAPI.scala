package moe.pizza.eveapi

import org.http4s.client.Client

class EVEAPI(client: Client, baseurl: String = "https://api.eveonline.com/", key: Option[XmlApiKey] = None) {
  implicit val c = client
  val account = new endpoints.Account(baseurl, key)
  val char = new endpoints.Character(baseurl, key)
  val corp = new endpoints.Corp(baseurl, key)
  val eve = new endpoints.Eve(baseurl)
  val map = new endpoints.Map(baseurl)
  val server = new endpoints.Server(baseurl)
}
