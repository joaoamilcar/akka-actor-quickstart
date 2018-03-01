package actors.communicating

import akka.actor.{ActorSystem, Props}
import messages.StartCounting

object Main extends App {

  val system = ActorSystem("communicatingSystem")
  val actor1 = system.actorOf(Props[CountdownActor], "countdownActor1")
  val actor2 = system.actorOf(Props[CountdownActor], "countdownActor2")

  actor1 ! StartCounting(10, actor2)

  system.terminate()

}