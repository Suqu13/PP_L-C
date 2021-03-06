package com.Ping_Pong_Structure

import akka.actor.{ActorSystem, Props}

object Match {
  def main(args: Array[String]): Unit = {
    val myMatch = ActorSystem("MyMatch")
    val player_1 = myMatch.actorOf(Props(new Player("John", "PONG")))
    val player_2 = myMatch.actorOf(Props(new Player("Mike", "PING")))

    player_1 ! Start(5, player_2)
  }
}
