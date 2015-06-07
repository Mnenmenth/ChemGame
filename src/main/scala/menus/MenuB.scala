package menus

import core.{Question, ChemGame, RandomGen}
import player.Player

/**
 * Created by mnenmenth on 5/28/15.
 */
object MenuB {

  val question1 = new Question("How do you get kelvin from celcius?")
  question1.addOption("Add 273", true)
  question1.addOption("Substract 273", false)
  question1.addOption("Add 298", false)

  val question2 = new Question("What is the conversion factor from farenheit to celcius?")
  question2.addOption("C=(F-32)*5/9", true)
  question2.addOption("C=(F-15)*4/16", false)

  val question3 = new Question("In what unit is specific heat measured?")
  question3.addOption("Joules", true)
  question3.addOption("moles", false)
  question3.addOption("kelvin", false)

  val question4 = new Question("What is the specific heat of water?")
  question4.addOption("4.186 Joules/gram", true)
  question4.addOption("6.738 Joules/gram", false)
  question4.addOption("28.938 Joules/gram", false)


  val questions = Array(question1, question2, question3, question4)
  var randomQ = RandomGen.gen(questions)

  var done = false

  def render: Unit ={
    questions(randomQ).draw
    if(questions(randomQ).correct) {
      done = true
      questions(randomQ).correct = false
    }
  }

  def update: Unit ={

    if(done){
      done = false
      new Thread{override def run(){
        Thread.sleep(2000)
        randomQ = RandomGen.gen(questions)
        Player.reset
        ChemGame.player = false
        ChemGame.b = false
        ChemGame.mainSelect = true
        randomQ = RandomGen.gen(questions)
        join()
      }}.start()
    }

  }
}
