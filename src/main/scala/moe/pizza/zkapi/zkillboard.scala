package moe.pizza.zkapi

/**
  * Created by Andi on 04/11/2015.
  */
object zkillboard {

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

  case class Items(
      typeID: Long,
      flag: Long,
      qtyDropped: Long,
      qtyDestroyed: Long,
      singleton: Long
  )

  case class Zkb(
      hash: String,
      points: Long,
      totalValue: Double
  )

  case class Position(x: Double, y: Double, z: Double)

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
