package moe.pizza.eveapi

import org.scalatest.{Matchers, FlatSpec}
import moe.pizza.eveapi.generated.{char, account}
import scala.io.Source
import scala.xml.XML


class EndpointsSpec extends FlatSpec with Matchers {

  class EndpointTester[T](data: String)(implicit val parser: scalaxb.XMLFormat[T]) {

    def apply() = {
      s"$data" should "parse correctly with the generated classes" in {
        val xml = Source.fromURL(getClass.getResource(data)).getLines().mkString("\n")
        scalaxb.fromXML[T](XML.loadString(xml))
      }
    }

  }

  // Account

  new EndpointTester[account.AccountStatus.Eveapi]("/raw/account/AccountStatus.xml").apply()
  new EndpointTester[account.APIKeyInfo.Eveapi]("/raw/account/APIKeyInfo.xml").apply()
  new EndpointTester[account.Characters.Eveapi]("/raw/account/Characters.xml").apply()

  // Characters

  new EndpointTester[char.AccountBalance.Eveapi]("/raw/char/AccountBalance.xml").apply()
  new EndpointTester[char.AssetList.Eveapi]("/raw/char/AssetList.xml").apply()
  new EndpointTester[char.Blueprints.Eveapi]("/raw/char/Blueprints.xml").apply()
  new EndpointTester[char.CharacterInfo.Eveapi]("/raw/char/CharacterInfo.xml").apply()
  new EndpointTester[char.ContactList.Eveapi]("/raw/char/ContactList.xml").apply()
  new EndpointTester[char.ContractItems.Eveapi]("/raw/char/ContractItems.xml").apply()
  new EndpointTester[char.Contracts.Eveapi]("/raw/char/Contracts.xml").apply()
  // new EndpointTester[char.KillMails.Eveapi]("/raw/char/KillMails.xml").apply() pending a better XML parser for KMs
  new EndpointTester[char.MailBodies.Eveapi]("/raw/char/MailBodies.xml").apply()
  new EndpointTester[char.MailMessages.Eveapi]("/raw/char/MailMessages.xml").apply()
  new EndpointTester[char.MarketOrder.Eveapi]("/raw/char/MarketOrder.xml").apply()
  new EndpointTester[char.Medals.Eveapi]("/raw/char/Medals.xml").apply()
  new EndpointTester[char.Notifications.Eveapi]("/raw/char/Notifications.xml").apply()
  new EndpointTester[char.NotificationTexts.Eveapi]("/raw/char/NotificationTexts.xml").apply()
  new EndpointTester[char.SkillInTraining.Eveapi]("/raw/char/SkillInTraining.xml").apply()
  new EndpointTester[char.SkillQueue.Eveapi]("/raw/char/SkillQueue.xml").apply()
  new EndpointTester[char.Standings.Eveapi]("/raw/char/Standings.xml").apply()
  new EndpointTester[char.UpcomingCalendarEvents.Eveapi]("/raw/char/UpcomingCalendarEvents.xml").apply()
  new EndpointTester[char.WalletJournal.Eveapi]("/raw/char/WalletJournal.xml").apply()
  new EndpointTester[char.WalletTransactions.Eveapi]("/raw/char/WalletTransactions.xml").apply()

}
