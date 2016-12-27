package moe.pizza.zkapi

import com.fasterxml.jackson.databind.{DeserializationFeature, ObjectMapper}
import com.fasterxml.jackson.module.scala.DefaultScalaModule

import scala.annotation.tailrec
import scala.concurrent.ExecutionContext
import org.http4s._
import org.http4s.client.Client
import io.circe._
import io.circe.generic.auto._
import org.http4s.circe._

import scala.concurrent.duration._
import scalaz.concurrent.Task

/**
 * Created by andi on 12/11/15.
 */
class ZKBAPI(baseurl: String = "https://zkillboard.com/",
             useragent: String = "pizza-zkbapi, unknown application",
             redisqurl: String = "https://redisq.zkillboard.com/listen.php",
             strict: Boolean = true) {

  val OM = new ObjectMapper()
  OM.registerModule(new DefaultScalaModule)
  OM.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, strict)

  def query(implicit ec: ExecutionContext) = new ZKBRequest(Uri.unsafeFromString(this.baseurl+"api/"), this.useragent)

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

    def apply(f: Filters.Filters = Filters.typeID, s: String)(implicit c: Client): Task[List[AutocompleteResult]] = {
      val fullurl = s"${baseurl}autocomplete/${f.toString}/$s"
      val req = Request(uri = Uri.fromString(fullurl).toOption.get, method=Method.GET).putHeaders(Header("User-Agent", useragent))

      implicit val jdec = jsonOf[List[AutocompleteResult]]

      println(req)

      c.fetchAs[List[AutocompleteResult]](req)
    }
  }

  object redisq {
    def poll()(implicit c: Client): Task[RedisQTypes.RedisQResponse] = {
      val req = Request(uri = Uri.fromString(redisqurl).toOption.get, method=Method.GET).putHeaders(Header("User-Agent", useragent))

      implicit val jdec = jsonOf[RedisQTypes.RedisQResponse]

      c.fetchAs[RedisQTypes.RedisQResponse](req)
    }

    def stream()(implicit c: Client): Iterator[RedisQTypes.Package] = new Iterator[RedisQTypes.Package]{
      def hasNext = true
      @tailrec
      def next(): RedisQTypes.Package = {
        poll().runFor(11.seconds).payload match {
          case Some(p) => p
          case None => next()
        }
      }
    }
  }

  object stats {
    def alliance(id: Long)(implicit c: Client) = {
      val fullurl = baseurl + "api/stats/allianceID/%d/".format(id)

      val req = Request(uri = Uri.fromString(fullurl).toOption.get).putHeaders(Header("User-Agent", useragent))

      implicit val jdec = jsonOf[StatsTypes.AllianceInfo]

      c.fetchAs[StatsTypes.AllianceInfo](req)
    }
    def corporation(id: Long)(implicit c: Client) = {
      val fullurl = baseurl + "api/stats/corporationID/%d/".format(id)
      val req = Request(uri = Uri.fromString(fullurl).toOption.get).putHeaders(Header("User-Agent", useragent))

      implicit val jdec = jsonOf[StatsTypes.CorporationInfo]

      c.fetchAs[StatsTypes.CorporationInfo](req)
    }
    def character(id: Long)(implicit c: Client) = {
      val fullurl = baseurl + "api/stats/characterID/%d/".format(id)
      val req = Request(uri = Uri.fromString(fullurl).toOption.get).putHeaders(Header("User-Agent", useragent))

      implicit val jdec = jsonOf[StatsTypes.CharacterInfo]

      c.fetchAs[StatsTypes.CharacterInfo](req)
    }
  }

}
