package moe.pizza.eveapi.examples

import moe.pizza.eveapi._

import scala.concurrent.ExecutionContext.Implicits.global

object Allies extends App {
  // declare an API key
  implicit val apikey = Some(ApiKey(4, "J"))
  // create API object
  val api = new EVEAPI()
  // get all entities that are over 4.9 to the alliance
  val contacts = api.corp.ContactList().sync().map{_.result}.map {
    _.find {
      _.name.startsWith("alliance")
    }.map {
      _.row.filter {
        _.standing > 4.9
      }
    }
  }.getOrElse(Some(Seq.empty)).getOrElse(Seq.empty)

  // Find all current alliances in EVE
  val allKnownAllianceIds = api.eve.AllianceList().sync().map{_.result}.map{_.flatMap{_.allianceID}}.getOrElse{Seq.empty}
  // Count how many are in our contacts
  val alliancesCount = contacts.count(c => allKnownAllianceIds.contains(c.contactID))
  // Tell the user
  println("We found %d alliances in the list".format(alliancesCount))
  // Filter those out
  val blueAlliances = contacts.filter(c => allKnownAllianceIds.contains(c.contactID))
  // Tell the user their names
  println("All blue alliances are: %s".format(blueAlliances.map{_.contactName}))
}