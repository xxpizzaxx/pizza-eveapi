package moe.pizza.zkapi

import java.net.URI

import moe.pizza.zkapi.zkillboard.Killmail
import org.eclipse.jetty.websocket.api.{Session, WebSocketAdapter, WebSocketListener}
import org.eclipse.jetty.websocket.client.WebSocketClient
import org.slf4j.{Logger, LoggerFactory}
import io.circe._, io.circe.generic.auto._, io.circe.parser._, io.circe.syntax._

import scala.concurrent.duration._

/**
  * Created by Andi on 04/11/2015.
  */
object WebsocketFeed {
  def main(args: Array[String]) {
    val logger = LoggerFactory.getLogger("main")
    val ws = createClient("ws://ws.eve-kill.net/kills", { s: Killmail =>
      logger.info(s.toString)
    })
    ws.start()
    Thread.sleep(10.seconds.toMillis)
  }

  def createClient(url: String, onrecv: (Killmail => Unit)): WebSocketClient = {

    val logger = LoggerFactory.getLogger("websockets")

    class EKWSClientSocket(callback: (Killmail => Unit)) extends WebSocketAdapter {

      override def onWebSocketText(message: String): Unit = {
        if (message.startsWith("{")) {
          val kill = decode[zkillboard.Killmail](message)
          kill.fold({ x =>
            logger.error(x.toString)
          }, callback)
        }
      }
    }

    val ws = new WebSocketClient()
    ws.start()
    ws.connect(new EKWSClientSocket(onrecv), URI.create(url))
    ws
  }

}
