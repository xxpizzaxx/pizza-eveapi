package moe.pizza.eveapi.endpoints

import moe.pizza.eveapi.generated.corp
import moe.pizza.eveapi._
import org.http4s.client.Client

class Corp(baseurl: String, apikey: Option[XmlApiKey])(implicit c: Client) {
  def AccountBalance() =
    new ApiRequest[corp.AccountBalance.Eveapi](baseurl, "corp/AccountBalance.xml.aspx", apikey).apply().map { r =>
      new XMLApiResponse(r.currentTime.toDateTime, r.cachedUntil.toDateTime, r.result.rowset.row)
    }
  def ContactList() =
    new ApiRequest[corp.ContactList.Eveapi](baseurl, "corp/ContactList.xml.aspx", apikey).apply().map { r =>
      new XMLApiResponse(r.currentTime.toDateTime, r.cachedUntil.toDateTime, r.result.rowset)
    }
  def Standings() = new ApiRequest[corp.Standings.Eveapi](baseurl, "corp/Standings.xml.aspx", apikey).apply().map {
    r =>
      new XMLApiResponse(r.currentTime.toDateTime, r.cachedUntil.toDateTime, r.result.corporationNPCStandings.rowset)
  }
}
