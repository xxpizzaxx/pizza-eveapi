package moe.pizza.eveapi

import dispatch._, Defaults._
import scala.util.{Try, Failure, Success}
import scala.xml.{Elem, XML}


class ApiRequest[T](base: String, endpoint: String,  auth: Option[ApiKey] = None, args: Map[String, String] = Map())(implicit val parser: scalaxb.XMLFormat[T]) {

  def apply(): Future[T] = {
    val mysvc = url(base+endpoint).addHeader("User-Agent", "pizza-eveapi")
    var req = mysvc.GET
    // add API key
    req = auth match {
      case Some(a) => req.addQueryParameter("keyID", a.keyId.toString).addQueryParameter("vCode", a.vCode)
      case None => req
    }
    // add arguments
    req = args.foldLeft(req)((r, kv) => r.addQueryParameter(kv._1, kv._2))
    // return as future
    val response = Http(req OK as.String)
    response.map{ s => scalaxb.fromXML[T](XML.loadString(s)) }
  }
}
