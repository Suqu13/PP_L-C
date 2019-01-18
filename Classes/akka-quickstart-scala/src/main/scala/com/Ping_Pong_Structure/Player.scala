package com.Ping_Pong_Structure

import akka.actor.{Actor, ActorRef}
//TODO: The constructor probably should be changes. The right formula should be smth like (msg: String), only
class Player(private val name: String, private val msg: String, player: ActorRef) extends Actor {

  override def receive: Receive = {
    case Moves(moves) => {
      if (moves > 0) {
        println(name + ": " + msg)
        //TODO: Probably only sending back
        if (player != null) {
          player ! Moves(moves - 1)
        } else {
          sender() ! Moves(moves - 1)
        }
      } else {
        context.system.terminate()
      }
    }
    case Start(moves) => {
      if (moves > 0) {
        println(name + ": " + msg)
        //TODO: Easily can be changed into "context.actorOf(Props(classOf[Player], "smth")) ! Moves(moves - 1)
        player ! Moves(moves - 1)
      } else {
        println("\n***Number of moves is smaller than 1!***")
        context.system.terminate()
      }
    }
  }

}
