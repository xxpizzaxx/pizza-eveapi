package moe.pizza.crestapi

import moe.pizza.crestapi.contacts.Types.{ContactCreate, ContactCreateInner}
import moe.pizza.evewho.Evewho

import scala.concurrent.Await
import scala.concurrent.ExecutionContext.Implicits.global
import moe.pizza.eveapi.{EVEAPI, SyncableFuture}
import org.http4s.client.blaze.PooledHttp1Client

import scala.concurrent.duration._
import scala.language.postfixOps
import scala.io.StdIn

/**
 * Created by Andi on 20/01/2016.
 */
object CrestExample extends App {

  val crest = new CrestApi(baseurl = "https://sisilogin.testeveonline.com/", cresturl="https://api-sisi.testeveonline.com/", "e", "q", "http://api.pizza.moe:9005/callback")
  implicit val client = PooledHttp1Client()

  val redirect = crest.redirect("teststate", List("esi-mail.send_mail.v1", "characterLocationRead"))
  println("go to this url, get the redirect code and paste it here")
  println(redirect)
  val callback = StdIn.readLine()

  println("requesting the callback results")
  val r = crest.callback(callback).unsafePerformSync
  println(r)

  println("refreshing access token")
  val refreshed = crest.refresh(r.refresh_token.get).unsafePerformSync
  println(refreshed)


  println("verifying")
  val verify = crest.verify(refreshed.access_token).unsafePerformSync
  println(verify)

  println("reading location")
  val location = crest.character.location(verify.CharacterID, refreshed.access_token).unsafePerformSync
  println(location)

  /*println("reading contacts")
  val contacts = crest.contacts.getContacts(verify.characterID, refreshed.access_token).unsafePerformSync
  println(contacts)


  println("adding wheniaminspace")
  val newcontact = ContactCreate(-10, "character", ContactCreateInner("1109604843", "https://api-sisi.testeveonline.com/characters/1109604843/", "wheniaminspace", 1109604843), true)
  val createresult = crest.contacts.createContact(verify.characterID, refreshed.access_token, newcontact).unsafePerformSync
  println(createresult)

  println("adding all of Snigg")
  val eveapi = new EVEAPI()
  val evewho = new Evewho()
  val corpname = "Sniggerdly"
  val corpid = eveapi.eve.CharacterID(Seq(corpname)).unsafePerformSync.result.head.characterID.toLong
  val characters = evewho.corporationList(corpid).unsafePerformSync.characters
  val requests = characters.map { c =>
    crest.contacts.createCharacterAddRequest(-10, c.character_id, c.name, watch=true)
  }
  println("adding %d contacts".format(requests.size))
  val doit = requests.map(n => crest.contacts.createContact(verify.characterID, refreshed.access_token, n))
  doit.foreach{d => Await.result(d, 60 seconds)}
  println("done")
  */

  client.shutdown.unsafePerformSync


}
