package moe.pizza.zkapi

import org.scalatest.{FlatSpec, MustMatchers}

import scala.io.Source
import io.circe._
import io.circe.generic.auto._
import io.circe.syntax._
import io.circe.parser._
import moe.pizza.zkapi.zkillboard.Killmail

/**
  * Created by andi on 27/12/2016.
  */
class KillSpec extends FlatSpec with MustMatchers {

  "the circe parser" should "parse things from the API" in {
    val json = Source.fromInputStream(getClass.getResourceAsStream("/normalkills.json")).getLines()
    val res = json.map { line =>
      decode[Killmail](line)
    }.toList
    res.count(_.isRight) must equal(200)
  }

}
