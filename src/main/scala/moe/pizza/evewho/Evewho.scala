package moe.pizza.evewho

import org.http4s._
import org.http4s.circe._
import io.circe._
import io.circe.generic.auto._
import io.circe.syntax._
import io.circe.parser._
import org.http4s.client.Client

import scalaz.concurrent.Task

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
      character_id: Long,
      corporation_id: Long,
      alliance_id: Long,
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
class Evewho(baseuri: Uri = Uri.uri("https://evewho.com/api.php"),
             useragent: String = "unknown pizza-eveapi application") {

  def characterInfo(id: Long)(implicit c: Client) = {
    val req =
      new Request(uri = baseuri.withQueryParam("type", "character").withQueryParam("id", id), method = Method.GET)
        .putHeaders(Header("User-Agent", useragent))
    implicit val dec = jsonOf[Evewho.CharacterData]
    c.fetchAs[Evewho.CharacterData](req)
  }

  def corporationList(id: Long, page: Int = 0)(implicit c: Client): Task[Evewho.CorpData] = {
    val req =
      new Request(uri =
                    baseuri.withQueryParam("type", "corplist").withQueryParam("id", id).withQueryParam("page", page),
                  method = Method.GET)
        .putHeaders(Header("User-Agent", useragent))
    implicit val dec = jsonOf[Evewho.CorpData]
    c.fetchAs[Evewho.CorpData](req) map { r =>
      if (r.characters.isEmpty) r
      else {
        val nextPage = corporationList(id, page + 1).unsafePerformSync
        r.copy(characters = r.characters ++ nextPage.characters)
      }
    }
  }

  def allianceList(id: Long, page: Int = 0)(implicit c: Client): Task[Evewho.AllianceData] = {
    val req =
      new Request(uri =
                    baseuri.withQueryParam("type", "allilist").withQueryParam("id", id).withQueryParam("page", page),
                  method = Method.GET)
        .putHeaders(Header("User-Agent", useragent))
    implicit val dec = jsonOf[Evewho.AllianceData]
    c.fetchAs[Evewho.AllianceData](req) map { r =>
      if (r.characters.isEmpty) r
      else {
        val nextPage = allianceList(id, page + 1).unsafePerformSync
        r.copy(characters = r.characters ++ nextPage.characters)
      }
    }
  }

}
