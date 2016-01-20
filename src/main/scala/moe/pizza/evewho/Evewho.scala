package moe.pizza.evewho

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import dispatch._

import scala.concurrent.ExecutionContext
import scala.util.{Success, Failure, Try}

object Evewho {
  case class CharacterInfo(
                   character_id: String,
                   corporation_id: String,
                   alliance_id: String,
                   faction_id: String,
                   name: String,
                   sec_status: String
                   )
  case class CharacterHistory(
                      corporation_id: String,
                      start_date: String,
                      end_date: String
                      )
  case class CharacterData(
                             info: CharacterInfo,
                             history: List[CharacterHistory]
                             )


  case class CorpInfo(
                   corporation_id: String,
                   name: String,
                   memberCount: String
                   )
  case class Character(
                         character_id: String,
                         corporation_id: String,
                         alliance_id: String,
                         name: String
                         )
  case class CorpData(
                             info: CorpInfo,
                             characters: List[Character]
                             )

  case class AllianceInfo(
                   alliance_id: String,
                   name: String,
                   memberCount: String
                   )
  case class AllianceData(
                             info: AllianceInfo,
                             characters: List[Character]
                             )

}
class Evewho(baseurl: String = "http://evewho.com/api.php", useragent: String = "unknown pizza-eveapi application") {

  val OM = new ObjectMapper()
  OM.registerModule(new DefaultScalaModule)

  implicit class EitherPimp[L <: Throwable, T](e: Either[L, T]) {
    def toTry: Try[T] = e.fold(Failure(_), Success(_))
  }

  // endpoints
  def characterInfo(id: Long)(implicit ec: ExecutionContext) = {
    val fullurl = baseurl + "?type=character&id=%d".format(id)
    val mysvc = url(fullurl).addHeader("User-Agent", this.useragent)
    val req = mysvc.GET

    // return as future either
    val response = Http(req OK as.String)
    response.either.map {
      case Right(r) => Right(OM.readValue(r, classOf[moe.pizza.evewho.Evewho.CharacterData]))
      case Left(t) => Left(t)
    }.map {
      _.toTry
    }
  }

  def corporationList(id: Long)(implicit ec: ExecutionContext) = {
    val fullurl = baseurl + "?type=corplist&id=%d".format(id)

    val mysvc = url(fullurl).addHeader("User-Agent", this.useragent)
    val req = mysvc.GET

    // return as future either
    val response = Http(req OK as.String)
    response.either.map {
      case Right(r) => Right(OM.readValue(r, classOf[moe.pizza.evewho.Evewho.CorpData]))
      case Left(t) => Left(t)
    }.map {
      _.toTry
    }
  }
  def allianceList(id: Long)(implicit ec: ExecutionContext) = {
    val fullurl = baseurl + "?type=allilist&id=%d".format(id)

    val mysvc = url(fullurl).addHeader("User-Agent", this.useragent)
    val req = mysvc.GET

    // return as future either
    val response = Http(req OK as.String)
    response.either.map {
      case Right(r) => Right(OM.readValue(r, classOf[moe.pizza.evewho.Evewho.AllianceData]))
      case Left(t) => Left(t)
    }.map {
      _.toTry
    }
  }

}
