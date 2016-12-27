package moe.pizza.eveapi.endpoints

import moe.pizza.eveapi.generated.server
import moe.pizza.eveapi.{ApiRequest, XMLApiResponse, XmlDate}
import org.http4s.client.Client

class Server(baseurl: String)(implicit c: Client) {
  def ServerStatus() = new ApiRequest[server.ServerStatus.Eveapi](baseurl, "Server/ServerStatus.xml.aspx")(server.ServerStatus.ServerStatusEveapiFormat).apply().map(r => new XMLApiResponse(r.currentTime.toDateTime, r.cachedUntil.toDateTime, r.result))
}
