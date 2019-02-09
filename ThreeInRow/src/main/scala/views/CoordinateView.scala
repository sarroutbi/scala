package ticTacToe.views

import ticTacToe.models.Coordinate

abstract class CoordinateView {
  def read() : Coordinate
}
