package menus

import java.{awt, util}
import java.awt.RenderingHints.Key
import java.awt._
import java.awt.font.{FontRenderContext, GlyphVector}
import java.awt.geom.AffineTransform
import java.awt.image.{RenderedImage, BufferedImageOp, BufferedImage, ImageObserver}
import java.awt.image.renderable.RenderableImage
import java.text.AttributedCharacterIterator

import core.{RandomGen, Question, ChemGame}
import org.lwjgl.opengl.AWTGLCanvas
import org.newdawn.slick.Color
import org.newdawn.slick.opengl.TextureImpl
import player.Player

import scala.util.Random

/**
 * Created by mnenmenth on 5/28/15.
 */
object MenuA extends AWTGLCanvas{

  val question1 = new Question("Is Color A Chemical Or Physical Property?")
  question1.addOption("Chemical Property", false)
  question1.addOption("Physical Property", true)

  val question2 = new Question("Is the solubility of an element a chemical or physical property?")
  question2.addOption("Chemical Property", true)
  question2.addOption("Physical Property", false)

  val question3 = new Question("Name one of two physical properties of a crayon")
  question3.addOption("Color", true)
  question3.addOption("Reactant from burning", false)
  question3.addOption("Shape", true)
  question3.addOption("The way in which it melts in acid", false)

  val question4 = new Question("Is cracking and egg a physical or chemical change?")
  question4.addOption("Physical Change", true)
  question4.addOption("Chemical Change", false)

  val question5 = new Question("What state of matter is soda?")
  question5.addOption("Liquid", true)
  question5.addOption("Solid", false)
  question5.addOption("Gas", false)

  val question6 = new Question("What state of matter is grass?")
  question6.addOption("Solid", true)
  question6.addOption("Liquid", false)
  question6.addOption("Gas", false)

  val question7 = new Question("What state of matter is helium?")
  question7.addOption("Gas", true)
  question7.addOption("Liquid", false)
  question7.addOption("Solid", false)

  val question8 = new Question("Is mixing salt and water a chemical or physical change?")
  question8.addOption("Physical Change", true)
  question8.addOption("Chemical Change", false)

  val question9 = new Question("What is the formula to find density")
  question9.addOption("D=m/v", true)
  question9.addOption("V=P/T", false)

  val question10 = new Question("What is the structure of the particles in a solid?")
  question10.addOption("Tightly Compacted", true)
  question10.addOption("Free Ranging", false)
  question10.addOption("Close Contact", false)

  val question11 = new Question("What is the structure of the particles in a gas")
  question11.addOption("Free Floating", true)
  question11.addOption("Not compacted", true)
  question11.addOption("Tightly Compacted", false)

  val question12 = new Question("Is flammability a physical or chemical characteristic")
  question12.addOption("Chemical Characteristic", true)
  question12.addOption("Physical Characteristic", false)

  val question13 = new Question("Is Carbon alone a pure substance or mixture?")
  question13.addOption("Pure Substance", true)
  question13.addOption("Mixture", false)

  val question14 = new Question("Is KSO4 a pure substance or mixture?")
  question14.addOption("Mixture", true)
  question14.addOption("Pure Substance", false)

  val question15 = new Question("What state of matter is the exhaust from a car?")
  question15.addOption("Gas", true)
  question15.addOption("Solid", false)
  question15.addOption("Liquid", false)

  val question16 = new Question("Is size a physical or chemical property")
  question16.addOption("Physical Property", true)
  question16.addOption("Chemical Property", false)

  val question17 = new Question("What is the unit used for density")
  question17.addOption("kg/m^3", true)
  question17.addOption("mL/V^2", false)

  val question18 = new Question("Is air a mixture or pure substance")
  question18.addOption("Mixture", true)
  question18.addOption("Pure Substance", false)

  val question19 = new Question("What state is jello?")
  question19.addOption("Solid", true)
  question19.addOption("Gas", false)
  question19.addOption("Liquid", false)
  question19.addOption("Plasma", false)

  val question20 = new Question("What is density measuring?")
  question20.addOption("The measure of atoms in a substance", true)
  question20.addOption("Measure of elements in a substance", false)
  question20.addOption("Measure of space an element takes up", false)

  val question21 = new Question("Is cooking and egg a physical or chemical change?")
  question21.addOption("Chemical Change", true)
  question21.addOption("Physical Change", false)

  val question22 = new Question("Is water freezing a chemical or physical change?")
  question22.addOption("Chemical Change", false)
  question22.addOption("Physical Change", true)

  val questions = Array(question1, question2, question3, question4, question5, question6, question7, question8, question9, question10,
  question11, question12, question13, question14, question15, question16, question17, question18, question19, question20, question21, question22)

  //val rand = new Random()
  //val randomQ: Int = rand.nextInt((questions.length-1 - 0) + 1) + 0
  var randomQ = RandomGen.gen(questions)

  var done = false

  def render: Unit ={
    questions(randomQ).draw
    if(questions(randomQ).correct) done = true
  }

  def update: Unit ={

    if(done){
      new Thread{override def run(){
        done = false
        Player.reset
        Thread.sleep(2000)
        ChemGame.player = false
        ChemGame.a = false
        ChemGame.mainSelect = true
        join()
      }}.start()
    }

  }

}