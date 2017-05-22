package hello

import akka.actor.Actor

object Say {

  case object Hello

  case object Goodbye

  case object Done

}

class Say extends Actor {
  override def receive = {
    case Say.Hello =>
      println("Hello World!")
      sender() ! Say.Done

    case Say.Goodbye =>
      println("Goodbye World!")
      sender() ! Say.Done

    case "hey hey!" =>
      println("What is uuuuup!")
      sender() ! Say.Done
  }

}