package ticTacToe.actors

import ticTacToe.models.Game
import ticTacToe.views.CoordinateView

case class MoveMessage(game: Game, view: CoordinateView)
case object StopMessage
