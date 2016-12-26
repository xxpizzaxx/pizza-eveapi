package moe.pizza.eveapi

import dispatch.Defaults._
import dispatch._
import org.http4s.client.Client
import org.http4s._
import org.http4s.scalaxml._

import scala.util.{Failure, Success, Try}
import scala.xml.{Elem, XML}
import scalaz.concurrent.Task


class DualApiRequest[Y, X](base: String, endpoint: String, auth: Option[XmlApiKey] = None, args: Map[String, String] = Map())(implicit val parser: scalaxb.XMLFormat[X], val otherparser: scalaxb.XMLFormat[Y]) {

  implicit class EitherPimp[L <: Throwable,T](e:Either[L,T]){
    def toTry:Try[T] = e.fold(Failure(_), Success(_))
  }

  def apply()(implicit c: Client): Task[Either[X, Y]] = {
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

    def parseX(e: Elem) = scalaxb.fromXML[X](e)
    def parseY(e: Elem) = scalaxb.fromXML[Y](e)

    c.fetchAs[Elem](req).map { x =>
      Try{parseY(x)}.toOption match {
        case Some(x) => Right(x)
        case None => Left(parseX(x))
      }
    }
  }
}
