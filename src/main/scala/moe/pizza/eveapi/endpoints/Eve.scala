package moe.pizza.eveapi.endpoints

import moe.pizza.eveapi.ApiRequest
import moe.pizza.eveapi.generated.eve

import scala.concurrent.{ExecutionContext, Future}
import scala.util.Try



class Eve(baseurl: String)(implicit ec: ExecutionContext) {
  def AllianceList(): Future[Try[Seq[eve.AllianceList.Row]]] = {
    new ApiRequest[eve.AllianceList.Eveapi](baseurl, "Eve/AllianceList.xml.aspx")(eve.AllianceList.AllianceListEveapiFormat).apply().map{_.map{_.result.rowset.row}}
  }
  def CharacterAffiliation(ids: Seq[String]): Future[Try[Seq[eve.CharacterAffiliation.Row]]] = {
    new ApiRequest[eve.CharacterAffiliation.Eveapi](baseurl, "Eve/CharacterAffiliation.xml.aspx", None, Map("ids" -> ids.mkString(",")))(eve.CharacterAffiliation.CharacterAffiliationEveapiFormat).
      apply().map {_.map{_.result.rowset.row}}
  }
  def CharacterID(ids: Seq[String]): Future[Try[Seq[eve.CharacterID.Row]]] = {
    new ApiRequest[eve.CharacterID.Eveapi](baseurl, "Eve/CharacterID.xml.aspx", None, Map("names" -> ids.mkString(",")))(eve.CharacterID.CharacterIDEveapiFormat).apply().map{_.map{_.result.rowset.row}}
  }
  def CharacterInfo(id: Long): Future[Try[eve.CharacterInfo.Row]] = {
    new ApiRequest[eve.CharacterInfo.Eveapi](baseurl, "Eve/CharacterInfo.xml.aspx", None, Map("characterID" -> id.toString))(eve.CharacterInfo.CharacterInfoEveapiFormat).
      apply().map{_.map{_.result.rowset.row.head}}
  }

  def CharacterName(ids: Seq[Long]): Future[Try[Seq[eve.CharacterName.Row]]] = {
    new ApiRequest[eve.CharacterName.Eveapi](baseurl, "Eve/CharacterName.xml.aspx")(eve.CharacterName.CharacterNameEveapiFormat).
      apply().map{_.map{_.result.rowset.row}}
  }

  def ConquerableStationList(): Future[Try[Seq[eve.ConquerableStationList.Row]]] = {
    new ApiRequest[eve.ConquerableStationList.Eveapi](baseurl, "Eve/ConquerableStationList.xml.aspx")(eve.ConquerableStationList.ConquerableStationListEveapiFormat).
      apply().map{_.map{_.result.rowset.row}}
  }

  def ErrorList(): Future[Try[Seq[eve.ErrorList.Row]]] = {
    new ApiRequest[eve.ErrorList.Eveapi](baseurl, "Eve/ErrorList.xml.aspx")(eve.ErrorList.ErrorListEveapiFormat).
      apply().map{_.map{_.result.rowset.row}}
  }

  def FacWarStats(): Future[Try[eve.FacWarStats.Result]] = {
    new ApiRequest[eve.FacWarStats.Eveapi](baseurl, "Eve/FacWarStats.xml.aspx")(eve.FacWarStats.FacWarStatsEveapiFormat).
      apply().map{_.map{_.result}}
  }

  def FacWarTopStats(): Future[Try[eve.FacWarTopStats.Result]] = {
    new ApiRequest[eve.FacWarTopStats.Eveapi](baseurl, "Eve/FacWarTopStats.xml.aspx")(eve.FacWarTopStats.FacWarTopStatsEveapiFormat).
      apply().map{_.map{_.result}}
  }

  def RefTypes(): Future[Try[Seq[eve.RefTypes.Row]]] = {
    new ApiRequest[eve.RefTypes.Eveapi](baseurl, "Eve/RefTypes.xml.aspx")(eve.RefTypes.RefTypesEveapiFormat).
      apply().map{_.map{_.result.rowset.row}}
  }

  def TypeName(ids: Seq[Long]): Future[Try[Seq[eve.TypeName.Row]]] = {
    new ApiRequest[eve.TypeName.Eveapi](baseurl, "Eve/TypeName.xml.aspx")(eve.TypeName.TypeNameEveapiFormat).
      apply().map{_.map{_.result.rowset.row}}
  }
}
