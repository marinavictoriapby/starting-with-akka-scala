package hello

import akka.actor.{Actor, Props}

class Hello extends Actor {

  override def preStart(): Unit = {
    // create the greeter actor
    val greeter = context.actorOf(Props[Say], "greeter")
    val grumpy = context.actorOf(Props[Say], "grumpy")
    // tell it to perform the greeting
    greeter ! Say.Hello
    grumpy ! Say.Goodbye

    greeter forward "hey hey!"
  }

  def receive = {
    // when the greeter is done, stop this actor and with it the application
    case Say.Done => context.stop(self)
  }
}