package moe.pizza.eveapi

import com.github.tomakehurst.wiremock.WireMockServer
import com.github.tomakehurst.wiremock.client.WireMock
import com.github.tomakehurst.wiremock.client.WireMock._
import com.github.tomakehurst.wiremock.core.WireMockConfiguration._
import org.scalatest.{FlatSpec, Matchers, BeforeAndAfterEach}

import scala.concurrent.ExecutionContext.Implicits.global

import scala.io.Source

class ClientMockSpec extends FlatSpec with Matchers with BeforeAndAfterEach {
  val port = 10123
  val hostname = "localhost"
  val wiremock = new WireMockServer(wireMockConfig().port(port))

  override def beforeEach() {
    wiremock.start()
    WireMock.configureFor(hostname, port)
  }

  override def afterEach() = {
    wiremock.stop()
  }

  def getMockContents(url: String): String = {
    Source.fromURL(getClass.getResource("/raw%s".format(url))).getLines().mkString("\n")
  }

  "the API client" should "be able to request public data" in {
    val client = new EVEAPI("http://%s:%d/".format(hostname, port))
    stubFor(get(urlEqualTo("/Eve/AllianceList.xml.aspx")).willReturn(aResponse().withBody(getMockContents("/eve/AllianceList.xml")).withStatus(200)))
    val res = client.eve.AllianceList()
    println(res.sync())
    val brave = res.sync().get.find(_.allianceID.contains(99003214))
    assert(brave.nonEmpty)
  }

}
