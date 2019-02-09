package ticTacToe.views

object TypeOfGameView {
  def selectTypeOfGame : CoordinateView = {
    val typeOfGame = GestorIO.readString("Tipo de partida?[M/A]:")
    typeOfGame match {
      case "M" => new ManualCoordinateView()
      case "A" => new AutomaticCoordinateView()
      case _ => selectTypeOfGame
    }
  }

}
