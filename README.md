# Scheduling Actors
With schedulers, we set up an operation to run at a particular time in the future.

#### We schedule sending of messages to actors and get a Cancellable back. Using the Cancellable, we can call cancel on the scheduled operation.

#### We can also schedule a periodic or single message in an actor to itself. In this case we use the Actor Timers and not the Scheduler directly.
<br><br>
- Branch out to explore scheduling our first actors
````
git checkout -b create_scheduler master
````
- Create the file to handle the actor system: <b>com.github.janikibichi.learnakka.schedulingActors.ScheduleTheOperation.scala</b>
- Run the App to [see the Schedulers in Action](https://asciinema.org/a/wuZVNbRKY8p7YB5Dw8gPSCWKp)
<br><br>
- Branch out to explore scheduling an actor's at an interval
````
git checkout -b schedule_at_an_interval create_scheduler 
````
- Create the file to handle the actor system: <b>com.github.janikibichi.learnakka.schedulingActors.ScheduleAtIntervals.scala<b>
- Run the App to [explore scheduling at an interval](https://asciinema.org/a/8N8GbRgwQCuHWLkFNNOcxs9U4)
<br><br>
- Branch out to explore cancelling a scheduled actor
````
git checkout -b cancelling_a_scheduled_actor schedule_at_an_interval
````
- Create the file to handle the actor system: <b>com.github.janikibichi.learnakka.schedulingActors.CancelScheduledOperation.scala</b>
- Run the App to [explore cancelling a scheduled actor](https://asciinema.org/a/T2V4PKDkoQ4jmCJw0QfI0p2yb)
<br><br>
- Branch out to explore creating a circuit breaker to avoid cascading failure
````
git checkout -b create_circuit_breaker cancelling_a_scheduled_actor
````
- Create the file to handle the actor system: <b>com.github.janikibichi.learnakka.schedulingActors.CreateCircuitBreaker.scala</b>
- Run the App to [explore cancelling a scheduled actor](https://asciinema.org/a/mPZXC0CSSyFjWpsaKm2J7qosl)
<br><br>
- Branch out to explore logging with actors
````
git checkout -b logging_with_actors create_circuit_breaker 
````
- Create the file to handle the actor system: <b>com.github.janikibichi.learnakka.schedulingActors.LoggingWithActors.scala</b>
- Run the App to [explore logging with actors](https://asciinema.org/a/mPZXC0CSSyFjWpsaKm2J7qosl)
<br><br>
- Branch out to explore writing unit tests for actors
````
git checkout -b unit_tests_for_actors logging_with_actors
````
- Create the file to handle the actor system: <b>com.github.janikibichi.learnakka.schedulingActors.UnitTestsForActors.scala</b>
- Add the dependencies for testing:
````
libraryDependencies += "com.typesafe.akka" %% "akka-testkit" % "2.5.12" % Test

libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.4" % Test
````
- Run the App to [write unit tests for actors](https://asciinema.org/a/6htDURXjZK5Lzeg70NEYOKdnv)
<br><br>
- Branch out to explore packaging and deploying Akka standalone
````
git checkout -b stand_alone_akka unit_tests_for_actors 
````
- Add the dependencies for plugin assembly in project/assembly.sbt:
````
addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "0.14.6")
````
- Run sbt update
- Run sbt assembly to [package the standalone app](https://asciinema.org/a/EVekKYAX4asifjm8ILJVfj5lg)