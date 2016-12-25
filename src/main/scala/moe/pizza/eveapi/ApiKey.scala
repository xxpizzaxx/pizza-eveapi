package moe.pizza.eveapi

trait XmlApiKey
case class ApiKey(keyId: Int, vCode: String) extends XmlApiKey
case class CrestApiKey(accessToken: String, accessType: String = "character") extends XmlApiKey
