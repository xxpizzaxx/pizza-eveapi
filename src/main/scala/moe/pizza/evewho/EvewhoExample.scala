package moe.pizza.evewho

import moe.pizza.eveapi.SyncableFuture

import scala.util.{Success, Failure}

import scala.concurrent.ExecutionContext.Implicits.global

/**
 * Created by Andi on 20/01/2016.
 */
object EvewhoExample extends App {
  val evewho = new Evewho()

  val paistis = evewho.allianceList(1983809465).sync()
  println(paistis)
  println(paistis.characters.size)

}
