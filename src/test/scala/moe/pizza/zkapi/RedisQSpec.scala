package moe.pizza.zkapi

import moe.pizza.zkapi.StatsTypes.SuperPilot
import org.scalatest.{FlatSpec, MustMatchers}

import scala.io.Source
import io.circe._, io.circe.generic.auto._, io.circe.syntax._, io.circe.parser._

class RedisQSpec extends FlatSpec with MustMatchers {

  "redisq responses" should "be parsed" in {
    val json = Source.fromInputStream(getClass.getResourceAsStream("/redisq.json")).getLines().mkString("\n")
    val r    = decode[RedisQTypes.RedisQResponse](json).right.get
    r.`package`.isDefined must equal(true)
    r.`package`.get.killID must equal(51738685)
  }

  "redisq responses 2" should "be parsed" in {
    val json = Source.fromInputStream(getClass.getResourceAsStream("/redisq2.json")).getLines().mkString("\n")
    val r1   = decode[RedisQTypes.RedisQResponse](json)
    println(r1)
    val r = r1.right.get
    r.`package`.isDefined must equal(true)
    r.`package`.get.killID must equal(51738559)
  }

  "redisq responses 3" should "be parsed" in {
    val json = Source.fromInputStream(getClass.getResourceAsStream("/redisq3.json")).getLines().mkString("\n")
    val r    = decode[RedisQTypes.RedisQResponse](json).right.get
    r.`package`.isDefined must equal(false)
  }

  "redisq responses 4, attacker with faction" should "be parsed" in {
    val json = Source
      .fromInputStream(getClass.getResourceAsStream("/redisq4_attackerwithfaction.json"))
      .getLines()
      .mkString("\n")
    val r1 = decode[RedisQTypes.RedisQResponse](json)
    println(r1)
    val r = r1.right.get
    r.`package`.isDefined must equal(true)
    val factionedattacker = r.`package`.get.killmail.attackers.find(_.faction.isDefined)
    factionedattacker.get.faction.get.name must equal("Blood Raider Covenant")
  }

  "redisq responses 5, victim with faction" should "be parsed" in {
    val json =
      Source.fromInputStream(getClass.getResourceAsStream("/redisq5_victimwithfaction.json")).getLines().mkString("\n")
    val r1 = decode[RedisQTypes.RedisQResponse](json)
    println(r1)
    val r = r1.right.get
    r.`package`.isDefined must equal(true)
    r.`package`.get.killmail.victim.faction.get.name must equal("Gallente Federation")
  }

}
