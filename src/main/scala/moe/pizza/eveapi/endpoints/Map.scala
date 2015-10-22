package moe.pizza.eveapi.endpoints

import moe.pizza.eveapi.ApiRequest
import moe.pizza.eveapi.generated.map

import scala.concurrent.{ExecutionContext, Future}
import scala.util.Try


class Map(baseurl: String)(implicit ec: ExecutionContext) {
  def Sovereignty(): Future[Try[Seq[map.Sovereignty.Row]]] = {
    new ApiRequest[map.Sovereignty.Eveapi](baseurl, "Map/Sovereignty.xml.aspx")(map.Sovereignty.SovereigntyEveapiFormat).apply().map(_.map(_.result.rowset.row))
  }
  def FacWarSystems(): Future[Try[Seq[map.FacWarSystems.Row]]] = {
    new ApiRequest[map.FacWarSystems.Eveapi](baseurl, "Map/FacWarSystems.xml.aspx")(map.FacWarSystems.FacWarSystemsEveapiFormat).apply().map(_.map(_.result.rowset.row))
  }
  def Kills(): Future[Try[Seq[map.Kills.Row]]] = {
    new ApiRequest[map.Kills.Eveapi](baseurl, "Map/Kills.xml.aspx")(map.Kills.KillsEveapiFormat).apply().map(_.map(_.result.rowset.row))
  }
  def Jumps(): Future[Try[Seq[map.Jumps.Row]]] = {
    new ApiRequest[map.Jumps.Eveapi](baseurl, "Map/Jumps.xml.aspx")(map.Jumps.JumpsEveapiFormat).apply().map(_.map(_.result.rowset.row))
  }
}
