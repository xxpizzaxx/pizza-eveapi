package moe.pizza.eveapi.endpoints

import moe.pizza.eveapi.generated.eve
import moe.pizza.eveapi.{ApiRequest, XMLApiResponse, XmlDate}

import scala.concurrent.ExecutionContext


class Eve(baseurl: String)(implicit ec: ExecutionContext) {
  def AllianceList() = new ApiRequest[eve.AllianceList.Eveapi](baseurl, "Eve/AllianceList.xml.aspx")(eve.AllianceList.AllianceListEveapiFormat).apply().map{_.map{r => new XMLApiResponse(r.currentTime.toDateTime, r.cachedUntil.toDateTime, r.result.rowset.row)}}
  def CharacterAffiliation(ids: Seq[String]) = new ApiRequest[eve.CharacterAffiliation.Eveapi](baseurl, "Eve/CharacterAffiliation.xml.aspx", None, Map("ids" -> ids.mkString(",")))(eve.CharacterAffiliation.CharacterAffiliationEveapiFormat).apply().map {_.map{r => new XMLApiResponse(r.currentTime.toDateTime, r.cachedUntil.toDateTime, r.result.rowset.row)}}
  def CharacterID(ids: Seq[String]) = new ApiRequest[eve.CharacterID.Eveapi](baseurl, "Eve/CharacterID.xml.aspx", None, Map("names" -> ids.mkString(",")))(eve.CharacterID.CharacterIDEveapiFormat).apply().map{_.map{r => new XMLApiResponse(r.currentTime.toDateTime, r.cachedUntil.toDateTime, r.result.rowset.row)}}
  def CharacterInfo(id: Long) = new ApiRequest[eve.CharacterInfo.Eveapi](baseurl, "Eve/CharacterInfo.xml.aspx", None, Map("characterID" -> id.toString))(eve.CharacterInfo.CharacterInfoEveapiFormat).apply().map{_.map{r => new XMLApiResponse(r.currentTime.toDateTime, r.cachedUntil.toDateTime, r.result)}}
  def CharacterName(ids: Seq[Long]) = new ApiRequest[eve.CharacterName.Eveapi](baseurl, "Eve/CharacterName.xml.aspx", None, Map{"ids" -> ids.mkString(",")})(eve.CharacterName.CharacterNameEveapiFormat).apply().map{_.map{r => new XMLApiResponse(r.currentTime.toDateTime, r.cachedUntil.toDateTime, r.result.rowset.row)}}
  def ConquerableStationList() = new ApiRequest[eve.ConquerableStationList.Eveapi](baseurl, "Eve/ConquerableStationList.xml.aspx")(eve.ConquerableStationList.ConquerableStationListEveapiFormat).apply().map{_.map{r => new XMLApiResponse(r.currentTime.toDateTime, r.cachedUntil.toDateTime, r.result.rowset.row)}}
  def ErrorList() = new ApiRequest[eve.ErrorList.Eveapi](baseurl, "Eve/ErrorList.xml.aspx")(eve.ErrorList.ErrorListEveapiFormat).apply().map{_.map{r => new XMLApiResponse(r.currentTime.toDateTime, r.cachedUntil.toDateTime, r.result.rowset.row)}}
  def FacWarStats() = new ApiRequest[eve.FacWarStats.Eveapi](baseurl, "Eve/FacWarStats.xml.aspx")(eve.FacWarStats.FacWarStatsEveapiFormat).apply().map{_.map{r => new XMLApiResponse(r.currentTime.toDateTime, r.cachedUntil.toDateTime, r.result)}}
  def FacWarTopStats() = new ApiRequest[eve.FacWarTopStats.Eveapi](baseurl, "Eve/FacWarTopStats.xml.aspx")(eve.FacWarTopStats.FacWarTopStatsEveapiFormat).apply().map{_.map{r => new XMLApiResponse(r.currentTime.toDateTime, r.cachedUntil.toDateTime, r.result)}}
  def RefTypes() = new ApiRequest[eve.RefTypes.Eveapi](baseurl, "Eve/RefTypes.xml.aspx")(eve.RefTypes.RefTypesEveapiFormat).apply().map{_.map{r => new XMLApiResponse(r.currentTime.toDateTime, r.cachedUntil.toDateTime, r.result.rowset.row)}}
  def TypeName(ids: Seq[Long]) = new ApiRequest[eve.TypeName.Eveapi](baseurl, "Eve/TypeName.xml.aspx")(eve.TypeName.TypeNameEveapiFormat).apply().map{_.map{r => new XMLApiResponse(r.currentTime.toDateTime, r.cachedUntil.toDateTime, r.result.rowset.row)}}
}
