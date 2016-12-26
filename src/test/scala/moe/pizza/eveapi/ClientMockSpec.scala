package moe.pizza.eveapi

import com.github.tomakehurst.wiremock.WireMockServer
import com.github.tomakehurst.wiremock.client.WireMock
import com.github.tomakehurst.wiremock.client.WireMock._
import com.github.tomakehurst.wiremock.core.WireMockConfiguration._
import org.http4s.client.blaze.PooledHttp1Client
import org.scalatest.{BeforeAndAfterEach, FlatSpec, Matchers}

import scala.concurrent.ExecutionContext.Implicits.global
import scala.io.Source

class ClientMockSpec extends FlatSpec with Matchers with BeforeAndAfterEach {
  val port = 10123
  val hostname = "localhost"
  val wiremock = new WireMockServer(wireMockConfig().port(port))
  val c = PooledHttp1Client()


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
    val client = new EVEAPI(PooledHttp1Client(), "http://%s:%d/".format(hostname, port))
    stubFor(
      get(urlEqualTo("/Eve/AllianceList.xml.aspx"))
      .willReturn(
        aResponse()
          .withBody(getMockContents("/eve/AllianceList.xml"))
          .withStatus(200)
      )
    )
    val res = client.eve.AllianceList()
    val brave = res.run.result.find(_.allianceID.contains(99003214))
    assert(brave.nonEmpty)
  }


  def stubit(endpoint: String, e: Option[String] = None) = {
    stubFor(get(urlEqualTo("/"+e.getOrElse(endpoint.capitalize)+".aspx"))
      .willReturn(aResponse().withBody(getMockContents("/"+endpoint)).withStatus(200))
    )
  }

  // Maps
  "the API client" should "map.Kills()" in {
    val client = new EVEAPI(PooledHttp1Client(), "http://%s:%d/".format(hostname, port))
    stubit("map/Kills.xml")
    val res = client.map.Kills().run
  }
  "the API client" should "map.FacWarSystems()" in {
    val client = new EVEAPI(PooledHttp1Client(), "http://%s:%d/".format(hostname, port))
    stubit("map/FacWarSystems.xml")
    val res = client.map.FacWarSystems().run
  }
  "the API client" should "map.Jumps()" in {

    val client = new EVEAPI(PooledHttp1Client(), "http://%s:%d/".format(hostname, port))
    stubit("map/Jumps.xml")
    val res = client.map.Jumps().run
  }
  "the API client" should "map.Sovereignty()" in {
    val client = new EVEAPI(PooledHttp1Client(), "http://%s:%d/".format(hostname, port))
    stubit("map/Sovereignty.xml")
    val res = client.map.Sovereignty().run
  }

  // Server
  "the API client" should "server.ServerStatus()" in {
    val client = new EVEAPI(PooledHttp1Client(), "http://%s:%d/".format(hostname, port))
    stubit("server/ServerStatus.xml")
    val res = client.server.ServerStatus().run
  }

}
