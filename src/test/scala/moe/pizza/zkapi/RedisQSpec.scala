package moe.pizza.zkapi

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import moe.pizza.zkapi.StatsTypes.SuperPilot
import org.scalatest.{FlatSpec, MustMatchers}

import scala.io.Source

class RedisQSpec extends FlatSpec with MustMatchers {

  /*
  "redisq responses" should "be parsed" in {
    val json = Source.fromInputStream(getClass.getResourceAsStream("/redisq.json")).getLines().mkString("\n")
    val OM = new ObjectMapper()
    OM.registerModule(DefaultScalaModule)
    val r = OM.readValue[RedisQTypes.RedisQResponse](json, classOf[RedisQTypes.RedisQResponse])
    r.payload.isDefined must equal(true)
    r.payload.get.killID must equal(51738685)
  }

  "redisq responses 2" should "be parsed" in {
    val json = Source.fromInputStream(getClass.getResourceAsStream("/redisq2.json")).getLines().mkString("\n")
    val OM = new ObjectMapper()
    OM.registerModule(DefaultScalaModule)
    val r = OM.readValue[RedisQTypes.RedisQResponse](json, classOf[RedisQTypes.RedisQResponse])
    r.payload.isDefined must equal(true)
    r.payload.get.killID must equal(51738559)
  }

  "redisq responses 3" should "be parsed" in {
    val json = Source.fromInputStream(getClass.getResourceAsStream("/redisq3.json")).getLines().mkString("\n")
    val OM = new ObjectMapper()
    OM.registerModule(DefaultScalaModule)
    val r = OM.readValue[RedisQTypes.RedisQResponse](json, classOf[RedisQTypes.RedisQResponse])
    r.payload.isDefined must equal(false)
  }

  "redisq responses 4, attacker with faction" should "be parsed" in {
    val json = Source.fromInputStream(getClass.getResourceAsStream("/redisq4_attackerwithfaction.json")).getLines().mkString("\n")
    val OM = new ObjectMapper()
    OM.registerModule(DefaultScalaModule)
    val r = OM.readValue[RedisQTypes.RedisQResponse](json, classOf[RedisQTypes.RedisQResponse])
    r.payload.isDefined must equal(true)
    val factionedattacker = r.payload.get.killmail.attackers.find(_.faction.isDefined)
    factionedattacker.get.faction.get.name must equal("Blood Raider Covenant")
  }

  "redisq responses 5, victim with faction" should "be parsed" in {
    val json = Source.fromInputStream(getClass.getResourceAsStream("/redisq5_victimwithfaction.json")).getLines().mkString("\n")
    val OM = new ObjectMapper()
    OM.registerModule(DefaultScalaModule)
    val r = OM.readValue[RedisQTypes.RedisQResponse](json, classOf[RedisQTypes.RedisQResponse])
    r.payload.isDefined must equal(true)
    r.payload.get.killmail.victim.faction.get.name must equal("Gallente Federation")
  }
  */



}
