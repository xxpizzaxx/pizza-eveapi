package moe.pizza.eveapi

import scala.concurrent.ExecutionContext.Implicits.global

import scala.concurrent._
import scala.concurrent.duration._

object Main extends App {
  // declare an API key
  implicit val apikey = Some(ApiKey(4, "X"))
  // create API object
  val api = new EVEAPI()
  // do API things
  // Get the IDs of these characters and wait 2 seconds for the result
  val r = Await.result(api.eve.CharacterID(List("Lucia Denniard", "wheniaminspace", "capqu")), 2 seconds)
  // assume we got a result and pull the character IDs out
  val characterids = r.get.map(_.characterID)
  // look up the characterinfo asynchronously
  val info = characterids.map{_.toLong}.map{api.eve.CharacterInfo}
  // attach callbacks
  info.foreach{_.onSuccess{
    case chardata => println(chardata)
  }}
  // end our main method
  println("done")
}
