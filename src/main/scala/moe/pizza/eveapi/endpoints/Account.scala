package moe.pizza.eveapi.endpoints

import moe.pizza.eveapi.generated.account

import moe.pizza.eveapi.{ApiRequest, ApiKey}

import scala.concurrent.ExecutionContext

class Account(baseurl: String, apikey: Option[ApiKey])(implicit ex: ExecutionContext) {
  def AccountStatus() = new ApiRequest[account.AccountStatus.Eveapi](baseurl, "Account/AccountStatus.xml.aspx", apikey).apply().map(_.map(_.result))
  def APIKeyInfo() = new ApiRequest[account.APIKeyInfo.Eveapi](baseurl, "Account/APIKeyInfo.xml.aspx", apikey).apply().map(_.map(_.result))
  def Characters() = new ApiRequest[account.Characters.Eveapi](baseurl, "Account/Characters.xml.aspx", apikey).apply().map(_.map(_.result))
}
