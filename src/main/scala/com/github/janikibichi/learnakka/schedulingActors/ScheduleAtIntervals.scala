package com.github.janikibichi.learnakka.schedulingActors

import akka.actor.{Actor, Props, ActorSystem}
import scala.concurrent.duration._

//App that Schedules the Actor
object  ScheduleAtIntervals extends App {
  val actorSystem=ActorSystem("ScheduleAtIntervals")
  //Import the dispatcher
  import actorSystem.dispatcher

  //Create and define an Actor in the ActorSystem
  val actor = actorSystem.actorOf(Props[RandomIntAdder])

  //Send the messages to the actors at predefined intervals
  actorSystem.scheduler.scheduleOnce(10 seconds, actor, "tick")
  actorSystem.scheduler.schedule(11 seconds, 2 seconds, actor,"tick")
}

//Create an Actor that adds 2 random integers
class RandomIntAdder extends Actor {
  val random = scala.util.Random

  def receive = {
    case "tick" =>
      val randomInta = random.nextInt(10)
      val randomIntb = random.nextInt(10)

      println(s"sum of $randomInta and $randomIntb is ${randomInta+randomIntb}")
  }
}