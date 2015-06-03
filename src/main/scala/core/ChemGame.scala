package core
import menus.{MenuA, MainSelect}
import org.lwjgl.LWJGLException
import org.lwjgl.input.Keyboard
import org.lwjgl.opengl.{Display, DisplayMode}
import org.lwjgl.opengl.GL11._
import player.Player

/**
 * Created by mnenmenth on 5/22/15.
 */

object ChemGame{

  def SCREEN_HEIGHT = (java.awt.Toolkit.getDefaultToolkit.getScreenSize.getHeight.toInt * .75).toInt

  def SCREEN_WIDTH = (java.awt.Toolkit.getDefaultToolkit.getScreenSize.getWidth.toInt * .75).toInt

  def WINDOW_HEIGHT = Display.getHeight

  def WINDOW_WIDTH = Display.getWidth

  def CENTER_HEIGHT = WINDOW_HEIGHT / 4

  def CENTER_WIDTH = WINDOW_WIDTH / 4

  var quit = false
  def main(args: Array[String]): Unit ={
    glInit
    while(!quit){

      render
      update

      Display.update
      Display.sync(60)
    }
    Display.destroy
    System.exit(0)
  }

  def glInit: Unit ={
    Display.setTitle("Chem Game")
    try {
      Display.setDisplayMode(new DisplayMode(SCREEN_WIDTH, SCREEN_HEIGHT))
      Display.setVSyncEnabled(true)
      Display.create()
    } catch {
      case e: LWJGLException => System.out.println(e.printStackTrace())
        System.out.println("Shit happened m8")
    }

    glMatrixMode(GL_PROJECTION)
    glLoadIdentity()
    glOrtho(0, WINDOW_WIDTH, WINDOW_HEIGHT, 0, 1, -1)
    glMatrixMode(GL_MODELVIEW)
    glEnable(GL_TEXTURE_2D)
    glEnable(GL_BLEND)
    glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA)
    glClearColor(1f, 1f, 1f, 1f)
  }

  var player = false
  var mainSelect = true
  var a = false
  var b = false
  var c = false
  var d = false
  var e = false
  var f = false

  def render: Unit ={
    glClear(GL_COLOR_BUFFER_BIT)
    if(player) Player.render
    if(mainSelect) MainSelect.render
    if(a) MenuA.render
    if(b){}
    if(c){}
    if(d){}
    if(e){}
    if(f){}
  }

  def update: Unit ={
    if(player) Player.update()
    if(mainSelect) MainSelect.update
    if(a) MenuA.update
    if(Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)) quit = true
    if(Display.isCloseRequested) quit = true
  }

}
