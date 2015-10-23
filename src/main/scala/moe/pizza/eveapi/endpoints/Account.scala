package moe.pizza.eveapi.endpoints

import moe.pizza.eveapi.generated.account
import moe.pizza.eveapi.{ApiKey, ApiRequest, XMLApiResponse, XmlDate}

import scala.concurrent.ExecutionContext

class Account(baseurl: String, apikey: Option[ApiKey])(implicit ex: ExecutionContext) {
  def AccountStatus() = new ApiRequest[account.AccountStatus.Eveapi](baseurl, "Account/AccountStatus.xml.aspx", apikey).apply().map(_.map(r => new XMLApiResponse(r.currentTime.toDateTime, r.cachedUntil.toDateTime, r.result)))
  def APIKeyInfo() = new ApiRequest[account.APIKeyInfo.Eveapi](baseurl, "Account/APIKeyInfo.xml.aspx", apikey).apply().map(_.map(r => new XMLApiResponse(r.currentTime.toDateTime, r.cachedUntil.toDateTime, r.result)))
  def Characters() = new ApiRequest[account.Characters.Eveapi](baseurl, "Account/Characters.xml.aspx", apikey).apply().map(_.map(r => new XMLApiResponse(r.currentTime.toDateTime, r.cachedUntil.toDateTime, r.result)))
}
