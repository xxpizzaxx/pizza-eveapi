package moe.pizza.zkapi

import java.net.URI

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import moe.pizza.zkapi.zkillboard.Killmail
import org.eclipse.jetty.util.ssl.SslContextFactory
import org.eclipse.jetty.websocket.api.{WebSocketListener, Session, WebSocketAdapter}
import org.eclipse.jetty.websocket.client.WebSocketClient
import org.slf4j.{LoggerFactory, Logger}

import scala.concurrent.duration._

/**
 * Created by Andi on 04/11/2015.
 */

object WebsocketFeed {
  def main (args: Array[String]) {
    val logger = LoggerFactory.getLogger("main")
    val ws = createClient("ws://ws.eve-kill.net/kills", {s: Killmail => logger.info(s.toString)})
    ws.start()
    Thread.sleep(10.seconds.toMillis)
  }


  def createClient(url: String, onrecv: (Killmail => Unit)): WebSocketClient = {

    val OM = new ObjectMapper()
    OM.registerModule(DefaultScalaModule)

    val logger = LoggerFactory.getLogger("websockets")

    class EKWSClientSocket(callback: (Killmail => Unit)) extends WebSocketAdapter {

      override def onWebSocketText(message: String): Unit = {
        if (message.startsWith("{")) {
          val kill = OM.readValue(message, classOf[zkillboard.Killmail])
          logger.info(kill.toString)
          callback(kill)
        }
      }
    }

    val ws = new WebSocketClient()
    ws.start()
    ws.connect(new EKWSClientSocket(onrecv), URI.create(url))
    ws
  }

}