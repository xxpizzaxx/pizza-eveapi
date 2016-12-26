package moe.pizza.eveapi.endpoints

import moe.pizza.eveapi.generated.char
import moe.pizza.eveapi._
import org.http4s.client.Client

import scala.concurrent.ExecutionContext

class Character(baseurl: String, apikey: Option[XmlApiKey])(implicit c: Client) {
  def AccountBalance(characterID: Int) = new ApiRequest[char.AccountBalance.Eveapi](baseurl, "char/AccountBalance.xml.aspx", apikey, Map("characterID" -> characterID.toString)).apply().map{r => new XMLApiResponse(r.currentTime.toDateTime, r.cachedUntil.toDateTime, r.result.rowset.row)}
  def AssetList(characterID: Int) = new ApiRequest[char.AssetList.Eveapi](baseurl, "char/AssetList.xml.aspx", apikey, Map("characterID" -> characterID.toString)).apply().map{r => new XMLApiResponse(r.currentTime.toDateTime, r.cachedUntil.toDateTime, r.result.rowset.row)}
  def Blueprints(characterID: Int) = new ApiRequest[char.Blueprints.Eveapi](baseurl, "char/Blueprints.xml.aspx", apikey, Map("characterID" -> characterID.toString)).apply().map{r => new XMLApiResponse(r.currentTime.toDateTime, r.cachedUntil.toDateTime, r.result.rowset.row)}
  def CharacterInfo(characterID: Int) = new ApiRequest[char.CharacterInfo.Eveapi](baseurl, "char/CharacterSheet.xml.aspx", apikey, Map("characterID" -> characterID.toString)).apply().map{r => new XMLApiResponse(r.currentTime.toDateTime, r.cachedUntil.toDateTime, r.result)}
  def ContractItems(characterID: Int, ids: Seq[Long]) = new ApiRequest[char.ContractItems.Eveapi](baseurl, "char/ContractItems.xml.aspx", apikey, Map("characterID" -> characterID.toString, "ids" -> ids.mkString(","))).apply().map{r => new XMLApiResponse(r.currentTime.toDateTime, r.cachedUntil.toDateTime, r.result.rowset.row)}
  def Contracts(characterID: Int) = new ApiRequest[char.Contracts.Eveapi](baseurl, "char/Contracts.xml.aspx", apikey, Map("characterID" -> characterID.toString)).apply().map{r => new XMLApiResponse(r.currentTime.toDateTime, r.cachedUntil.toDateTime, r.result.rowset.row)}
  def KillMails(characterID: Int) = new ApiRequest[char.KillMails.Eveapi](baseurl, "char/KillMails.xml.aspx", apikey, Map("characterID" -> characterID.toString)).apply().map{r => new XMLApiResponse(r.currentTime.toDateTime, r.cachedUntil.toDateTime, r.result.rowset.row)}
  def MailBodies(characterID: Int, ids: Seq[Long]) = new ApiRequest[char.MailBodies.Eveapi](baseurl, "char/MailBodies.xml.aspx", apikey, Map("characterID" -> characterID.toString, "ids" -> ids.mkString(","))).apply().map{r => new XMLApiResponse(r.currentTime.toDateTime, r.cachedUntil.toDateTime, r.result.rowset.row)}
  def MarketOrder(characterID: Int) = new ApiRequest[char.MarketOrder.Eveapi](baseurl, "char/MarketOrder.xml.aspx", apikey, Map("characterID" -> characterID.toString)).apply().map{r => new XMLApiResponse(r.currentTime.toDateTime, r.cachedUntil.toDateTime, r.result.rowset.row)}
  def Medals(characterID: Int) = new ApiRequest[char.Medals.Eveapi](baseurl, "char/Medals.xml.aspx", apikey, Map("characterID" -> characterID.toString)).apply().map{r => new XMLApiResponse(r.currentTime.toDateTime, r.cachedUntil.toDateTime, r.result.rowset)}
  def Notifications(characterID: Int) = new ApiRequest[char.Notifications.Eveapi](baseurl, "char/Notifications.xml.aspx", apikey, Map("characterID" -> characterID.toString)).apply().map{r => new XMLApiResponse(r.currentTime.toDateTime, r.cachedUntil.toDateTime, r.result.rowset.row)}
  def NotificationTexts(characterID: Int, ids: Seq[Long]) = new ApiRequest[char.NotificationTexts.Eveapi](baseurl, "char/NotificationTexts.xml.aspx", apikey, Map("characterID" -> characterID.toString, "ids" -> ids.mkString(","))).apply().map{r => new XMLApiResponse(r.currentTime.toDateTime, r.cachedUntil.toDateTime, r.result.rowset.row)}
  def SkillInTraining(characterID: Int) = new ApiRequest[char.SkillInTraining.Eveapi](baseurl, "char/SkillInTraining.xml.aspx", apikey, Map("characterID" -> characterID.toString)).apply().map{r => new XMLApiResponse(r.currentTime.toDateTime, r.cachedUntil.toDateTime, r.result)}
  def SkillQueue(characterID: Int) = new ApiRequest[char.SkillQueue.Eveapi](baseurl, "char/SkillQueue.xml.aspx", apikey, Map("characterID" -> characterID.toString)).apply().map{r => new XMLApiResponse(r.currentTime.toDateTime, r.cachedUntil.toDateTime, r.result.rowset.row)}
  def Standings(characterID: Int) = new ApiRequest[char.Standings.Eveapi](baseurl, "char/Standings.xml.aspx", apikey, Map("characterID" -> characterID.toString)).apply().map{r => new XMLApiResponse(r.currentTime.toDateTime, r.cachedUntil.toDateTime, r.result.characterNPCStandings.rowset)}
  def UpcomingCalendarEvents(characterID: Int) = new ApiRequest[char.UpcomingCalendarEvents.Eveapi](baseurl, "char/UpcomningCalendarEvents.xml.aspx", apikey, Map("characterID" -> characterID.toString)).apply().map{r => new XMLApiResponse(r.currentTime.toDateTime, r.cachedUntil.toDateTime, r.result.rowset.row)}
  def WalletJournal(characterID: Int) = new ApiRequest[char.WalletJournal.Eveapi](baseurl, "char/WalletJournal.xml.aspx", apikey, Map("characterID" -> characterID.toString)).apply().map{r => new XMLApiResponse(r.currentTime.toDateTime, r.cachedUntil.toDateTime, r.result.rowset.row)}
  def WalletTransactions(characterID: Int) = new ApiRequest[char.WalletTransactions.Eveapi](baseurl, "char/WalletTransactions.xml.aspx", apikey, Map("characterID" -> characterID.toString)).apply().map{r => new XMLApiResponse(r.currentTime.toDateTime, r.cachedUntil.toDateTime, r.result.rowset.row)}
}
