package moe.pizza.eveapi.endpoints

import moe.pizza.eveapi.ApiRequest
import moe.pizza.eveapi.generated.map
import org.http4s.client.Client

import scalaz.concurrent.Task

class Map(baseurl: String)(implicit c: Client) {
  def Sovereignty(): Task[Seq[map.Sovereignty.Row]] = {
    new ApiRequest[map.Sovereignty.Eveapi](baseurl, "Map/Sovereignty.xml.aspx")(
      map.Sovereignty.SovereigntyEveapiFormat).apply().map(_.result.rowset.row)
  }
  def FacWarSystems(): Task[Seq[map.FacWarSystems.Row]] = {
    new ApiRequest[map.FacWarSystems.Eveapi](baseurl, "Map/FacWarSystems.xml.aspx")(
      map.FacWarSystems.FacWarSystemsEveapiFormat).apply().map(_.result.rowset.row)
  }
  def Kills(): Task[Seq[map.Kills.Row]] = {
    new ApiRequest[map.Kills.Eveapi](baseurl, "Map/Kills.xml.aspx")(map.Kills.KillsEveapiFormat)
      .apply()
      .map(_.result.rowset.row)
  }
  def Jumps(): Task[Seq[map.Jumps.Row]] = {
    new ApiRequest[map.Jumps.Eveapi](baseurl, "Map/Jumps.xml.aspx")(map.Jumps.JumpsEveapiFormat)
      .apply()
      .map(_.result.rowset.row)
  }
}
