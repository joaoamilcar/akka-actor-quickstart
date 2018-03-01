package actors.askpattern

import akka.actor.{ActorSystem, Props}
import messages.AskName
import akka.pattern._
import akka.util.Timeout
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global

object Main extends App {
  val system = ActorSystem("askSystem")
  val actor = system.actorOf(Props(new AskActor("John")), "askActor")

  implicit val timeout = Timeout(1.seconds)

  val answer = actor ? AskName
  answer.foreach(a => println(s"Name is $a"))

  system.terminate()
}
