package actors

import akka.actor.{Actor, ActorSystem, Props}
import messages.{IntegerMessage, StringMessage}

class SimpleActor extends Actor {

  def receive = {
    case StringMessage(phrase) => println("text: " + phrase)
    case IntegerMessage(number) => println("number: " + number)
    case _ => context.stop(self)
  }

  def foo = print("inner method")

}