package com.example

import akka.actor.Actor
import akka.actor.ActorSystem
import scala.collection.mutable.HashMap
import akka.event.Logging
import java.util.Date

class StockRepository extends Actor {
 
  val map = new HashMap[String, Object]
  val log = Logging(context.system, this)

  override def receive() = {
    case Stock(ticker, dateClosing, price) => {
      log.info("Request received stock => ticker: {}, date closing: {}, price: {}", ticker, dateClosing, price)
      map.put(ticker, Stock(ticker, dateClosing, price))
    }

    case o => log.info("Received uknow message: {}, o")
  }
}