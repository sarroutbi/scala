package ticTacToe

import ticTacToe.models.Game
import ticTacToe.views.{GameView, TypeOfGameView, CoordinateView, ManualCoordinateView, GestorIO}

object Main {

  var game = new Game

  def main(args: Array[String]): Unit = {
    val coordinateView = TypeOfGameView.selectTypeOfGame
    GameView.write(game)
    do {
      if (!game.isComplete){
        game = game.put(coordinateView.read)
      } else {
        game = game.move(coordinateView.read, coordinateView.read)
      }
      GameView.write(game)
    } while (!game.isTicTacToe)
    GestorIO.write("... pero has perdido")
  }
}
