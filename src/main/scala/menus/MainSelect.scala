package menus

import java.awt.event.MouseEvent

import core.{ChemGame, ImageCache, Image}
import org.lwjgl.input.Mouse

/**
 * Created by mnenmenth on 5/26/15.
 */
object MainSelect {

  //val background = new Image(ImageCache.loadTexture("background.png", "PNG"), ChemGame.WINDOW_WIDTH, ChemGame.WINDOW_HEIGHT)
  val button = ImageCache.loadTexture("button.png", "PNG")
  val buttonA = new Image(button, button.getImageWidth, button.getImageHeight)
  val buttonB = new Image(ImageCache.loadTexture("button.png", "PNG"), ChemGame.WINDOW_WIDTH/4, ChemGame.WINDOW_HEIGHT/10)
  val buttonC = new Image(ImageCache.loadTexture("button.png", "PNG"), ChemGame.WINDOW_WIDTH/4, ChemGame.WINDOW_HEIGHT/10)
  val buttonD = new Image(ImageCache.loadTexture("button.png", "PNG"), ChemGame.WINDOW_WIDTH/4, ChemGame.WINDOW_HEIGHT/10)
  val buttonE = new Image(ImageCache.loadTexture("button.png", "PNG"), ChemGame.WINDOW_WIDTH/4, ChemGame.WINDOW_HEIGHT/10)
  val buttonF = new Image(ImageCache.loadTexture("button.png", "PNG"), ChemGame.WINDOW_WIDTH/4, ChemGame.WINDOW_HEIGHT/10)

  def render: Unit ={
    buttonA.draw(200, 200)
  }

  def update: Unit = {

    if(Mouse.isButtonDown(0)){
      val x = Mouse.getX
      val y = Mouse.getY
      println("X: " + x + " Y: " + y)
      println("ButtonX: " + buttonA.xPos + " ButtonY: " + buttonA.yPos)
      println("ModX: " + (buttonA.xPos + buttonA.imgWidth) + " ModY: " + (buttonA.xPos - buttonA.imgHeight))
      println("")

      //ButtonA
      if(x >= buttonA.xPos && x <= (buttonA.xPos + buttonA.imgWidth) && y >= buttonA.yPos && y <= (buttonA.yPos + buttonA.imgHeight)){
        System.out.println("Hi")
      }

    }

  }

}
