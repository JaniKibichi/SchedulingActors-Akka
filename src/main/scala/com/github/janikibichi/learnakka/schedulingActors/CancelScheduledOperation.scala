package com.github.janikibichi.learnakka.schedulingActors

import akka.actor.{Cancellable, Props, ActorSystem, Actor}
import scala.concurrent.duration._


object CancelScheduledOperation extends App {
  val actorSystem = ActorSystem("CancelSchedule")

  //Set dispatcher
  import actorSystem.dispatcher

  //Create and define the Actor in the ActorSystem
  val actor = actorSystem.actorOf(Props[CancelOperation])

  //Create a cancellable scheduler
  val cancellable: Cancellable = actorSystem.scheduler.schedule(0 seconds, 2 seconds, actor, "tick")
}

//Define the Actor
class CancelOperation extends Actor {
  var i = 10

  def receive = {
    case "tick" => {
      println(s"Hi, Do you know i do the same task again and again")

      //Call cancel from the cancellable when state is achieved
      i = i - 1
      if (i == 0) CancelScheduledOperation.cancellable.cancel()
    }
  }
}