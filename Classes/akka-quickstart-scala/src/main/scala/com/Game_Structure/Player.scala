package com.Game_Structure

import java.util.Random

import akka.actor.{Actor, ActorRef}

class Player(val name: String, players: => List[ActorRef]) extends Actor {
  private var throwsNum = 0

  override def receive: Receive = {
    case Ball(throws) => {
      if (throws >= 500)
        context.system.terminate()
      println(name + ": " + throwsNum + " Ball: " + throws)
      throwsNum += 1
      this.players((new Random).nextInt(players.length)) ! Ball(throws + 1)
    }
  }
}
