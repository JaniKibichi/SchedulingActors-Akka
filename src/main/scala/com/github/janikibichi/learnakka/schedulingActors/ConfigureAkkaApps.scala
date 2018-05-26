package com.github.janikibichi.learnakka.schedulingActors

import akka.actor.{Props, Actor, ActorSystem}
import com.typesafe.config.Config
import com.typesafe.config.ConfigFactory

object ConfigureAkkaApps extends App {
  val config: Config = ConfigFactory.load("akka.conf")
  //Create ActorSystem
  val actorSystem = ActorSystem(config.getString("myactor.actorsystem"))

  val actorName = config.getString("myactor.actorname")

  //Create and Define an Actor in the Actor System
  val actor = actorSystem.actorOf(Props[MyActor], actorName)

  //Print
  println(actor.path)

  actorSystem.terminate()
}

//Define an Actor
class MyActor extends Actor {
  def receive ={
    case msg: String =>
      println(msg)
  }
}

