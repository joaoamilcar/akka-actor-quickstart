package actors.communicating

import akka.actor.Actor
import messages.{IntegerMessage, StartCounting, Countdown}

class CountdownActor extends Actor{
  def receive = {
    case StartCounting(count, actor) => {
      println(s"$count - $self")
      actor ! Countdown(count - 1)
    }
    case Countdown(count) => {
      if(count >= 0) {
        println(s"$count - $self")
        sender() ! Countdown(count - 1)
      } else {
        context.system.terminate()
      }
    }
    case _ => {
      println("unknown message received")
      context.stop(self)
    }
  }
}
