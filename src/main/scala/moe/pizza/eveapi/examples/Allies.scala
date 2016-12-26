package moe.pizza.eveapi.examples

import moe.pizza.eveapi._
import org.http4s.client.blaze.PooledHttp1Client

import scala.concurrent.ExecutionContext.Implicits.global

object Allies extends App {
  // declare an API key
  implicit val apikey = Some(ApiKey(4, "J"))
  // create API object
  val client = PooledHttp1Client()
  val api = new EVEAPI(client)
  // get all entities that are over 4.9 to the alliance
  val contacts = api.corp.ContactList().run.result.find {
      _.name.startsWith("alliance")
    }.map {
      _.row.filter {
        _.standing > 4.9
      }
  }.getOrElse(Seq.empty)

  // Find all current alliances in EVE
  val allKnownAllianceIds = api.eve.AllianceList().run.result.map{_.allianceID}
  // Count how many are in our contacts
  val alliancesCount = contacts.count(c => allKnownAllianceIds.contains(c.contactID))
  // Tell the user
  println("We found %d alliances in the list".format(alliancesCount))
  // Filter those out
  val blueAlliances = contacts.filter(c => allKnownAllianceIds.contains(c.contactID))
  // Tell the user their names
  println("All blue alliances are: %s".format(blueAlliances.map{_.contactName}))
}