package player

import core.{ChemGame, Image, ImageCache}
import org.lwjgl.input.Keyboard

/**
 * Created by mnenmenth on 5/26/15.
 */

object Player{
  var x = ChemGame.CENTER_WIDTH
  var y = ChemGame.CENTER_HEIGHT
  val player = new Image(ImageCache.loadTextureFromBuffImg(ImageCache.loadImage("player.png").getSubimage(47, 29, 212, 690)), ChemGame.WINDOW_WIDTH / 32, ChemGame.WINDOW_HEIGHT / 8)

  def render: Unit ={
    player.draw
  }

  def update(): Unit ={
    if(Keyboard.isKeyDown(Keyboard.KEY_UP) && y >= 0) y -= 2
    if(Keyboard.isKeyDown(Keyboard.KEY_DOWN) && y + player.getHeight <= ChemGame.WINDOW_HEIGHT) y += 2
    if(Keyboard.isKeyDown(Keyboard.KEY_LEFT) && x >= 0) x -= 2
    if(Keyboard.isKeyDown(Keyboard.KEY_RIGHT) && x + player.getWidth <= ChemGame.WINDOW_WIDTH) x += 2
    player.setPos(x, y)
  }

}