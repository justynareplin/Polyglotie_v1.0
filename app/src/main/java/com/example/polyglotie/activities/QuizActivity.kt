package com.example.polyglotie.activities

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.polyglotie.R
import com.example.polyglotie.utils.Constants

class QuizActivity : AppCompatActivity(){ // View.OnClickListener

    private var mSelectedOptionPosition: Int = 0
    private var mQuestionsList: ArrayList<Question>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        val textViewQuestion: TextView = findViewById(R.id.textViewQuestion)
        val textViewAnswer1: TextView = findViewById(R.id.textViewAnswer1)
        val textViewAnswer2: TextView = findViewById(R.id.textViewAnswer2)
        val textViewAnswer3: TextView = findViewById(R.id.textViewAnswer3)
        val textViewAnswer4: TextView = findViewById(R.id.textViewAnswer4)
/*
        textViewAnswer1.setOnClickListener(this)
        textViewAnswer2.setOnClickListener(this)
        textViewAnswer3.setOnClickListener(this)
        textViewAnswer4.setOnClickListener(this)
*/
        mQuestionsList = Constants.getQuestions()
        //setQuestions()

        fun setQuestions() {
            val mCurrentPosition = 1
            val question = mQuestionsList!![mCurrentPosition - 1]
            textViewQuestion.text = question.question
            textViewAnswer1.text = question.optionOne
            textViewAnswer2.text = question.optionTwo
            textViewAnswer3.text = question.optionThree
            textViewAnswer4.text = question.optionFour
        }

        fun defaultOptionView(){
            val options = ArrayList<TextView>()
            options.add(textViewAnswer1)
            options.add(textViewAnswer2)
            options.add(textViewAnswer3)
            options.add(textViewAnswer4)

            for(option in options ){
             //   option.setTextColor(Color.parseColor())
                option.typeface = Typeface.DEFAULT
                option.background = ContextCompat.getDrawable(
                    this, R.drawable.option_border)
            }
        }

        fun selectedOptionView(textView: TextView, selectedAnswerNum: Int){
            defaultOptionView()
            mSelectedOptionPosition = selectedAnswerNum

            textView.setTextColor(Color.parseColor("#212121"))
            textView.setTypeface(textView.typeface, Typeface.BOLD)
            textView.background = ContextCompat.getDrawable(this,
                R.drawable.selected_option_border)
        }
    }
/*
    override fun onClick(v: View?) {
        when(v?.id){
            R.id.textViewAnswer1 ->{
                selectedOptionView(c)
            }
        }
    }*/
}