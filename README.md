# Scheduling Actors
With schedulers, we set up an operation to run at a particular time in the future.

#### We schedule sending of messages to actors and get a Cancellable back. Using the Cancellable, we can call cancel on the scheduled operation.

#### We can also schedule a periodic or single message in an actor to itself. In this case we use the Actor Timers and not the Scheduler directly.
<br><br>
- Branch out to explore scheduling our first actors
````
git checkout -b create_scheduler master
````
- Create the file to handle the actor system: <b>com.github.janikibichi.learnakka.schedulingActors.ScheduleTheOperation.scala<b>
- Run the App to [see the Schedulers in Action](https://asciinema.org/a/wuZVNbRKY8p7YB5Dw8gPSCWKp)
