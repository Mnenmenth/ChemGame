package menus

import core.{MultChoiceQ, ChemGame, Button}
import core.ImageCache._
import org.lwjgl.input.Mouse

/**
 * Created by mnenmenth on 5/28/15.
 */
object MenuA {

  val test = new MultChoiceQ(Array("Hi", "no"), ChemGame.CENTER_WIDTH, ChemGame.CENTER_HEIGHT)

  def render: Unit ={
    test.draw
  }

  def update: Unit ={

  }

}
