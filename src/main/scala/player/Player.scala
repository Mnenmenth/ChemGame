package player

import core.{ChemGame, Image, ImageCache}
import org.lwjgl.input.{Mouse, Keyboard}

/**
 * Created by mnenmenth on 5/26/15.
 */

object Player{
  var x = ChemGame.CENTER_WIDTH
  var y = ChemGame.CENTER_HEIGHT
  var mx = 0
  var my = 0
  var pressed = false
  var done = true
  val player = new Image(ImageCache.loadTextureFromBuffImg(ImageCache.loadImage("player.png").getSubimage(47, 29, 212, 690)), ChemGame.WINDOW_WIDTH / 32, ChemGame.WINDOW_HEIGHT / 8)

  def render: Unit ={
    player.draw
  }

  def update(): Unit ={
    if(Mouse.isButtonDown(0) && ChemGame.player && done){
      pressed = !pressed
      mx = Mouse.getX
      my = Mouse.getY
    }
    if(Keyboard.isKeyDown(Keyboard.KEY_UP) && y >= 0) y -= 2
    if(Keyboard.isKeyDown(Keyboard.KEY_DOWN) && y + player.getHeight <= ChemGame.WINDOW_HEIGHT) y += 2
    if(Keyboard.isKeyDown(Keyboard.KEY_LEFT) && x >= 0) x -= 2
    if(Keyboard.isKeyDown(Keyboard.KEY_RIGHT) && x + player.getWidth <= ChemGame.WINDOW_WIDTH) x += 2
    if(pressed && ChemGame.player && done){
      pressed = !pressed
      done = false
      moveTo(mx, ChemGame.WINDOW_HEIGHT - my)
    }
    player.setPos(x, y)
  }

  def moveTo(x1: Int, y1: Int): Unit ={
    val thread = new Thread(){override def run() {
      while (x != x1.toInt && !touchingXBounds) {
        if(inXBounds) {
          Thread.sleep(4)
          if (x < x1 && x + player.getWidth <= ChemGame.WINDOW_WIDTH) x += 1
          if (x > x1 && x >= 0) x -= 1
        }
      }

      while (y != y1.toInt && !touchingYBounds){
        Thread.sleep(4)
        if(inYBounds) {
          if (y < y1) y += 1
          if (y > y1) y -= 1
        }
      }
      println("x: " + x + " x1: " + x1)
      println("y: " + y + " y1: " + y1)
      done = true
      join
    }}
    thread.synchronized(true)
    thread.start
  }

  def inXBounds: Boolean = (x + player.getWidth <= ChemGame.WINDOW_WIDTH) && (x >= 0)
  def touchingXBounds: Boolean = (x + player.getWidth == ChemGame.WINDOW_WIDTH) || (x == 0)
  def inYBounds: Boolean = (y + player.getHeight <= ChemGame.WINDOW_HEIGHT) && (y >= 0)
  def touchingYBounds: Boolean = (y + player.getHeight == ChemGame.WINDOW_HEIGHT) || (y == 0)

}