package moe.pizza.eveapi

import org.http4s.client.blaze.PooledHttp1Client

import scala.concurrent.ExecutionContext.Implicits.global
import scala.language.postfixOps
import scala.concurrent._
import scala.concurrent.duration._
import scalaz.concurrent.Task

object Main extends App {
  // declare an API key
  implicit val apikey = Some(ApiKey(4, "X"))
  // create API object
  val client = PooledHttp1Client()
  val api = new EVEAPI(client)
  // do API things
  // Get the IDs of these characters and wait 2 seconds for the result
  val r = api.eve.CharacterID(List("Lucia Denniard", "wheniaminspace", "capqu")).runFor(2 seconds)
  // get a list of IDs
  val characterids = r.result map(_.characterID)
  // look up the characterinfo asynchronously
  val infoLookups = characterids.map{_.toLong}.map{api.eve.CharacterInfo}
  // attach callbacks
  val main = infoLookups.map{_.map {
    case Left(l) =>
      val char = l.result
      println("character %s is of bloodline %s and has security status %f".format(char.characterName, char.bloodline, char.securityStatus))
    case Right(r) =>
      val char = r.result
      println("character %s is of bloodline %s and has security status %f and is in alliance %s".format(char.characterName, char.bloodline, char.securityStatus, char.alliance))
  }}
  Task.gatherUnordered(main).run
  // end our main method
  println("done")
  client.shutdown.run
}
