package actors.simple

import akka.actor.{ActorSystem, Props}
import messages.{IntegerMessage, StringMessage}

object Main extends App {

  val system = ActorSystem("simpleSystem")
  val actor = system.actorOf(Props[SimpleActor], "simpleActor")

  val phraseMessage = StringMessage("hello actor")
  val numberMessage = IntegerMessage(42)

  actor ! phraseMessage
  actor ! numberMessage
  actor ! true

  system.terminate()

}
