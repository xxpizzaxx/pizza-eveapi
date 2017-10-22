package moe.pizza.eveapi

import dispatch._
import Defaults._

import scala.util.{Failure, Success, Try}
import scala.xml.{Elem, XML}
import scalaz.concurrent.Task
import org.http4s.Uri
import org.http4s._
import org.http4s.MediaType._
import org.http4s.client.Client
import org.http4s.headers.`Content-Type`
import org.http4s.scalaxml._

class ApiRequest[T](base: String, endpoint: String, auth: Option[XmlApiKey] = None, args: Map[String, String] = Map())(
    implicit val parser: scalaxb.XMLFormat[T]) {

  def apply()(implicit c: Client): Task[T] = {
    val uri = auth.foldLeft(Uri.fromString(base + endpoint).toOption.get) { (u, k) =>
      k match {
        case a: ApiKey =>
          u.withQueryParam("keyID", a.keyId.toString)
            .withQueryParam("vCode", a.vCode)
        case c: CrestApiKey =>
          u.withQueryParam("accessToken", c.accessToken)
            .withQueryParam("accessType", c.accessType)
      }
    }
    val uriWithArgs = args.foldLeft(uri)((u, kv) => u.withQueryParam(kv._1, kv._2))
    val req = new Request(
      uri = uriWithArgs,
      method = Method.GET
    ).putHeaders(
      Header("User-Agent", "pizza-eveapi")
    )
    c.fetchAs[Elem](req).map { x =>
      scalaxb.fromXML[T](x)
    }
  }
}
