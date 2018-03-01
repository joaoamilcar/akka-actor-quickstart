package messages

import akka.actor.ActorRef

/**
  * SimpleActor
  */
case class IntegerMessage(number: Int)
case class StringMessage(string: String)

/**
  * CountdownActor
  */
case class StartCounting(number: Int, otherActor: ActorRef)
case class Countdown(number: Int)

/**
  * AskActor
  */
case object AskName