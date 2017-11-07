package moe.pizza.crestapi

import com.ning.http.util.Base64
import moe.pizza.crestapi.CrestApi.{CallbackResponse, VerifyResponse}
import moe.pizza.crestapi.contacts.Types.{ContactCreate, ContactCreateInner}
import org.http4s.Uri
import org.http4s._
import org.http4s.MediaType._
import org.http4s.headers.`Content-Type`
import org.http4s.circe._
import io.circe._
import io.circe.generic.JsonCodec
import io.circe.generic.auto._
import io.circe.parser._
import io.circe.syntax._
import org.http4s.client.Client

import scala.annotation.tailrec
import scala.concurrent.{Await, ExecutionContext}
import scala.util.Try
import org.http4s.client.blaze._

import scalaz.concurrent.Task

object CrestApi {
  case class CallbackResponse(access_token: String,
                              token_type: String,
                              expires_in: Long,
                              refresh_token: Option[String])
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

class CrestApi(baseurl: String = "https://login.eveonline.com",
               cresturl: String = "https://crest-tq.eveonline.com",
               clientID: String,
               secretKey: String,
               redirectUrl: String) {
  val baseuri  = Uri.fromString(baseurl).toOption.get
  val cresturi = Uri.fromString(cresturl).toOption.get

  def redirect(state: String, scopes: Seq[String]) = {
    val scopesreq = scopes.mkString("%20")
    baseurl + s"/oauth/authorize/?response_type=code&redirect_uri=$redirectUrl&client_id=$clientID&scope=$scopesreq&state=$state"
  }

  def callback(code: String, grantType: String = "authorization_code", payloadName: String = "code")(
      implicit c: Client): Task[CallbackResponse] = {
    val header  = Base64.encode(s"$clientID:$secretKey".getBytes)
    val fulluri = (baseuri / "oauth" / "token")
    val req = new Request(method = Method.POST, uri = fulluri)
      .putHeaders(Header("Authorization", s"Basic $header")) //, Header("Host", baseurl.stripPrefix("https://")))
      .withContentType(Some(`Content-Type`(`application/x-www-form-urlencoded`)))
      .withBody(UrlForm.apply("grant_type" -> grantType, payloadName -> code))
      .unsafePerformSync
    c.expect[CallbackResponse](req)(jsonOf[CallbackResponse])
  }

  def refresh(s: String)(implicit c: Client) = callback(s, "refresh_token", "refresh_token")(c)

  def verify(token: String)(implicit c: Client): Task[VerifyResponse] = {
    val fulluri = baseuri / "oauth" / "verify"
    c.expect[VerifyResponse](new Request(uri = fulluri).putHeaders(Header("Authorization", s"Bearer $token")))(
      jsonOf[VerifyResponse]
    )
  }

  object character {
    import moe.pizza.crestapi.character.location.Types.Location
    def location(characterID: Long, token: String)(implicit c: Client): Task[Location] = {
      val fulluri = cresturi / "characters" / characterID.toString / "location" / ""
      c.expect[Location](new Request(uri = fulluri).putHeaders(Header("Authorization", s"Bearer $token")))(
        jsonOf[Location]
      )
    }
  }

}
