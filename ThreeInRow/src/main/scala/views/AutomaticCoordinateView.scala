package ticTacToe.views

import ticTacToe.models.Coordinate

class AutomaticCoordinateView extends CoordinateView {
  def read:Coordinate = {
    new Coordinate(scala.util.Random.nextInt(3), scala.util.Random.nextInt(3))
  }
}
