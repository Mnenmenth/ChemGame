package menus


import core.{Button, ChemGame, Image, ImageCache}
import org.lwjgl.input.Mouse

/**
 * Created by mnenmenth on 5/26/15.
 */
object MainSelect {

  val buttonARaw = ImageCache.loadImage("Buttons.png").getSubimage(184, 20, 576, 90)
  val buttonATex = ImageCache.loadTextureFromBuffImg(buttonARaw)
  val buttonA = new Button(buttonATex, ChemGame.WINDOW_WIDTH / 2, ChemGame.WINDOW_HEIGHT / 8)
  buttonA.setPos((ChemGame.WINDOW_WIDTH * .25).toInt, ChemGame.WINDOW_HEIGHT / 8)
  buttonA.setOp({
    ChemGame.mainSelect = false
    ChemGame.a = true
    ChemGame.player = true
  })

  val buttonBRaw = ImageCache.loadImage("Buttons.png").getSubimage(184, 140, 265, 86)
  val buttonBTex = ImageCache.loadTextureFromBuffImg(buttonBRaw)
  val buttonB = new Button(buttonBTex, (ChemGame.WINDOW_WIDTH * .23).toInt, ChemGame.WINDOW_HEIGHT / 8)
  buttonB.setPos((ChemGame.WINDOW_WIDTH * .25).toInt, ChemGame.WINDOW_HEIGHT / 4)
  buttonB.setOp({
    ChemGame.mainSelect = false
    ChemGame.b = true
  })

  val buttonCRaw = ImageCache.loadImage("Buttons.png").getSubimage(184, 247, 199, 86)
  val buttonCTex = ImageCache.loadTextureFromBuffImg(buttonCRaw)
  val buttonC = new Button(buttonCTex, (ChemGame.WINDOW_WIDTH * .18).toInt, ChemGame.WINDOW_HEIGHT / 8)
  buttonC.setPos((ChemGame.WINDOW_WIDTH * .25).toInt, (ChemGame.WINDOW_HEIGHT * .38).toInt)
  buttonB.setOp({
    ChemGame.mainSelect = false
    ChemGame.c = true
  })

  val buttonDRaw = ImageCache.loadImage("Buttons.png").getSubimage(184, 360, 298, 87)
  val buttonDTex = ImageCache.loadTextureFromBuffImg(buttonDRaw)
  val buttonD = new Button(buttonDTex, (ChemGame.WINDOW_WIDTH * .26).toInt, ChemGame.WINDOW_HEIGHT / 8)
  buttonD.setPos((ChemGame.WINDOW_WIDTH * .25).toInt, (ChemGame.WINDOW_HEIGHT * .51).toInt)
  buttonD.setOp({
    ChemGame.mainSelect = false
    ChemGame.d = true
  })

  val buttonERaw = ImageCache.loadImage("Buttons.png").getSubimage(184, 485, 482, 87)
  val buttonETex = ImageCache.loadTextureFromBuffImg(buttonERaw)
  val buttonE = new Button(buttonETex, (ChemGame.WINDOW_WIDTH * .42).toInt, ChemGame.WINDOW_HEIGHT/8)
  buttonE.setPos((ChemGame.WINDOW_WIDTH*.25).toInt, (ChemGame.WINDOW_HEIGHT*.64).toInt)
  buttonE.setOp({
    ChemGame.mainSelect = false
    ChemGame.e = true
  })

  val buttonFRaw = ImageCache.loadImage("Buttons.png").getSubimage(184, 590, 176, 86)
  val buttonFTex = ImageCache.loadTextureFromBuffImg(buttonFRaw)
  val buttonF = new Button(buttonFTex, (ChemGame.WINDOW_WIDTH*.15).toInt, ChemGame.WINDOW_HEIGHT/8)
  buttonF.setPos((ChemGame.WINDOW_WIDTH*.25).toInt, (ChemGame.WINDOW_HEIGHT*.77).toInt)
  buttonF.setOp({
    ChemGame.mainSelect = false
    ChemGame.f = true
  })

  val buttons = Array(buttonA, buttonB, buttonC, buttonD, buttonE, buttonF)

  def render: Unit = buttons.foreach (b => b.draw)

  def update: Unit = {

    if (Mouse.isButtonDown(0)) {
      val mx = Mouse.getX
      val my = ChemGame.WINDOW_HEIGHT - Mouse.getY

      buttons.foreach { b =>
        new Thread{override def run() {
          val buttonBool = mx >= b.xPos && mx <= (b.xPos + b.getWidth) && my >= b.yPos && my <= (b.yPos + b.getHeight)
          if (buttonBool) b.doOp
          join()
        }}.start()
      }
    }

  }

}
