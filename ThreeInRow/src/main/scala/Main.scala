package ticTacToe

import java.time.Duration

import ticTacToe.models.Game

import ticTacToe.views.{GameView, TypeOfGameView}
import ticTacToe.actors.{MoveMessage, Player}
import akka.actor.{ActorSystem, Props}
import scala.concurrent.Await
import scala.concurrent.duration.Duration.Inf

object Main {

  var game = new Game

  def main(args: Array[String]): Unit = {
    val coordinateView = TypeOfGameView.selectTypeOfGame
    GameView.write(game)
    val system = ActorSystem("system")
    val playerO = system.actorOf(Props(new Player(null)), name = "O")
    val playerX = system.actorOf(Props(new Player(playerO)), name = "X")
    playerX ! MoveMessage(game, coordinateView)
    Await.ready(system.whenTerminated, Inf)
  }
}
