package moe.pizza.crestapi

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import com.ning.http.util.Base64
import dispatch._
import moe.pizza.crestapi.CrestApi.{VerifyResponse, CallbackResponse}
import moe.pizza.crestapi.contacts.Types.{ContactCreateInner, ContactCreate}

import scala.annotation.tailrec
import scala.concurrent.ExecutionContext

object CrestApi {
  case class CallbackResponse(access_token: String, token_type: String, expires_in: Long, refresh_token: Option[String])
  case class VerifyResponse(
                             @JsonProperty("CharacterID") characterID: Long,
                             @JsonProperty("CharacterName") characterName: String,
                             @JsonProperty("ExpiresOn") expiresOn: String,
                             @JsonProperty("Scopes") scopes: String,
                             @JsonProperty("TokenType") tokenType: String,
                             @JsonProperty("CharacterOwnerHash") characterOwnerHash: String,
                             @JsonProperty("IntellectualProperty") intellectualProperty: String
                             )
}

class CrestApi(baseurl: String = "https://login.eveonline.com/", cresturl: String ="https://crest-tq.eveonline.com/", clientID: String, secretKey: String, redirectUrl: String) {
  val OM = new ObjectMapper()
  OM.registerModule(DefaultScalaModule)

  def redirect(state: String, scopes: Seq[String]) = {
    val scopesreq = scopes.mkString("%20")
    baseurl + s"/oauth/authorize/?response_type=code&redirect_uri=$redirectUrl&client_id=$clientID&scope=$scopesreq&state=$state"
  }

  def callback(code: String)(implicit ec: ExecutionContext): Future[CallbackResponse] = {
    val header = Base64.encode(s"$clientID:$secretKey".getBytes)
    val req = url(baseurl + "/oauth/token")
      .POST
      .addHeader("Authorization", s"Basic $header")
      .addParameter("grant_type", "authorization_code")
      .addParameter("code", code)

    val r = Http(req OK as.String)
    r.map{s => OM.readValue(s, classOf[CallbackResponse])}
  }


  def refresh(token: String)(implicit ec: ExecutionContext): Future[CallbackResponse] = {
    val header = Base64.encode(s"$clientID:$secretKey".getBytes)
    val req = url(baseurl + "/oauth/token")
      .POST
      .addHeader("Authorization", s"Basic $header")
      .addParameter("grant_type", "refresh_token")
      .addParameter("refresh_token", token)

    val r = Http(req OK as.String)
    r.map{s => OM.readValue(s, classOf[CallbackResponse])}

  }

  def verify(token: String)(implicit ec: ExecutionContext): Future[VerifyResponse] = {
    val req = url(baseurl + "/oauth/verify")
      .GET
      .addHeader("Authorization", s"Bearer $token")
    val r = Http(req OK as.String)
    r.map{s => OM.readValue(s, classOf[VerifyResponse])}
  }

  object contacts {
    def createCharacterAddRequest(standing: Int, id: Long, name: String, watch: Boolean) =
      ContactCreate(standing, "character", ContactCreateInner(id.toString, s"${cresturl}characters/$id/", name, id), watch)

    def getContacts(characterID: Long, token: String)(implicit ec: ExecutionContext): Future[moe.pizza.crestapi.contacts.Types.ContactList] = {
      val req = url(cresturl + s"characters/$characterID/contacts/")
        .GET
        .addHeader("Authorization", s"Bearer $token")
      val r = Http(req OK as.String)
      r.map(s => OM.readValue(s, classOf[moe.pizza.crestapi.contacts.Types.ContactList]))
    }

    def createContact(characterID: Long, token: String, payload: moe.pizza.crestapi.contacts.Types.ContactCreate)(implicit ec: ExecutionContext): Future[String] = {
      println(payload)
      val req = url(cresturl + s"characters/$characterID/contacts/")
        .POST
        .addHeader("Authorization", s"Bearer $token")
        .setContentType("application/json", "UTF-8")
        .setBody(OM.writeValueAsString(payload))
      val r = Http(req OK as.String)
      r
    }
  }
}
