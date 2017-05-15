package com.example

import org.scalatest.{ FunSpecLike, Matchers, BeforeAndAfterEach }
import akka.actor.ActorSystem
import akka.testkit.TestActorRef
import java.util.Calendar
import java.util.Date
import com.example._

class StockRepositorySpec extends FunSpecLike with Matchers with BeforeAndAfterEach {
  implicit val system = ActorSystem()

  describe("StockRepository") {
    describe("inserting a new stock") {
      it("should save a stock") {
        val actorRef = TestActorRef(new StockRepository())
        val cal = Calendar.getInstance
        cal.setTime(new Date)
        cal.add(Calendar.YEAR, -1)

        actorRef ! Stock("PETR3", cal.getTime, 15.1)

        val repo = actorRef.underlyingActor

        repo.map.get("PETR3").get.asInstanceOf[Stock].price shouldEqual( 15.1 )
        
        repo.map.remove("PETR3")
      }
    }
    
    describe("inserting a list of stocks") {
      it("should save/update all of items") {
        val actorRef = TestActorRef(new StockRepository())
        val cal = Calendar.getInstance
        cal.setTime(new Date)
        cal.add(Calendar.YEAR, -2)
        
        val stocks = List(Stock("GOOGLE", cal.getTime, 29.8), Stock("FB", cal.getTime, 89.8))
        
        stocks.foreach { s => actorRef ! s }
        
        val repo = actorRef.underlyingActor
        
        repo.map.size shouldEqual(2)
      }
    }
    
    
    
    
  }
}