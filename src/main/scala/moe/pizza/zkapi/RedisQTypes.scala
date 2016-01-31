package moe.pizza.zkapi

import com.fasterxml.jackson.annotation.{JsonIgnoreProperties, JsonProperty}

/**
 * Created by Andi on 31/01/2016.
 */
object RedisQTypes {
  case class SolarSystem(
                          id_str: String,
                          href: String,
                          id: Long,
                          name: String
                          )
  case class Icon(
                   href: String
                   )
  case class Href(
                       id_str: String,
                       href: String,
                       id: Long,
                       name: String,
                       icon: Icon
                       )
  case class Attackers(
                        alliance: Option[Href],
                        shipType: Href,
                        corporation: Href,
                        character: Href,
                        damageDone_str: String,
                        weaponType: Href,
                        faction: Option[Href],
                        finalBlow: Boolean,
                        securityStatus: Double,
                        damageDone: Long
                        )
  case class Position(
                       y: Double,
                       x: Double,
                       z: Double
                       )

  case class Items(
                    singleton: Long,
                    itemType: Href,
                    quantityDestroyed_str: Option[String],
                    quantityDropped_str: Option[String],
                    flag: Long,
                    flag_str: String,
                    singleton_str: String,
                    quantityDestroyed: Option[Long],
                    quantityDropped: Option[Long]
                    )

  case class Victim(
                     alliance: Option[Href],
                     faction: Option[Href],
                     damageTaken: Long,
                     items: List[Items],
                     damageTaken_str: String,
                     character: Href,
                     shipType: Href,
                     corporation: Href,
                     position: Position
                     )
  case class War(
                  href: String,
                  id: Long,
                  id_str: String
                  )
  @JsonIgnoreProperties(ignoreUnknown = true)
  case class Killmail(
                       solarSystem: SolarSystem,
                       killID: Long,
                       killTime: String,
                       attackers: List[Attackers],
                       attackerCount: Long,
                       victim: Victim,
                       killID_str: String,
                       attackerCount_str: String,
                       war: War
                       )
  case class Zkb(
                  locationID: Long,
                  hash: String,
                  totalValue: Double,
                  points: Long,
                  href: String
                  )
  case class Package(
                      killID: Long,
                      killmail: Killmail,
                      zkb: Zkb
                      )
  case class RedisQResponse(
    @JsonProperty("package") payload: Option[Package]
  )

}
