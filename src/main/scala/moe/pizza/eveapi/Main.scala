package moe.pizza.eveapi


object Main extends App {
  // declare an API key
  implicit val apikey = Some(ApiKey(4, "X"))
  // create API object
  val api = new EVEAPI()
  // try to use it
  val l = api.eve.AllianceList()
}
