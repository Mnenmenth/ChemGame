package menus


import core.{ChemGame, ImageCache, Image}
import org.lwjgl.input.Mouse
import org.lwjgl.opengl.Display
import org.newdawn.slick.opengl.Texture

/**
 * Created by mnenmenth on 5/26/15.
 */
object MainSelect {

  val buttonARaw = ImageCache.loadImage("Buttons.png").getSubimage(184, 20, 576, 90)
  val buttonATex = ImageCache.loadTextureFromBuffImg(buttonARaw)
  val buttonA = new Image(buttonATex, ChemGame.WINDOW_WIDTH/2, ChemGame.WINDOW_HEIGHT/8)
  var buttonARender = true

  val buttonBRaw = ImageCache.loadImage("Buttons.png").getSubimage(185, 140, 265, 86)
  val buttonBTex = ImageCache.loadTextureFromBuffImg(buttonBRaw)
  val buttonB = new Image(buttonBTex, ChemGame.WINDOW_WIDTH/2, ChemGame.WINDOW_HEIGHT/8)
  var buttonBRender = true

  //val buttonB = new Image(ImageCache.loadTexture("button.png", "PNG"), ChemGame.WINDOW_WIDTH/4, ChemGame.WINDOW_HEIGHT/10)
  //val buttonC = new Image(ImageCache.loadTexture("button.png", "PNG"), ChemGame.WINDOW_WIDTH/4, ChemGame.WINDOW_HEIGHT/10)
  //val buttonD = new Image(ImageCache.loadTexture("button.png", "PNG"), ChemGame.WINDOW_WIDTH/4, ChemGame.WINDOW_HEIGHT/10)
  //val buttonE = new Image(ImageCache.loadTexture("button.png", "PNG"), ChemGame.WINDOW_WIDTH/4, ChemGame.WINDOW_HEIGHT/10)
  //val buttonF = new Image(ImageCache.loadTexture("button.png", "PNG"), ChemGame.WINDOW_WIDTH/4, ChemGame.WINDOW_HEIGHT/10)

  def render: Unit ={
    if(buttonARender) buttonA.draw((ChemGame.WINDOW_WIDTH*.25).toInt, ChemGame.SCREEN_HEIGHT/6)
    buttonB.draw((ChemGame.WINDOW_WIDTH*.25).toInt, ChemGame.SCREEN_HEIGHT/3)
  }

  def update: Unit = {

    if(Mouse.isButtonDown(0)){
      val mx = Mouse.getX
      val my = ChemGame.WINDOW_HEIGHT - Mouse.getY

      val buttonABool = mx >= buttonA.xPos && mx <= (buttonA.xPos + buttonA.getWidth) && my >= buttonA.yPos && my <= (buttonA.yPos + buttonA.getHeight)

      //ButtonA
      if(buttonABool && buttonARender){
        println(mx + my)
        buttonARender = true
        Thread.sleep(100)
      }

    }

  }

}
