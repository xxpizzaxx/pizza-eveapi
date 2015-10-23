package moe.pizza.eveapi.cache

import moe.pizza.eveapi.XMLApiResponse

trait ApiCache[T] {
  def store(ck: CacheKey, r: XMLApiResponse[T]): Unit
  def retrieve(ck: CacheKey): Option[XMLApiResponse[T]]
}
