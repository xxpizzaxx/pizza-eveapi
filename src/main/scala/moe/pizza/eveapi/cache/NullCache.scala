package moe.pizza.eveapi.cache

import moe.pizza.eveapi.XMLApiResponse

class NullCache[T] extends ApiCache[T] {
  override def retrieve(ck: CacheKey): Option[XMLApiResponse[T]] = None
  override def store(ck: CacheKey, r: XMLApiResponse[T]): Unit = ()
}
