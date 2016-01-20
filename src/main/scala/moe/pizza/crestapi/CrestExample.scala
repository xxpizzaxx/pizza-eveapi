package moe.pizza.crestapi

import scala.concurrent.ExecutionContext.Implicits.global
import moe.pizza.eveapi.SyncableFuture

import scala.io.StdIn

/**
 * Created by Andi on 20/01/2016.
 */
object CrestExample extends App {

  val crest = new CrestApi(baseurl = "https://sisilogin.testeveonline.com/", "c", "G", "http://api.pizza.moe:9005/callback")

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



}
