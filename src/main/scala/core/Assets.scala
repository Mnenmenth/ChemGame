package core

import java.awt.image.BufferedImage
import java.nio.ByteBuffer
import scala.util.Random
import javax.imageio.ImageIO

import org.lwjgl.BufferUtils
import org.lwjgl.input.Mouse
import org.lwjgl.opengl.GL11._
import org.lwjgl.opengl.GL12
import org.newdawn.slick.Color
import org.newdawn.slick.opengl.{TextureImpl, Texture, TextureLoader}
import org.newdawn.slick.util.ResourceLoader
import player.Player

import scala.collection.mutable

/**
 * Created by mnenmenth on 5/26/15.
 */

object ImageCache {
  val imageCache = mutable.HashMap.empty[String, BufferedImage]
  val textureCache = mutable.HashMap.empty[String, Texture]
  val texIntCache = mutable.HashMap.empty[BufferedImage, Int]

  def loadImage(path: String) = {
    imageCache.getOrElseUpdate(path, ImageIO.read(ResourceLoader.getResourceAsStream(path)))
  }

  def loadTexture(path: String, fileType: String) = { //fileType = "PNG" || "JPG" || etc
    textureCache.getOrElseUpdate(path, TextureLoader.getTexture(fileType, ResourceLoader.getResourceAsStream(path)))
  }

  def loadTextureFromBuffImg(img: BufferedImage): Int ={
    def genTexInt(image: BufferedImage): Int ={
      val BYTES_PER_PIXEL = 4
      val pixels: Array[Int] = new Array(image.getWidth * image.getHeight)
      image.getRGB(0, 0, image.getWidth, image.getHeight, pixels, 0, image.getWidth)
      val buffer: ByteBuffer = BufferUtils.createByteBuffer(image.getWidth * image.getHeight * BYTES_PER_PIXEL)

      pixels.foreach{pixel =>
        buffer.put(((pixel >> 16) & 0xFF).toByte)
        buffer.put(((pixel >> 8) & 0xFF).toByte)
        buffer.put((pixel & 0xFF).toByte)
        buffer.put(((pixel >> 24) & 0xFF).toByte)
      }
      //buffer.asIntBuffer().put(pixels.map(p => Integer.rotateRight(p, 24)))


      buffer.flip()


      val textureId =glGenTextures()
      glBindTexture(GL_TEXTURE_2D, textureId)
      glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL12.GL_CLAMP_TO_EDGE)
      glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL12.GL_CLAMP_TO_EDGE)

      glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_LINEAR)
      glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_LINEAR)

      glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA8, image.getWidth, image.getHeight, 0, GL_RGBA, GL_UNSIGNED_BYTE, buffer)
      textureId
    }

    texIntCache.getOrElseUpdate(img, genTexInt(img))
  }

}

class Image(tex: Int, width: Float, height: Float){

  var getHeight = height
  var getWidth = width
  var xPos = 0
  var yPos = 0

  def setPos(x: Int, y: Int): Unit ={
    xPos = x
    yPos = y
  }

  def draw: Unit ={
    glPushMatrix()
    glBindTexture(GL_TEXTURE_2D, tex)
    glBegin(GL_QUADS)
      glTexCoord2f(0,0)
      glVertex2f(xPos, yPos)

      glTexCoord2f(0, 1)
      glVertex2f(xPos, yPos + height)

      glTexCoord2f(1, 1)
      glVertex2f(xPos + width, yPos + height)

      glTexCoord2f(1, 0)
      glVertex2f(xPos + width, yPos)
    glEnd()
    glPopMatrix()
  }
}

class Button(tex: Int, width: Float, height: Float) extends Image(tex, width, height) {
  var op: () => Any = null
  def setOp(operation: => Any) = op = () => operation
  def doOp = op()

}

class Question(question: String){
  var correct = false
  var qMap = mutable.HashMap.empty[String, Boolean]
  var qMapPos = mutable.HashMap.empty[String, (Int, Int)]

  def addOption(option: String, isAnswer: Boolean) = qMap.update(option, isAnswer)
  def draw: Unit ={
    var iteration = .13
    TextureImpl.bindNone()
    ChemGame.text.drawString(/*(ChemGame.CENTER_WIDTH*.75).toInt*/10,ChemGame.WINDOW_HEIGHT/8, question, Color.red)
    qMap.foreach{o =>
      val pos = ((ChemGame.CENTER_WIDTH*.95).toInt, (ChemGame.WINDOW_HEIGHT*(.12+iteration)).toInt)
      ChemGame.text.drawString(pos._1, pos._2, o._1, Color.blue)
      iteration+=.13
      qMapPos.getOrElseUpdate(o._1, pos)
    }
    qMap.foreach{a =>
      qMapPos.foreach{b =>
        if(a._1.equals(b._1) && a._2 && b._2._2 >= /*(ChemGame.WINDOW_HEIGHT-Mouse.getY)*/Player.finalY-(ChemGame.WINDOW_HEIGHT*.06).toInt && b._2._2 <= /*ChemGame.WINDOW_HEIGHT-Mouse.getY*/Player.finalY){
          ChemGame.text.drawString((ChemGame.CENTER_WIDTH*.99).toInt, (ChemGame.WINDOW_HEIGHT*(.12+iteration)).toInt, "Correct!", Color.magenta)
          correct = true
        }
      }
    }
  }

}

object RandomGen{

  def gen(array: Array[Question]): Int ={
    val rand = new Random()
    val randomQ: Int = rand.nextInt(array.length)
    randomQ
  }

}