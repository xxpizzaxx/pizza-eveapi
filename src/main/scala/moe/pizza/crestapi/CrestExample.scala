package moe.pizza.crestapi

import moe.pizza.crestapi.contacts.Types.{ContactCreateInner, ContactCreate}
import moe.pizza.evewho.Evewho

import scala.concurrent.Await
import scala.concurrent.ExecutionContext.Implicits.global
import moe.pizza.eveapi.{EVEAPI, SyncableFuture}
import scala.concurrent.duration._

import scala.io.StdIn

/**
 * Created by Andi on 20/01/2016.
 */
object CrestExample extends App {

  val crest = new CrestApi(baseurl = "https://sisilogin.testeveonline.com/", cresturl="https://api-sisi.testeveonline.com/", "c", "G", "http://api.pizza.moe:9005/callback")

  val redirect = crest.redirect("teststate", List("characterContactsWrite", "characterContactsRead"))
  println("go to this url, get the redirect code and paste it here")
  println(redirect)
  val callback = StdIn.readLine()

  println("requesting the callback results")
  val r = crest.callback(callback).sync()
  println(r)

  println("refreshing access token")
  val refreshed = crest.refresh(r.refresh_token.get).sync()
  println(refreshed)


  println("verifying")
  val verify = crest.verify(refreshed.access_token).sync()
  println(verify)

  println("reading contacts")
  val contacts = crest.contacts.getContacts(verify.characterID, refreshed.access_token).sync()
  println(contacts)


  println("adding wheniaminspace")
  val newcontact = ContactCreate(-10, "character", ContactCreateInner("1109604843", "https://api-sisi.testeveonline.com/characters/1109604843/", "wheniaminspace", 1109604843), true)
  val createresult = crest.contacts.createContact(verify.characterID, refreshed.access_token, newcontact).sync()
  println(createresult)

  println("adding all of Snigg")
  val eveapi = new EVEAPI()
  val evewho = new Evewho()
  val corpname = "Sniggerdly"
  val corpid = eveapi.eve.CharacterID(Seq(corpname)).sync().get.result.head.characterID.toLong
  val characters = evewho.corporationList(corpid).sync().get.characters
  val requests = characters.map { c =>
    crest.contacts.createCharacterAddRequest(-10, c.character_id, c.name, watch=true)
  }
  println("adding %d contacts".format(requests.size))
  val doit = requests.map(n => crest.contacts.createContact(verify.characterID, refreshed.access_token, n))
  doit.foreach{d => Await.result(d, 60 seconds)}
  println("done")


}
