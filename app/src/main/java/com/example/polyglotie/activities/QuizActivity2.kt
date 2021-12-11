package com.example.polyglotie.activities

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.widget.*
import androidx.core.content.ContextCompat
import com.example.polyglotie.R
import com.example.polyglotie.utils.DeckData
import com.example.polyglotie.utils.Questions
import com.example.polyglotie.utils.Favourites

class QuizActivity2 : BaseQuizActivities() {
    private var gQuestionsList: ArrayList<Question>? = null //global question list
    private var mSelectedOptionPosition: Int = 0
    private lateinit var mBasicWordSet: HashMap<String, String>

    var questionCurrentPosition = 0
    var btnFavouriteClicks = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz2)

        val btnAnswer1: Button = findViewById(R.id.btnAnswer1)
        val btnAnswer2: Button = findViewById(R.id.btnAnswer2)
        val btnAnswer3: Button = findViewById(R.id.btnAnswer3)
        val btnAnswer4: Button = findViewById(R.id.btnAnswer4)
        val btnSubmit: Button = findViewById(R.id.btnSubmit)
        val btnFavourites: ImageButton = findViewById(R.id.favourite_button)
        val backBtn: ImageButton = findViewById(R.id.backBtn)

        val textViewQuestion: TextView = findViewById(R.id.textViewQuestion)

        val tvDeckTitle: TextView = findViewById(R.id.deck_title)
        val tWordsQuantity: TextView = findViewById(R.id.deck_words_quantity)
        val tvRating: TextView = findViewById(R.id.tv_rating)
        val tvYourLevel: TextView = findViewById(R.id.tv_your_level)

        gQuestionsList = Questions.getQuestions()
        mBasicWordSet = DeckData.getBasicWords()
        fun setQuestions() {
            val question = gQuestionsList!![questionCurrentPosition]
            textViewQuestion.text = question.question
            btnAnswer1.text = question.optionOne
            btnAnswer2.text = question.optionTwo
            btnAnswer3.text = question.optionThree
            btnAnswer4.text = question.optionFour
        }

        setDeckDetails(tvDeckTitle, tWordsQuantity, tvRating, tvYourLevel)
        // setQuestion(textViewQuestion, gQuestionsList!!, questionCurrentPosition)

        fun setDefaultButtonView() {
            val options = ArrayList<Button>()
            options.add(btnAnswer1)
            options.add(btnAnswer2)
            options.add(btnAnswer3)
            options.add(btnAnswer4)
            btnSubmit.text = "Submit"            //Set text on submit button

            for (option in options) {
                //   option.setTextColor(Color.parseColor())
                option.typeface = Typeface.DEFAULT
                option.setTextColor(Color.parseColor("#6C6C6C")) // Set grey text color on buttons
                option.isClickable = true
                option.background = ContextCompat.getDrawable(
                    this, R.drawable.option_border
                )
            }
        }

        fun selectedOptionView(btn: Button, selectedAnswerNum: Int) {
            setDefaultButtonView()
            mSelectedOptionPosition = selectedAnswerNum

            btn.setTextColor(Color.parseColor("#3a4bbd")) // Set blue color on selected answer button
            // btn.setBackgroundColor(Color.GREEN)
            println("selected option $mSelectedOptionPosition")
            /*  btn.background = ContextCompat.getDrawable(this,
                  R.drawable.selected_option_border)*/
        }

        setQuestions()
        setDefaultButtonView()
        btnAnswer1.setOnClickListener {
            selectedOptionView(btnAnswer1, 1)
        }
        btnAnswer2.setOnClickListener {
            selectedOptionView(btnAnswer2, 2)
        }
        btnAnswer3.setOnClickListener {
            selectedOptionView(btnAnswer3, 3)
        }
        btnAnswer4.setOnClickListener {
            selectedOptionView(btnAnswer4, 4)
        }

        btnFavourites.setOnClickListener {
            btnFavouriteClicks++
            if (btnFavouriteClicks == 1) {
                /*   val question = gQuestionsList!![questionCurrentPosition]
                   val questionEnglish = question.question
                   val questionPolish = question.answer.toString()
                   Favourites.favouriteWords.put(questionEnglish, questionPolish)*/

                favouriteButtonClicked(btnFavourites)
            } else if (btnFavouriteClicks == 2) {
                btnFavouriteClicks = 0
                favouriteButtonClickedTwice(btnFavourites)
            }
        }

        backBtn.setOnClickListener {
            setBackBtn(backBtn)
        }
        /*
                println("bleep")
                for ((key, value) in Favourites.favouriteWords) {
                    println("$key= $value")
                }
        */
        fun wrongAnswer(correctAnswer: Int, mSelectedOptionPosition: Int) {
            when (correctAnswer) {
                1 -> btnAnswer1.setTextColor(Color.GREEN)
                2 -> btnAnswer2.setTextColor(Color.GREEN)
                3 -> btnAnswer3.setTextColor(Color.GREEN)
                4 -> btnAnswer4.setTextColor(Color.GREEN)
            }
            when (mSelectedOptionPosition) {
                1 -> btnAnswer1.setTextColor(Color.RED)
                2 -> btnAnswer2.setTextColor(Color.RED)
                3 -> btnAnswer3.setTextColor(Color.RED)
                4 -> btnAnswer4.setTextColor(Color.RED)
            }
        }

        fun correctAnswer(currentPosition: Int) {
            when (currentPosition) {
                1 -> btnAnswer1.setTextColor(Color.GREEN)
                2 -> btnAnswer2.setTextColor(Color.GREEN)
                3 -> btnAnswer3.setTextColor(Color.GREEN)
                4 -> btnAnswer4.setTextColor(Color.GREEN)
            }
        }

        btnSubmit.setOnClickListener {
            if (mSelectedOptionPosition == 0) {                        //If user didn't choose any answer yet
                questionCurrentPosition++
                if (questionCurrentPosition <= gQuestionsList!!.size) {
                    setQuestions()
                    setDefaultButtonView()
                } else Toast.makeText(
                    this,
                    "You have finished! Great work!", Toast.LENGTH_LONG
                ).show()

            } else {
                btnAnswer1.isClickable = false
                btnAnswer2.isClickable = false
                btnAnswer3.isClickable = false
                btnAnswer4.isClickable = false
                //After user has chose answer
                val question = gQuestionsList!!.get(questionCurrentPosition)
                if (question.answer != mSelectedOptionPosition) {   //If answer is wrong
                    wrongAnswer(question.answer, mSelectedOptionPosition)
                } else if (question.answer == mSelectedOptionPosition) {    //If answer is correct
                    correctAnswer(mSelectedOptionPosition)

                }
            }
            if (questionCurrentPosition == gQuestionsList!!.size) {   // Change button text after click
                btnSubmit.text = "Finish"
            } else {
                btnSubmit.text = "Next question"
                mSelectedOptionPosition = 0
            }                           //Setting current position to zero, so program can set another questions
        }

    }

}