package actors.simple

import akka.actor.Actor
import messages.{IntegerMessage, StringMessage}

class SimpleActor extends Actor {

  def receive = {
    case StringMessage(phrase) => println("text: " + phrase)
    case IntegerMessage(number) => println("number: " + number)
    case _ => {
      println("unknown message received")
      context.stop(self)
    }
  }

  def foo = print("inner method")

}