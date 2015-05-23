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
  // get a list of IDs in a way that fails gracefully
  val characterids = r getOrElse(List()) map(_.characterID)
  // look up the characterinfo asynchronously
  val infoLookups = characterids.map{_.toLong}.map{api.eve.CharacterInfo}
  // attach callbacks
  infoLookups.foreach{_.onSuccess{
    case lookup => lookup.map { char =>
      println("character %s is of bloodline %s and has security status %f".format(char.characterName, char.bloodline, char.securityStatus))
    }
  }}
  // end our main method
  println("done")
}
