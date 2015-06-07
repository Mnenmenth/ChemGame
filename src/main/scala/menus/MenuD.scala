package menus

import core.{Question, ChemGame, RandomGen}
import player.Player

/**
 * Created by mnenmenth on 5/28/15.
 */
object MenuD {

  val question1 = new Question("In which 3D shape should the Periodic Table be viewed in?")
  question1.addOption("Sphere", true)
  question1.addOption("Square", false)
  question1.addOption("Triangle", false)

  val question2 = new Question("Which direction are groups on the Periodic Table?")
  question2.addOption("Vertical", true)
  question2.addOption("Horizontal", false)

  val question3 = new Question("Which direction are periods on the Periodic Table?")
  question3.addOption("Vertical", false)
  question3.addOption("Horizontal", true)

  val question4 = new Question("Which group on the Periodic Table are the Halogens?")
  question4.addOption("17", true)
  question4.addOption("13", false)
  question4.addOption("16", false)

  val question5 = new Question("What group on the Periodic Table are the Noble Gases?")
  question5.addOption("18", true)
  question5.addOption("11", false)
  question5.addOption("9", false)

  val question6 = new Question("What type of metals are in the center of the Periodic Table?")
  question6.addOption("Transition Metals", true)
  question6.addOption("Halogens", false)
  question6.addOption("Noble Gases", false)

  val question7 = new Question("Atomic numbers get larger as you go: ")
  question7.addOption("Right", true)
  question7.addOption("Left", false)

  val question8 = new Question("Who invented the Periodic Table?")
  question8.addOption("Dimitri Mendeleev", true)
  question8.addOption("Albert Einstein", false)
  question8.addOption("Dalton", false)

  val question9 = new Question("How many elements were on the original Periodic Table?")
  question9.addOption("60 Elements", true)
  question9.addOption("43 Elements", false)
  question9.addOption("29 Elements", false)

  val question10 = new Question("Which of these element types can be on the Periodic Table?")
  question10.addOption("Solid", true)
  question10.addOption("Liquid", true)
  question10.addOption("Gas", true)
  question10.addOption("Synthetic", true)

  val question11 = new Question("Which type of element is not on the Periodic Table?")
  question11.addOption("Solid", false)
  question11.addOption("Liquid", false)
  question11.addOption("Gas", false)
  question11.addOption("Plasma", true)

  val question12 = new Question("Are there man-made elements on the Periodic Table?")
  question12.addOption("Yes", true)
  question12.addOption("No", false)

  val question13 = new Question("Which two elements are liquids at room temp?")
  question13.addOption("Mercury", true)
  question13.addOption("Bromine", true)
  question13.addOption("Iron", false)
  question13.addOption("Zinc", false)
  question13.addOption("Tin", false)

  val question14 = new Question("As you go down and left what characteristics increase?")
  question14.addOption("Atomic Radius", true)
  question14.addOption("Atomic Mass", false)

  val question15 = new Question("As you go down and right what characteristics increase?")
  question15.addOption("Ionization", true)
  question15.addOption("Limiting Reaction", false)
  question15.addOption("Valence Electrons", false)

  val questions = Array(question1, question2, question3, question4, question5, question6, question7, question8, question9, question10, question11, question12, question13, question14, question15)

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
        ChemGame.d = false
        ChemGame.mainSelect = true
        randomQ = RandomGen.gen(questions)
        join()
      }}.start()
    }
  }
}
