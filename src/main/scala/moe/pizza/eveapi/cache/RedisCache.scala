package moe.pizza.eveapi.cache

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import com.redis.RedisClient
import moe.pizza.eveapi.XMLApiResponse


class RedisCache[T](host: String, port: Int) extends ApiCache[T] {
  val client = new RedisClient(host, port)
  val OM = new ObjectMapper()
  OM.registerModule(DefaultScalaModule)
  override def store(ck: CacheKey, r: XMLApiResponse[T]): Unit = client.set(ck.hashCode().toString, OM.writeValueAsString(r))
  override def retrieve(ck: CacheKey): Option[XMLApiResponse[T]] = client.get(ck.hashCode().toString).map{OM.readValue(_, classOf[XMLApiResponse[T]])}
}
