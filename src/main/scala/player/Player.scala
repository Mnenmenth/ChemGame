package player

import core.{ChemGame, ImageCache, Image}
import org.lwjgl.input.Keyboard

/**
 * Created by mnenmenth on 5/26/15.
 */

object Player{
  var x = ChemGame.CENTER_WIDTH
  var y = ChemGame.CENTER_HEIGHT
  val player = new Image(ImageCache.loadTexture("player.png", "PNG"), ChemGame.WINDOW_WIDTH / 11, ChemGame.WINDOW_HEIGHT / 8)

  def render: Unit ={
    player.draw(x, y)
  }

  def update(): Unit ={
    if(Keyboard.isKeyDown(Keyboard.KEY_UP)) y -= 2
    if(Keyboard.isKeyDown(Keyboard.KEY_DOWN)) y += 2
    if(Keyboard.isKeyDown(Keyboard.KEY_LEFT)) x -= 2
    if(Keyboard.isKeyDown(Keyboard.KEY_RIGHT)) x += 2
  }

}