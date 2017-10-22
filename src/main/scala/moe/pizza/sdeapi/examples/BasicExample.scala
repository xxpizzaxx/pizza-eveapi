package moe.pizza.sdeapi.examples

import slick.driver.MySQLDriver.api._
import slick.jdbc.JdbcBackend.Database
import moe.pizza.sdeapi._

/**
  * Created by Andi on 05/11/2015.
  */
object BasicExample extends App {
  val db  = Database.forURL("jdbc:mysql://localhost:3306/sde", "sde", "sde", driver = "com.mysql.jdbc.Driver")
  val res = Tables.Invtypes.filter(_.typename === "Rifter").result.run(db).sync()
  if (res.nonEmpty) {
    println(res.head.description)
  }

}
