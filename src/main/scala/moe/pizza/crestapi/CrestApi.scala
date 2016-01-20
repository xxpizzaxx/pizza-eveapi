package moe.pizza.crestapi

import java.util.Base64

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import dispatch._
import moe.pizza.crestapi.CrestApi.CallbackResponse

import scala.concurrent.ExecutionContext

object CrestApi {
  case class CallbackResponse(access_token: String, token_type: String, expires_in: Long, refresh_token: Option[String])
}

class CrestApi(baseurl: String = "https://login.eveonline.com/", clientID: String, secretKey: String, redirectUrl: String) {
  val OM = new ObjectMapper()
  OM.registerModule(DefaultScalaModule)

  def redirect(state: String, scopes: Seq[String]) = {
    val scopesreq = scopes.mkString("%20")
    baseurl + s"/oauth/authorize/?response_type=code&redirect_uri=$redirectUrl&client_id=$clientID&scope=$scopesreq&state=$state"
  }

  def callback(code: String)(implicit ec: ExecutionContext): Future[CallbackResponse] = {
    val header = Base64.getEncoder.encodeToString(s"$clientID:$secretKey".getBytes)
    val req = url(baseurl + "/oauth/token")
      .POST
      .addHeader("Authorization", s"Basic $header")
      .addParameter("grant_type", "authorization_code")
      .addParameter("code", code)

    val r = Http(req OK as.String)
    r.map{s => OM.readValue(s, classOf[CallbackResponse])}
  }


  def refresh(token: String)(implicit ec: ExecutionContext): Future[CallbackResponse] = {
    val header = Base64.getEncoder.encodeToString(s"$clientID:$secretKey".getBytes)
    val req = url(baseurl + "/oauth/token")
      .POST
      .addHeader("Authorization", s"Basic $header")
      .addParameter("grant_type", "refresh_token")
      .addParameter("refresh_token", token)

    val r = Http(req OK as.String)
    r.map{s => OM.readValue(s, classOf[CallbackResponse])}

  }
}
