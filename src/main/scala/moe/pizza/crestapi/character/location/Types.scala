package moe.pizza.crestapi.character.location

import moe.pizza.crestapi.CrestApi

import scala.concurrent.ExecutionContext

/**
  * Created by Andi on 18/02/2016.
  */
object Types {

  case class SolarSystem(
                          id_str: String,
                          href: String,
                          id: Long,
                          name: String
                        )

  case class Location(
                       solarSystem: Option[SolarSystem]
                     )


  implicit class PimpedSolarSystem(s: SolarSystem) {
    def get(c: CrestApi, t: String)(implicit ec: ExecutionContext) = c.solarsystem.get(s.id, t)
  }
}
