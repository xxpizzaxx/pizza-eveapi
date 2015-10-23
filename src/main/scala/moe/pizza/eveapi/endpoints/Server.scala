package moe.pizza.eveapi.endpoints

import moe.pizza.eveapi.generated.server
import moe.pizza.eveapi.{ApiRequest, XMLApiResponse, XmlDate}

import scala.concurrent.ExecutionContext


class Server(baseurl: String)(implicit ec: ExecutionContext) {
  def ServerStatus() = new ApiRequest[server.ServerStatus.Eveapi](baseurl, "Server/ServerStatus.xml.aspx")(server.ServerStatus.ServerStatusEveapiFormat).apply().map(_.map(r => new XMLApiResponse(r.currentTime.toDateTime, r.cachedUntil.toDateTime, r.result)))
}
