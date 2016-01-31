package moe.pizza.zkapi

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import dispatch._

import scala.annotation.tailrec
import scala.concurrent.ExecutionContext
import scala.util.{Success, Failure, Try}

import moe.pizza.eveapi.SyncableFuture
import scala.concurrent.duration._

/**
 * Created by andi on 12/11/15.
 */
class ZKBAPI(baseurl: String = "https://zkillboard.com/",
             useragent: String = "pizza-zkbapi, unknown application",
             redisqurl: String = "https://redisq.zkillboard.com/listen.php" ) {

  val OM = new ObjectMapper()
  OM.registerModule(new DefaultScalaModule)

  implicit class EitherPimp[L <: Throwable, T](e: Either[L, T]) {
    def toTry: Try[T] = e.fold(Failure(_), Success(_))
  }

  def query(implicit ec: ExecutionContext) = new ZKBRequest(this.baseurl, this.useragent)

  object autocomplete {

    object Filters extends Enumeration {
      type Filters = Value
      val regionID = Value("regionID")
      val solarSystemID = Value("solarSystemID")
      val allianceID = Value("allianceID")
      val corporationID = Value("corporationID")
      val characterID = Value("characterID")
      val typeID = Value("typeID")
    }

    case class AutocompleteResult(
                                   id: Long,
                                   name: String,
                                   `type`: String,
                                   image: String
                                   )

    def apply(f: Filters.Filters = Filters.typeID, s: String)(implicit ec: ExecutionContext): Future[List[AutocompleteResult]] = {
      val fullurl = s"${baseurl}autocomplete/${f.toString}/$s"
      val svc = url(fullurl).addHeader("User-Agent", useragent)
      val req = svc.GET

      Http(req OK as.String).map {
        OM.readValue(_, classOf[List[AutocompleteResult]])
      }
    }
  }

  object redisq {
    def poll()(implicit ec: ExecutionContext): Future[RedisQTypes.RedisQResponse] = {
      val svc = url(redisqurl).addHeader("User-Agent", useragent)
      val req = svc.GET

      val response = Http(req OK as.String)
      response.map{r =>
        OM.readValue(r, classOf[RedisQTypes.RedisQResponse])
      }
    }

    def stream()(implicit ec: ExecutionContext): Iterator[RedisQTypes.Package] = new Iterator[RedisQTypes.Package]{
      def hasNext = true
      @tailrec
      def next(): RedisQTypes.Package = {
        poll().sync(11.seconds).payload match {
          case Some(p) => p
          case None => next()
        }
      }
    }
  }

  object stats {
    def alliance(id: Long)(implicit ec: ExecutionContext) = {
      val fullurl = baseurl + "api/stats/allianceID/%d/".format(id)

      val mysvc = url(fullurl).addHeader("User-Agent", useragent)
      val req = mysvc.GET

      // return as future either
      val response = Http(req OK as.String)
      response.either.map {
        case Right(r) => Right(OM.readValue(r, classOf[StatsTypes.AllianceInfo]))
        case Left(t) => Left(t)
      }.map {
        _.toTry
      }
    }
    def corporation(id: Long)(implicit ec: ExecutionContext) = {
      val fullurl = baseurl + "api/stats/corporationID/%d/".format(id)

      val mysvc = url(fullurl).addHeader("User-Agent", useragent)
      val req = mysvc.GET

      // return as future either
      val response = Http(req OK as.String)
      response.either.map {
        case Right(r) => Right(OM.readValue(r, classOf[StatsTypes.CorporationInfo]))
        case Left(t) => Left(t)
      }.map {
        _.toTry
      }
    }
  }

}
