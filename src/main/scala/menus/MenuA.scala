package menus

import java.{awt, util}
import java.awt.RenderingHints.Key
import java.awt._
import java.awt.font.{FontRenderContext, GlyphVector}
import java.awt.geom.AffineTransform
import java.awt.image.{RenderedImage, BufferedImageOp, BufferedImage, ImageObserver}
import java.awt.image.renderable.RenderableImage
import java.text.AttributedCharacterIterator

import core.{Question, ChemGame}
import org.lwjgl.opengl.AWTGLCanvas
import org.newdawn.slick.Color
import org.newdawn.slick.opengl.TextureImpl

/**
 * Created by mnenmenth on 5/28/15.
 */
object MenuA extends AWTGLCanvas{

  val question = new Question("Is Color A Chemical Or Physical Property?")
  question.addOption("Chemical Property", false)
  question.addOption("Physical Property", true)

  def render: Unit ={
    question.draw
  }

  def update: Unit ={

  }

}