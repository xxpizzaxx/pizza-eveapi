package moe.pizza.zkapi

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

/**
 * Created by Andi on 04/11/2015.
 */
object zkillboard {

  @JsonIgnoreProperties(ignoreUnknown = true)
  case class Victim(
                     shipTypeID: Long,
                     characterID: Long,
                     characterName: String,
                     corporationID: Long,
                     corporationName: String,
                     allianceID: Long,
                     allianceName: String,
                     factionID: Long,
                     factionName: String,
                     damageTaken: Long
                     )

  @JsonIgnoreProperties(ignoreUnknown = true)
  case class Attackers(
                        characterID: Long,
                        characterName: String,
                        corporationID: Long,
                        corporationName: String,
                        allianceID: Long,
                        allianceName: String,
                        factionID: Long,
                        factionName: String,
                        securityStatus: Double,
                        damageDone: Double,
                        finalBlow: Long,
                        weaponTypeID: Long,
                        shipTypeID: Long
                        )

  @JsonIgnoreProperties(ignoreUnknown = true)
  case class Items(
                    typeID: Long,
                    flag: Long,
                    qtyDropped: Long,
                    qtyDestroyed: Long,
                    singleton: Long
                    )

  case class Zkb(
                hash: String,
                points: Long
                )

  case class Position(x: Double, y: Double, z: Double)


  @JsonIgnoreProperties(ignoreUnknown = true)
  case class Killmail(
                             killID: Long,
                             solarSystemID: Long,
                             killTime: String,
                             moonID: Long,
                             victim: Victim,
                             position: Option[Position],
                             attackers: List[Attackers],
                             items: List[Items],
                             zkb: Zkb
                             )
}
