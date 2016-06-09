package moe.pizza.crestapi

import com.ning.http.util.Base64
import moe.pizza.crestapi.CrestApi.{VerifyResponse, CallbackResponse}
import moe.pizza.crestapi.contacts.Types.{ContactCreateInner, ContactCreate}
import org.http4s.Uri
import org.http4s._
import org.http4s.MediaType._
import org.http4s.headers.`Content-Type`

import io.circe._, io.circe.generic.auto._, io.circe.parser._, io.circe.syntax._
import scala.annotation.tailrec
import scala.concurrent.{Await, ExecutionContext}
import scala.util.Try
import org.http4s.client.blaze._
import scalaz.concurrent.Task

object CrestApi {
  case class CallbackResponse(access_token: String, token_type: String, expires_in: Long, refresh_token: Option[String])
  case class VerifyResponse(
                             CharacterID: Long,
                             CharacterName: String,
                             ExpiresOn: String,
                             Scopes: String,
                             TokenType: String,
                             CharacterOwnerHash: String,
                             IntellectualProperty: String
                             )
}

class CrestApi(baseurl: String = "https://login.eveonline.com", cresturl: String ="https://crest-tq.eveonline.com", clientID: String, secretKey: String, redirectUrl: String) {
  val baseuri = Uri.fromString(baseurl).toOption.get
  val cresturi = Uri.fromString(cresturl).toOption.get
  val client = PooledHttp1Client()

  def redirect(state: String, scopes: Seq[String]) = {
    val scopesreq = scopes.mkString("%20")
    baseurl + s"/oauth/authorize/?response_type=code&redirect_uri=$redirectUrl&client_id=$clientID&scope=$scopesreq&state=$state"
  }

  def callback(code: String, grantType: String = "authorization_code", payloadName: String = "code"): Task[CallbackResponse] = {
    val header = Base64.encode(s"$clientID:$secretKey".getBytes)
    val fulluri = (baseuri / "oauth" / "token")
    println(fulluri.host)
    val req = new Request(method = Method.POST, uri = fulluri)
      .putHeaders(Header("Authorization", s"Basic $header"), Header("Host", "login.eveonline.com"))
      .withContentType(Some(`Content-Type`(`application/x-www-form-urlencoded`)))
      .withBody(UrlForm.apply("grant_type" -> grantType, payloadName -> code)).run
    println(req)
    val res = client.fetchAs[String](req)
    res.map { s => decode[CallbackResponse](s).toOption.get }
  }

  def refresh(s: String) = callback(s, "refresh_token", "refresh_token")

  def verify(token: String): Task[VerifyResponse] = {
    val fulluri = baseuri / "oauth" / "verify"
    val res = client.fetchAs[String](new Request(uri = fulluri).putHeaders(Header("Authorization", s"Bearer $token")))
    res.map{s => decode[VerifyResponse](s).toOption.get }
  }

  object character {
    def location(characterID: Long, token: String): Task[moe.pizza.crestapi.character.location.Types.Location] = {
      val fulluri = cresturi / "characters" / characterID.toString / "location" / ""
      val res = client.fetchAs[String](new Request(uri = fulluri).putHeaders(Header("Authorization", s"Bearer $token")))
      res.map(s => decode[moe.pizza.crestapi.character.location.Types.Location](s).toOption.get)
    }
  }

}
