package com.example.polyglotie.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.example.polyglotie.R
import com.example.polyglotie.utils.Constants

class QuizActivity : AppCompatActivity() {

    private var mSelectedOptionPosition: Int = 0
    private var mQuestionsList: ArrayList<Question>?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R .layout.activity_quiz)
        setQuestions()
    }

    fun setQuestions(){
        val textViewQuestion :TextView = findViewById(R.id.textViewQuestion)
        val textViewAnswer1 :TextView = findViewById(R.id.textViewAnswer1)
        val textViewAnswer2 :TextView = findViewById(R.id.textViewAnswer2)
        val textViewAnswer3 :TextView = findViewById(R.id.textViewAnswer3)
        val textViewAnswer4 :TextView = findViewById(R.id.textViewAnswer4)

        val questionsList= Constants.getQuestions()
        val currentPosition = 1
        val question: Question?= questionsList[currentPosition -1]
        textViewQuestion.text = question!!.question
        textViewAnswer1.text = question.optionOne
        textViewAnswer2.text = question.optionTwo
        textViewAnswer3.text = question.optionThree
        textViewAnswer4.text = question.optionFour
    }

    
}