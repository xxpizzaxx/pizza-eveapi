package moe.pizza.crestapi

import org.scalatest.{FlatSpec, MustMatchers}

import scala.io.Source
import io.circe._, io.circe.generic.auto._, io.circe.syntax._, io.circe.parser._

/**
  * Created by Andi on 21/01/2016.
  */
class ContactSpec extends FlatSpec with MustMatchers {
  "contacts" should "get parsed" in {
    val json = Source.fromInputStream(getClass.getResourceAsStream("/contacts.json")).getLines().mkString("\n")
    val r    = decode[contacts.Types.ContactList](json)
    println(r)
    r.isRight must equal(true)
  }

}
