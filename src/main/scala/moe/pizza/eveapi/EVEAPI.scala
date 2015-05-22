package moe.pizza.eveapi


class EVEAPI(baseurl: String = "https://api.eveonline.com/")(implicit val key: Option[ApiKey] = None) {
  val account = new endpoints.Account(baseurl, key)
  val char = new endpoints.Character(baseurl, key)
  val eve = new endpoints.Eve(baseurl)
}
