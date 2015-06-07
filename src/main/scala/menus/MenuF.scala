package menus

import core.{Question, ChemGame, RandomGen}
import player.Player

/**
 * Created by mnenmenth on 5/28/15.
 */
object MenuF {

  val question1 = new
      Question("How to get Celsius to Fahrenheit")
  question1.addOption("Multiply by 1.8 then add 32", true)
  question1.addOption("Divide by 4.7 then add 143", false)
  val question2 = new
      Question("What is the conversion factor for Kilograms to Pounds?")
  question2.addOption("Multiply by 2.2", true)
  question2.addOption("Divided by 9.3", false)
  question2.addOption("Multiply by 3.8", false)
  val question3 = new
      Question("How can you get gallons if you are given liters?")
  question3.addOption("Multiply by 3.79", true)
  question3.addOption("Multiply by 2.9", false)
  question3.addOption("Divide by 7.93", false)
  val question4 = new
      Question("How many liters are in deciliter?")
  question4.addOption("0.1", true)
  question4.addOption("0.63", false)
  question4.addOption("0.854", false)
  val question5 = new
      Question("What's the conversion factor for centigrams to hectograms?")
  question5.addOption("0.0001", true)
  question5.addOption("0.73549", false)
  question5.addOption("0.93", false)
  val question6 = new
      Question("What is the first step in scientific method?")
  question6.addOption("Ask a question", true)
  question6.addOption("Making inferences", false)
  val question7 = new
      Question("What comes after constructing a hypothesis?")
  question7.addOption("Test the hypothesis", true)
  question7.addOption("Ask a question", false)
  question7.addOption("Make an inferences", false)
  val question8 = new
      Question("What is the final step in the scientific method?")
  question8.addOption("Report your results", true)
  question8.addOption("Make inferences", false)
  val question9 = new
      Question("How many steps are in the scientific method if you complete all steps the first time?")
  question9.addOption("6 steps", true)
  question9.addOption("9 steps", false)
  question9.addOption("13 steps", false)
  val question10 = new
      Question("Why is scientific notation important for experiments?")
  question10.addOption("It makes it easy to comprehend extremely large numbers easily", true)
  question10.addOption("It makes it harder to read numbers", false)
  question10.addOption("It makes it easy to make calculations", false)
  val question11 = new
      Question("What is 10,100 in scientific notation?")
  question11.addOption("10.1 x 10^3", true)
  question11.addOption("10.8 x 10^8", false)
  val question12 = new
      Question("What is 10,000,000,000 in scientific notation?")
  question12.addOption("10 x 10^9", true)
  question12.addOption("10 x 10^10", false)
  val question13 = new
      Question("What is 0.0000000001 in scientific notation?")
  question13.addOption("1 x 10^-10", true)
  question13.addOption("1 x 10^-13", false)
  val question14 = new
      Question("What is Avogadro's number in scientific notation?")
  question14.addOption("6.02 x 10^23", true)
  question14.addOption("6.3 x 10^19", false)
  val question15 = new
      Question("What is 6.02 in standard form?")
  question15.addOption("60,2000,000,000,000,000,000,000", true)
  question15.addOption("6,020", false)
  question15.addOption("60,200,000,000,000,000", false)
  val question16 = new
      Question("What is standard pressure in kPa?")
  question16.addOption("101.3", true)
  question16.addOption("93.86", false)
  question16.addOption("48.4", false)
  val question17 = new
      Question("What standard pressure in psi?")
  question14.addOption("14.7", true)
  question14.addOption("34.9", false)
  question14.addOption("19.3", false)
  val question18 = new
      Question("What is standard pressure in mm Hg?")
  question14.addOption("760", true)
  question14.addOption("930", false)
  question14.addOption("813", false)
  val question19 = new
      Question("How do you convert Celsius to Kelvin?")
  question19.addOption("Add 273.15", true)
  question19.addOption("Subtract 394.25", false)
  val question20 = new
      Question("What is the formula to calculate pressure?")
  question20.addOption("Force/Area", true)
  question20.addOption("Pressure/Volume", false)
  val question21 = new
      Question("What does temperature measure?")
  question21.addOption("Average kinetic energy", true)
  question21.addOption("Atomic radius", false)
  val question22 = new
      Question("Molecules in an ideal gas move in what type of motion?")
  question22.addOption("Constant, random, straight-line motion", true)
  question22.addOption("Non-contact, straight, round motion", false)
  val question23 = new
      Question("What is the equation for the ideal gas law?")
  question23.addOption("PV=nRT", true)
  question23.addOption("P1/V1=P2/V2", false)
  val question24 = new
      Question("How many gas laws have we learned about?")
  question24.addOption("7", true)
  question24.addOption("6", false)
  val question25 = new
      Question("To what does Boyle's law relate?")
  question25.addOption("Pressure", true)
  question25.addOption("Volume", true)
  question25.addOption("Temperature", false)
  val question26 = new
      Question("To what does Charles' law relate?")
  question26.addOption("Volume", true)
  question26.addOption("Temperature", true)
  question26.addOption("Pressure", false)
  val question27 = new
      Question("To what does Gay-Lussac's law relate?")
  question27.addOption("Pressure", true)
  question27.addOption("Temperature", true)
  question27.addOption("Volume", false)
  val question28 = new
      Question("When does the Kinetic Molecular Theory (KMT) fail?")
  question28.addOption("High or low pressures", true)
  question28.addOption("Low volumes", false)

  val questions = Array(question1, question2, question3, question4, question5, question6, question7, question8, question9, question10, question11, question12, question13, question14, question15,
  question16, question17, question18, question19, question20, question21, question22, question23, question24, question25, question26, question27, question28)

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
        ChemGame.f = false
        ChemGame.mainSelect = true
        randomQ = RandomGen.gen(questions)
        join()
      }}.start()
    }
  }
}
