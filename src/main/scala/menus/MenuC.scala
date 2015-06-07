package menus

import core.{Question, ChemGame, RandomGen}
import player.Player

/**
 * Created by mnenmenth on 5/28/15.
 */
object MenuC {

  val question1 = new Question("What part of an atom is equivalent to the electrons?")
  question1.addOption("Protons", true)
  question1.addOption("Electrons", false)
  question1.addOption("Charge", false)

  val question2 = new Question("The atomic number of an atom is the same as what?")
  question2.addOption("Protons", true)
  question2.addOption("Electrons", false)
  question2.addOption("Charge", false)

  val question3 = new Question("Atomic Mass - Atomic Number = ?")
  question3.addOption("Electrons", true)
  question3.addOption("Protons", false)
  question3.addOption("Neutrons", false)

  val question4 = new Question("How many Protons, Neutrons, and Electrons does Ocygen have?")
  question4.addOption("17,17,18", true)
  question4.addOption("17,18,17", false)
  question4.addOption("19, 23, 12", false)

  val question5 = new Question("The charge of a proton is: ")
  question5.addOption("Positive", true)
  question5.addOption("Neutral", false)
  question5.addOption("Negative", false)

  val question6 = new Question("The charge of a neutron is: ")
  question6.addOption("Neutral", true)
  question6.addOption("Positive", false)
  question6.addOption("Negative", false)

  val question7 = new Question("The charge of an electron is: ")
  question7.addOption("Negative", true)
  question7.addOption("Positive", false)
  question7.addOption("Neutral", false)

  val question8 = new Question("Which is less: 4s or 3d?")
  question8.addOption("4s", true)
  question8.addOption("3d", false)

  val question9 = new Question("If Lithium has 3 electrons, which orbital does it go to?")
  question9.addOption("2s", true)
  question9.addOption("4p", false)
  question9.addOption("3d", false)

  val question10 = new Question("If sodium has 11 electrons, which orbital does it go to?")
  question10.addOption("3s", true)
  question10.addOption("6s", false)
  question10.addOption("2p", false)

  val question11 = new Question("Is the # of valence electrons easily found?")
  question11.addOption("Yes", true)
  question11.addOption("No", false)

  val question12 = new Question("What is Thomson's Atomic Model also known as?")
  question12.addOption("Plum Pudding", true)
  question12.addOption("Molecular Theory", false)
  question12.addOption("Chem-is-try", true)

  val question13 = new Question("What was Rutherford's model an example of?")
  question13.addOption("Planetary", true)
  question13.addOption("Dimensionless", false)

  val question14 = new Question("What colors usually represent Protons, Neutrons, and Electrons?")
  question14.addOption("Blue, Red, Green", true)
  question14.addOption("Red, Green, Blue", false)
  question14.addOption("Blue, Brown, Yellow", false)

  val question15 = new Question("What is another name for Rutherford's Atom?")
  question15.addOption("Nuclear atom", true)
  question15.addOption("Nuclear Center", false)
  question15.addOption("Middle of the atom", false)

  val questions = Array(question1, question2, question3, question4, question5, question6, question7, question8, question9, question10,
  question11, question12, question13, question14, question15)

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
        ChemGame.c = false
        ChemGame.mainSelect = true
        randomQ = RandomGen.gen(questions)
        join()
      }}.start()
    }

  }
}
