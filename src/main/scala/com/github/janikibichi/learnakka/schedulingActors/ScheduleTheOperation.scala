package com.github.janikibichi.learnakka.schedulingActors

import akka.actor.ActorSystem
import scala.concurrent.duration._

object ScheduleTheOperation extends App {
  val actorSystem = ActorSystem("ScheduleActors")

  import actorSystem.dispatcher
  //Schedule
  actorSystem.scheduler.scheduleOnce(10 seconds){
    println(s"Sum of (1+2) is ${1+2}")
  }

  actorSystem.scheduler.schedule(11 seconds,2 seconds){
    println(s"Hello, Sorry for disturbing you every 2 seconds")
  }
}