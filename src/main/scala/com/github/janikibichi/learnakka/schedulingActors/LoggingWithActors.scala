package com.github.janikibichi.learnakka.schedulingActors

import akka.actor.{Props, ActorSystem, ActorLogging, Actor}

object LoggingWithActors extends App {
  val actorSystem = ActorSystem("LoggingWithActors")

  //Create and define an Actor in the ActorSystem
  val actor = actorSystem.actorOf(Props[LoggingActor], "SumActor")

  //Send messages to the Actors
  actor ! (10, 12)
  actor ! "Hello dude!!!!"

  //Terminate
  actorSystem.terminate()

}

//Create an Actor with Logging
class LoggingActor extends Actor with ActorLogging {
  def receive = {
    case (a: Int, b: Int) => {
      log.info(s"Sum of $a and $b is ${a+b}")
    }

    case msg =>
      log.warning(s" i dont know what you are talking about : $msg")
  }
}
