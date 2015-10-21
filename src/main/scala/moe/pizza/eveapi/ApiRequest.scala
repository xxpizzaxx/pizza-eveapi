package moe.pizza.eveapi

import dispatch._, Defaults._
import scala.util.{Try, Failure, Success}
import scala.xml.{Elem, XML}


class ApiRequest[T](base: String, endpoint: String,  auth: Option[ApiKey] = None, args: Map[String, String] = Map())(implicit val parser: scalaxb.XMLFormat[T]) {

  implicit class EitherPimp[L <: Throwable,T](e:Either[L,T]){
    def toTry:Try[T] = e.fold(Failure(_), Success(_))
  }

  def apply(): Future[Try[T]] = {
    val mysvc = url(base+endpoint).addHeader("User-Agent", "pizza-eveapi")
    var req = mysvc.GET
    // add API key
    req = auth match {
      case Some(a) => req.addQueryParameter("keyID", a.keyId.toString).addQueryParameter("vCode", a.vCode)
      case None => req
    }
    // add arguments
    req = args.foldLeft(req)((r, kv) => r.addQueryParameter(kv._1, kv._2))
    // return as future either
    val response = Http(req OK as.String)
    response.either.map {
      case Right(r) => Right(scalaxb.fromXML[T](XML.loadString(r)))
      case Left(t) => Left(t)
    }.map{_.toTry}
  }
}
