package com.example.numbergame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    // To keep track the score of the user
    private var points = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // helper function to pick 2 random numbers and display them
        pickRandomNumber()
    }

    fun lessThanButton(view: View) {
        checkCorrectness("left")
    }
    fun greaterThanButton(view: View) {
        checkCorrectness("right")
    }
    fun equalButton(view: View) {
        checkCorrectness("equal")
    }

    private fun checkCorrectness(correct: String){
        val message:String?
        val num1 = random_number1.text.toString().toInt()
        val num2 = random_number2.text.toString().toInt()

        // If the answer is correct, increment the score else decrement by 1
        if( (num1 < num2) && correct == "left"){
            points++
            message = "Correct!"
        }
        else if(num1 > num2 && correct == "right"){
            points++
            message = "Correct!"
        }
        else if(num1 == num2 && correct == "equal"){
            points++
            message = "Correct!"
        }
        else{
            points--
            message = "Wrong!!!"
        }

        // Show a toast message as a feedback about whether the answer is correct or not
        Toast.makeText(this, "$message", Toast.LENGTH_SHORT).show()
        score.text = "Score: $points"

        // call the helper function again to set new random numbers
        pickRandomNumber()
    }

    // picks 2 random numbers and display them
    private fun pickRandomNumber(){
        // Generate random numbers
        val randomNumber1 = Random().nextInt(10)
        val randomNumber2 = Random().nextInt(10)

        // Set the random numbers to the textviews
        random_number1.text = "$randomNumber1"
        random_number2.text = "$randomNumber2"
    }
}