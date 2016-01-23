package moe.pizza.zkapi

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import moe.pizza.zkapi.StatsTypes.SuperPilot
import org.scalatest.{MustMatchers, FlatSpec}

import scala.io.Source

/**
 * Created by Andi on 20/01/2016.
 */
class StatsSpec extends FlatSpec with MustMatchers {

  "alliance stats" should "be parsed" in {
    val json = Source.fromInputStream(getClass.getResourceAsStream("/alliancestats.json")).getLines().mkString("\n")
    val OM = new ObjectMapper()
    OM.registerModule(DefaultScalaModule)
    val r = OM.readValue[StatsTypes.AllianceInfo](json, classOf[StatsTypes.AllianceInfo])
    val superpilots = r.supers.supercarriers.data ++ r.supers.titans.data
    superpilots.size must equal(199)
    superpilots.head must equal(new SuperPilot(105,93260759,"Doctor Chalke"))
  }

  "alliance stats 2" should "be parsed" in {
    val json = Source.fromInputStream(getClass.getResourceAsStream("/alliancestats2.json")).getLines().mkString("\n")
    val OM = new ObjectMapper()
    OM.registerModule(DefaultScalaModule)
    val r = OM.readValue[StatsTypes.AllianceInfo](json, classOf[StatsTypes.AllianceInfo])
    val superpilots = r.supers.supercarriers.data ++ r.supers.titans.data
  }

}
