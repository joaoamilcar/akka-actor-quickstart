package actors.askpattern

import java.lang.Thread._

import akka.actor.Actor
import messages.AskName

class AskActor(val name: String) extends Actor {
  def receive = {

    case AskName => {
      //sleep(10000)
      sender() ! name
    }
  }
}
