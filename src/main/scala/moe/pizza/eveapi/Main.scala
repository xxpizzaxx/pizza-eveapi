package moe.pizza.eveapi

import scala.concurrent.ExecutionContext.Implicits.global
import scala.language.postfixOps

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
  val characterids = r.map(_.result) getOrElse(List()) map(_.characterID)
  // look up the characterinfo asynchronously
  val infoLookups = characterids.map{_.toLong}.map{api.eve.CharacterInfo}
  // attach callbacks
  infoLookups.foreach{_.onSuccess{
    case Left(l) =>
      val char = l.result
      println("character %s is of bloodline %s and has security status %f".format(char.characterName, char.bloodline, char.securityStatus))
    case Right(r) =>
      val char = r.result
      println("character %s is of bloodline %s and has security status %f and is in alliance %s".format(char.characterName, char.bloodline, char.securityStatus, char.alliance))
    }
  }
  // end our main method
  println("done")
}
