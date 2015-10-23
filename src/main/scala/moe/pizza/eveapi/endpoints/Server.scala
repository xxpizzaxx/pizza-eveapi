package moe.pizza.eveapi.endpoints

import moe.pizza.eveapi.ApiRequest
import moe.pizza.eveapi.generated.server

import scala.concurrent.{ExecutionContext, Future}
import scala.util.Try


class Server(baseurl: String)(implicit ec: ExecutionContext) {
  def ServerStatus(): Future[Try[server.ServerStatus.Result]] = {
    new ApiRequest[server.ServerStatus.Eveapi](baseurl, "Server/ServerStatus.xml.aspx")(server.ServerStatus.ServerStatusEveapiFormat).apply().map(_.map(_.result))
  }
}
