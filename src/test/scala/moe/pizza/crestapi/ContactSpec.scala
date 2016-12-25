package moe.pizza.crestapi

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import org.scalatest.{MustMatchers, FlatSpec}

import scala.io.Source

/**
 * Created by Andi on 21/01/2016.
 */
class ContactSpec extends FlatSpec with MustMatchers {
  "contacts" should "get parsed" in {
    val json = Source.fromInputStream(getClass.getResourceAsStream("/contacts.json")).getLines().mkString("\n")
    val OM = new ObjectMapper()
    OM.registerModule(DefaultScalaModule)
    val r = OM.readValue(json, classOf[contacts.Types.ContactList])

  }

}
