package moe.pizza.zkapi

/**
 * Created by Andi on 04/11/2015.
 */
object zkillboard {
  case class Victim(
                     x: Double,
                     y: Double,
                     z: Double,
                     shipTypeID: Double,
                     characterID: Double,
                     characterName: String,
                     corporationID: Double,
                     corporationName: String,
                     allianceID: Double,
                     allianceName: String,
                     factionID: Double,
                     factionName: String,
                     damageTaken: Double
                     )
  case class Attackers(
                        characterID: Double,
                        characterName: String,
                        corporationID: Double,
                        corporationName: String,
                        allianceID: Double,
                        allianceName: String,
                        factionID: Double,
                        factionName: String,
                        securityStatus: Double,
                        damageDone: Double,
                        finalBlow: Double,
                        weaponTypeID: Double,
                        shipTypeID: Double
                        )
  case class Items(
                    typeID: Double,
                    flag: Double,
                    qtyDropped: Double,
                    qtyDestroyed: Double,
                    singleton: Double
                    )
  case class Killmail(
                             killID: Double,
                             solarSystemID: Double,
                             killTime: String,
                             moonID: Double,
                             victim: Victim,
                             attackers: List[Attackers],
                             items: List[Items]
                             )
}
