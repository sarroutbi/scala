package ticTacToe.actors

import akka.actor.{Actor, ActorRef}
import ticTacToe.views.{GameView, GestorIO}

class Player(player: ActorRef = null) extends Actor {
  def receive = {
    case MoveMessage(game, view) =>
      var resultingGame = game
      if (!game.isComplete) {
        resultingGame = game.put(view.read)
      } else {
        resultingGame = game.move(view.read, view.read)
      }
      GameView.write(resultingGame)
      if(resultingGame.isTicTacToe) {
        if(player != null) {
          player ! StopMessage
        } else {
          sender ! StopMessage
        }
        context.stop(self)
        context.system.terminate()
      }
      else if(player != null) {
        player ! MoveMessage(resultingGame, view)
      } else {
        sender ! MoveMessage(resultingGame, view)
      }
    case StopMessage =>
      GestorIO.write("... pero has perdido")
      context.stop(self)
  }
}
