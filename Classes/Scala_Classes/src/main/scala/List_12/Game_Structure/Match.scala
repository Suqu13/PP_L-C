package com.Game_Structure

import akka.actor.{ActorRef, ActorSystem, Props}

object Match {
  def main(args: Array[String]): Unit = {
    val myMatch = ActorSystem("MyMatch")

    var players_1: List[ActorRef] = Nil
    var players_2: List[ActorRef] = Nil
    var players_3: List[ActorRef] = Nil

    val player_1 = myMatch.actorOf(Props( new Player( "John", players_1)))
    val player_2 = myMatch.actorOf(Props(new Player( "Kim", players_2)))
    val player_3 = myMatch.actorOf(Props(new Player( "Mike", players_3)))

    players_1 = List(player_2, player_3)
    players_2 = List(player_1, player_3)
    players_3 = List(player_1, player_2)

    player_1 ! Ball()

  }
}
