package com.garba.viajes.aponzini.scattergatter

import akka.actor.{ActorSystem, Props}
import akka.testkit.{ImplicitSender, TestKit}
import org.scalatest.{BeforeAndAfterAll, Matchers, WordSpecLike}

import scala.concurrent.duration._

class ScatterGatterServiceTest() extends TestKit(ActorSystem("ScatterGatherTest")) with ImplicitSender
  with WordSpecLike with Matchers with BeforeAndAfterAll {

  override def afterAll {
    TestKit.shutdownActorSystem(system)
  }

  "ScatterGatterService" must {

    "return an AggregationResult class" in {
      val sgService = system.actorOf(Props( new ScatterGatterService(self)))
      sgService.tell(ScatterGatterRequest, self) //implicit sender
      expectMsgClass(6 seconds , classOf[AggregationResult])
    }
  }
}