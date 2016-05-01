package moe.pizza.eveapi

import dispatch.Defaults._
import dispatch._

import scala.util.{Failure, Success, Try}
import scala.xml.XML


class DualApiRequest[Y, X](base: String, endpoint: String, auth: Option[XmlApiKey] = None, args: Map[String, String] = Map())(implicit val parser: scalaxb.XMLFormat[X], val otherparser: scalaxb.XMLFormat[Y]) {

  implicit class EitherPimp[L <: Throwable,T](e:Either[L,T]){
    def toTry:Try[T] = e.fold(Failure(_), Success(_))
  }

  def apply(): Future[Either[X, Y]] = {
    val mysvc = url(base+endpoint).addHeader("User-Agent", "pizza-eveapi")
    var req = mysvc.GET
    // add API key
    req = auth match {
      case Some(xmlapikey) =>
        xmlapikey match {
          case a: ApiKey =>
            req.addQueryParameter("keyID", a.keyId.toString).addQueryParameter("vCode", a.vCode)
          case c: CrestApiKey =>
            req.addQueryParameter("accessToken", c.accessToken).addQueryParameter("accessType", c.accessType)
        }
      case None => req
    }
    // add arguments
    req = args.foldLeft(req)((r, kv) => r.addQueryParameter(kv._1, kv._2))
    // return as future
    val response = Http(req OK as.String)

    def parseX(s: String) = scalaxb.fromXML[X](XML.loadString(s))
    def parseY(s: String) = scalaxb.fromXML[Y](XML.loadString(s))

    response.map { r =>
      Try{parseY(r)}.toOption match {
        case Some(x) => Right(x)
        case None => Left(parseX(r))
      }
    }
  }
}
