package moe.pizza.zkapi

import moe.pizza.zkapi.zkillboard.Killmail
import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormatterBuilder

import scala.collection.JavaConverters._
import scalaz.concurrent.Task
import org.http4s._
import org.http4s.client.Client
import org.http4s.Uri
import org.http4s.circe._
import io.circe._
import io.circe.generic.auto._
import org.http4s.Uri.Path

case class ZKBRequest(
    baseurl: Uri = Uri.uri("https://zkillboard.com/api"),
    useragent: String = "pizza-zkbapi, unknown application",
    sort: String = "desc",
    modifiers: Map[String, Long] = Map(),
    page: Int = 1,
    typemodifier: Option[String] = None,
    _start: Option[DateTime] = None,
    _end: Option[DateTime] = None
) {

  val zkbdateformatter = new DateTimeFormatterBuilder()
    .appendYear(4, 4)
    .appendMonthOfYear(2)
    .appendDayOfMonth(2)
    .appendHourOfDay(2)
    .appendMinuteOfHour(2)
    .toFormatter

  def sortAsc()               = this.copy(sort = "asc")
  def sortDesc()              = this.copy(sort = "desc")
  def page(i: Int)            = this.copy(page = i)
  def userAgent(s: String)    = this.copy(useragent = "pizza-zkbapi, %s".format(s))
  def start(s: DateTime)      = this.copy(_start = Some(s))
  def end(e: DateTime)        = this.copy(_end = Some(e))
  def kills()                 = this.copy(typemodifier = Some("kills"))
  def losses()                = this.copy(typemodifier = Some("losses"))
  def wspace()                = this.copy(typemodifier = Some("w-space"))
  def solo()                  = this.copy(typemodifier = Some("solo"))
  def characterID(id: Long)   = this.copy(modifiers = this.modifiers ++ Map("characterID" -> id))
  def corporationID(id: Long) = this.copy(modifiers = this.modifiers ++ Map("corporationID" -> id))
  def allianceID(id: Long)    = this.copy(modifiers = this.modifiers ++ Map("allianceID" -> id))
  def factionID(id: Long)     = this.copy(modifiers = this.modifiers ++ Map("factionID" -> id))
  def shipTypeID(id: Long)    = this.copy(modifiers = this.modifiers ++ Map("shipTypeID" -> id))
  def groupID(id: Long)       = this.copy(modifiers = this.modifiers ++ Map("groupID" -> id))
  def solarSystemID(id: Long) = this.copy(modifiers = this.modifiers ++ Map("solarSystemID" -> id))
  def regionID(id: Long)      = this.copy(modifiers = this.modifiers ++ Map("regionID" -> id))
  def warID(id: Long)         = this.copy(modifiers = this.modifiers ++ Map("warID" -> id))

  implicit class SlashOptionAbleUri(u: Uri) {
    def /?(p: Option[Path]) = p.foldLeft(u)((p, u) => p / u)
    def /()                 = u.copy(path = u.path + "/")
  }

  def build()(implicit c: Client): Task[List[Killmail]] = {
    val start = this._start map (zkbdateformatter.print) map ("startTime/" + _)
    val end   = this._end map (zkbdateformatter.print) map ("endTime/" + _)
    val uri = modifiers.foldLeft(baseurl /? typemodifier) { (u, kv) =>
      u / kv._1 / kv._2.toString
    } / "orderDirection" / this.sort / "page" / page.toString
    val uriWithStart = start.foldLeft(uri){(u, s) => u.copy(path = u.path + "/"+s)}
    val uriWithTimes = end.foldLeft(uriWithStart){(u, e) => u.copy(path = u.path + "/"+e)}

    val req = Request(uri = uriWithTimes /(), method = Method.GET).putHeaders(Header("User-Agent", this.useragent))

    implicit val jdec = jsonOf[List[zkillboard.Killmail]]
    c.fetchAs[List[zkillboard.Killmail]](req)
  }
}
