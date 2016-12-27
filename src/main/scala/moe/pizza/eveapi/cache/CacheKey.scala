package moe.pizza.eveapi.cache

case class CacheKey(server: String, endpoint: String, args: Map[String, String])
