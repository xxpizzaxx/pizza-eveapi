package moe.pizza.eveapi.cache

import moe.pizza.eveapi.XMLApiResponse

import scala.collection.mutable


class RamCache[T] extends ApiCache[T] {
  val storage = mutable.Map[CacheKey, XMLApiResponse[T]]()
  override def store(ck: CacheKey, r: XMLApiResponse[T]): Unit = storage.put(ck, r)
  override def retrieve(ck: CacheKey): Option[XMLApiResponse[T]] = storage.get(ck)
}
