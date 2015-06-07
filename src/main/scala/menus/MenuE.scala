package menus

import core.{Question, ChemGame, RandomGen}
import player.Player

/**
 * Created by mnenmenth on 5/28/15.
 */
object MenuE {

  val question1 = new Question("2g Hydrogen Gas = _g Water: 2H2+O2=2H20")
  question1.addOption("9g Water", true)
  question1.addOption("56g Oxygen", false)
  question1.addOption("27g Hydrogen", false)

  val question2 = new Question("Hydrogen + 4g Water = _g Water?")
  question2.addOption("4.5g", true)
  question2.addOption("6.7g", false)
  question2.addOption("2.9g", false)

  val question3 = new Question("_g Carbon + 12g Oxygen = Carbon Dioxide")
  question3.addOption("9g", true)
  question3.addOption("17g", false)
  question3.addOption("57g", false)

  val question4 = new Question("_g Fe203 Needed to React with 8g Al")
  question4.addOption("24.57g", true)
  question4.addOption("73g", false)
  question4.addOption("13", false)

  val question5 = new Question("_g Sulfur Needed to react with 8g Cu(III)")
  question5.addOption("12.1g", true)
  question5.addOption("39.5g", false)
  question5.addOption("82.5g", false)

  val question6 = new Question("Given .5 mol Calcium Nitrate you need _ mol Sodium Hydroxide?")
  question6.addOption("1 mole", true)
  question6.addOption("23 moles", false)
  question6.addOption("29.7 moles", false)

  val question7 = new Question("Given .25 mol Sodium Hydroxide, how much Calcium Hydroxide is produced")
  question7.addOption(".125 moles", true)
  question7.addOption("4.6743 moles", false)
  question7.addOption("8.839 moles", false)

  val question8 = new Question("Given 10g of O2, How do you find its equivalent in moles?")
  question8.addOption("Divide by 32", true)
  question8.addOption("Multiply by 34", false)
  question8.addOption("Divde by 23", false)

  val question9 = new Question("How do you convert moles to grams")
  question9.addOption("Multiply by Molar Mass", true)
  question9.addOption("Multiply by Molarity", false)
  question9.addOption("Divide by Grams", false)

  val question10 = new Question("How do you convert moles to liters")
  question10.addOption("Divide by Molarity", true)
  question10.addOption("Multiply by Grams", false)
  question10.addOption("Multiply by Molar Mass", false)

  val question11 = new Question("What is the Mole Conversion Rotatio")
  question11.addOption("Known/Unknown", true)
  question11.addOption("Unknown/Known", false)

  val question12 = new Question("Solve .5 Al * 1 mole Al2S3 / 2 mole Al")
  question12.addOption(".25 mol Al2S3", true)
  question12.addOption(".73 mol Al2S3", false)

  val question13 = new Question("Limiting Reactant of 2Al+3S=Al2S3")
  question13.addOption("Al2S3", true)
  question13.addOption("2Al", false)
  question13.addOption("3S", false)

  val question14 = new Question("Solve 1.7 mol C2H5OH* 2 mol CO2 / 1 mol C2H5OH")
  question14.addOption("3.4 mol CO2", true)
  question14.addOption("4.9 mol CO2", false)
  question14.addOption("9.3 mol Co2", false)

  val question15 = new Question("How many moles are in 15 grams of Li?")
  question15.addOption("2.16 moles", true)
  question15.addOption("5.48 moles", false)
  question15.addOption("7.23 moles", false)

  val question16 = new Question("How many grams are in 2.4 moles of Sulfur?")
  question16.addOption("76.8 grams", true)
  question16.addOption("74.9 grams", false)
  question16.addOption("23.85 grams", false)

  val question17 = new Question("How many moles are in 22 grams of Argon?")
  question17.addOption(".55 moles", true)
  question17.addOption(".67 moles", false)
  question17.addOption(".89 moles", false)

  val question18 = new Question("How many grams are in 88.1 moles of Mg?")
  question18.addOption("2,114.4 grams", true)
  question18.addOption("7,938 grams", false)
  question18.addOption("9.327.837 grams", false)

  val question19 = new Question("How many atoms are there in 4.5 moles of Na?")
  question19.addOption("2.71*10^24", true)
  question19.addOption("5.93*10^54", false)
  question19.addOption("38.34*10^12", false)
  question19.addOption("63.92*10^6", false)

  val question20 = new Question("How many moles are there in 7.5*1023 atoms of S?")
  question20.addOption("1.25 atoms", true)
  question20.addOption("3.453 atoms", false)
  question20.addOption("9.432 atoms", false)

  val question21 = new Question("How many moles are in 2.3 grams of Phosphorus?")
  question21.addOption(".07 moles", true)
  question21.addOption(".938 moles", false)
  question21.addOption(".63749 moles", false)

  val question22 = new Question("Al + 2 -> Al2S3")
  question22.addOption("2Al + 3S -> Al2S3", true)
  question22.addOption("9Al + 5S -> 3Al4S", false)

  val questions = Array(question1, question2, question3, question4, question5, question6, question7, question8, question9, question10, question11, question12, question13, question14, question15,
  question16, question17, question18, question19, question20, question21, question22)

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
        ChemGame.e = false
        ChemGame.mainSelect = true
        randomQ = RandomGen.gen(questions)
        join()
      }}.start()
    }
  }
}
