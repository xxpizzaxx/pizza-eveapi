package moe.pizza.evewho

import org.http4s.client.blaze.PooledHttp1Client

/**
  * Created by Andi on 20/01/2016.
  */
object EvewhoExample extends App {
  val evewho = new Evewho()

  implicit val client = PooledHttp1Client()

  val paistis = evewho.allianceList(1983809465).unsafePerformSync
  println(paistis)
  println(paistis.characters.size)

  client.shutdown.unsafePerformSync

}
