package menus


import core.{BuffImg, ChemGame, ImageCache, Image}
import org.lwjgl.input.Mouse
import org.lwjgl.opengl.Display
import org.newdawn.slick.opengl.Texture

/**
 * Created by mnenmenth on 5/26/15.
 */
object MainSelect {

  val buttonARaw = ImageCache.loadImage("Buttons.png").getSubimage(184, 20, 576, 90)
  val buttonATex = ImageCache.loadTextureFromBuffImg(buttonARaw)
  val buttonA = new BuffImg(buttonATex, buttonARaw.getWidth, buttonARaw.getHeight)
  //val buttonB = new Image(ImageCache.loadTexture("button.png", "PNG"), ChemGame.WINDOW_WIDTH/4, ChemGame.WINDOW_HEIGHT/10)
  //val buttonC = new Image(ImageCache.loadTexture("button.png", "PNG"), ChemGame.WINDOW_WIDTH/4, ChemGame.WINDOW_HEIGHT/10)
  //val buttonD = new Image(ImageCache.loadTexture("button.png", "PNG"), ChemGame.WINDOW_WIDTH/4, ChemGame.WINDOW_HEIGHT/10)
  //val buttonE = new Image(ImageCache.loadTexture("button.png", "PNG"), ChemGame.WINDOW_WIDTH/4, ChemGame.WINDOW_HEIGHT/10)
  //val buttonF = new Image(ImageCache.loadTexture("button.png", "PNG"), ChemGame.WINDOW_WIDTH/4, ChemGame.WINDOW_HEIGHT/10)

  def render: Unit ={
    buttonA.draw((ChemGame.WINDOW_WIDTH*.45).toInt, ChemGame.SCREEN_HEIGHT/6)
    }

  def update: Unit = {

    if(Mouse.isButtonDown(0)){
      val mx = Mouse.getX
      val my = ChemGame.WINDOW_HEIGHT - Mouse.getY

      val buttonABool = mx >= buttonA.xPos && mx <= (buttonA.xPos + buttonA.getWidth) && my >= buttonA.yPos && my <= (buttonA.yPos + buttonA.getHeight)

      //ButtonA
      if(buttonABool){
        System.out.println("Hi")
      }

    }

  }

}
