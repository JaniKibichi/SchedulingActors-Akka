package com.github.janikibichi.learnakka.schedulingActors

import akka.actor.{Actor, ActorSystem, Props}
import akka.pattern.{CircuitBreaker, ask}
import akka.util.Timeout
import scala.concurrent.duration._

//Message Objects
case class FetchRecord(recordID: Int)
case class Person(name: String, age: Int)

object CreateCircuitBreaker extends App {
  val actorSystem = ActorSystem("CreateCircuitBreaker")

  implicit val executionContext = actorSystem.dispatcher
  implicit val timeout = Timeout(3 seconds)

  //Create a circuit breaker, with timeout configuration
  val breaker =
    new CircuitBreaker(
      actorSystem.scheduler,
      maxFailures = 3,
      callTimeout = 1 seconds,
      resetTimeout = 2 seconds
    ).onOpen(println("===============> State is Open")
    ).onClose(println("===============> State is Clossed")
    )

  //Create and define the Actor in the ActorSystem
  val db = actorSystem.actorOf(Props[DBActor], "DBActor")

  (1 to 10).map(recordId =>{
    Thread.sleep(3000)

    //Send Ask Message
    val askFuture = breaker.withCircuitBreaker(db ? FetchRecord(recordId))

    //Print
    println(s"What the future looks like $askFuture")

    //Map the future from the Actor
    askFuture.map(record => s"Record is: $record and RecordID $recordId")
      .recover({
        case fail =>
          "Failed with: " + fail.toString
      })
      .foreach(x => println(x))
  })
}

//Create a Dummy DB
object DB{
  val data = Map(
    1 -> Person("John", 21),
    2 -> Person("Peter", 30),
    3 -> Person("James", 40),
    4 -> Person("Alice", 25),
    5 -> Person("Henry", 26),
    6 -> Person("Jackson",48))
}

//Create an Actor to fetch records mapped to the recordID
class DBActor extends Actor {
  def receive = {
    case FetchRecord(recordID) =>
      if(recordID >= 3 && recordID <= 5)
        Thread.sleep(3000)
      else sender ! DB.data.get(recordID)
  }
}


