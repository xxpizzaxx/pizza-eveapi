package moe.pizza.eveapi.endpoints

import moe.pizza.eveapi.ApiRequest
import moe.pizza.eveapi.generated.eve


class Eve(baseurl: String) {
  def AllianceList(): Option[Seq[eve.AllianceList.Row]] = {
    new ApiRequest[eve.AllianceList.Eveapi](baseurl, "Eve/AllianceList.xml.aspx")(eve.AllianceList.AllianceListEveapiFormat).
      apply().
      map {
      _.result.rowset.row
    }
  }

  def CharacterAffiliation(ids: Seq[String]): Option[Seq[eve.CharacterAffiliation.Row]] = {
    new ApiRequest[eve.CharacterAffiliation.Eveapi](baseurl, "Eve/CharacterAffiliation.xml.aspx", None, Map("ids" -> ids.mkString(",")))(eve.CharacterAffiliation.CharacterAffiliationEveapiFormat).
      apply().
      map {
      _.result.rowset.row
    }
  }

  def CharacterID(ids: Seq[String]): Option[Seq[eve.CharacterID.Row]] = {
    new ApiRequest[eve.CharacterID.Eveapi](baseurl, "Eve/CharacterID.xml.aspx", None, Map("ids" -> ids.mkString(",")))(eve.CharacterID.CharacterIDEveapiFormat).
      apply().
      map {
      _.result.rowset.row
    }
  }

  def CharacterInfo(id: Long): Option[eve.CharacterInfo.Row] = {
    new ApiRequest[eve.CharacterInfo.Eveapi](baseurl, "Eve/CharacterInfo.xml.aspx")(eve.CharacterInfo.CharacterInfoEveapiFormat).
      apply().
      map {
      _.result.rowset.row.head
    }
  }

  def CharacterName(ids: Seq[Long]): Option[Seq[eve.CharacterName.Row]] = {
    new ApiRequest[eve.CharacterName.Eveapi](baseurl, "Eve/CharacterName.xml.aspx")(eve.CharacterName.CharacterNameEveapiFormat).
      apply().
      map {
      _.result.rowset.row
    }
  }

  def ConquerableStationList(): Option[Seq[eve.ConquerableStationList.Row]] = {
    new ApiRequest[eve.ConquerableStationList.Eveapi](baseurl, "Eve/ConquerableStationList.xml.aspx")(eve.ConquerableStationList.ConquerableStationListEveapiFormat).
      apply().
      map {
      _.result.rowset.row
    }
  }

  def ErrorList(): Option[Seq[eve.ErrorList.Row]] = {
    new ApiRequest[eve.ErrorList.Eveapi](baseurl, "Eve/ErrorList.xml.aspx")(eve.ErrorList.ErrorListEveapiFormat).
      apply().
      map {
      _.result.rowset.row
    }
  }

  def FacWarStats(): Option[eve.FacWarStats.Result] = {
    new ApiRequest[eve.FacWarStats.Eveapi](baseurl, "Eve/FacWarStats.xml.aspx")(eve.FacWarStats.FacWarStatsEveapiFormat).
      apply().
      map {
      _.result
    }
  }

  def FacWarTopStats(): Option[eve.FacWarTopStats.Result] = {
    new ApiRequest[eve.FacWarTopStats.Eveapi](baseurl, "Eve/FacWarTopStats.xml.aspx")(eve.FacWarTopStats.FacWarTopStatsEveapiFormat).
      apply().
      map {
      _.result
    }
  }

  def RefTypes(): Option[Seq[eve.RefTypes.Row]] = {
    new ApiRequest[eve.RefTypes.Eveapi](baseurl, "Eve/RefTypes.xml.aspx")(eve.RefTypes.RefTypesEveapiFormat).
      apply().
      map {
      _.result.rowset.row
    }
  }

  def TypeName(ids: Seq[Long]): Option[Seq[eve.TypeName.Row]] = {
    new ApiRequest[eve.TypeName.Eveapi](baseurl, "Eve/TypeName.xml.aspx")(eve.TypeName.TypeNameEveapiFormat).
      apply().
      map {
      _.result.rowset.row
    }
  }


}
