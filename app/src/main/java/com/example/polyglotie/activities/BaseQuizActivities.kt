package com.example.polyglotie.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import com.example.polyglotie.R

open class BaseQuizActivities : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base_quiz_activities)
    }

    fun favouriteButtonClicked(btn: ImageButton) {
        btn.setImageResource(R.drawable.ic_baseline_favorite)
        /* TODO: Adding words object to Favourites list */

    }

    fun favouriteButtonClickedTwice(btn: ImageButton) {
        /* TODO: Remove words object from Favourites list */
        btn.setImageResource(R.drawable.ic_baseline_favorite_border)
    }

    fun setDeckDetails(
        tvTitle: TextView,
        tvWordsQuantity: TextView,
        tvUserRating: TextView,
        tvYourLevel: TextView
    ) {
        tvTitle.setText("School")
        tvWordsQuantity.setText("20 words")
        tvUserRating.setText("1")
        tvYourLevel.setText("Your level is:")

    }

    fun setBackBtn(btnBack: ImageButton) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    fun setQuestion(
        tvQuestion: TextView,
        questionsList: ArrayList<Question>,
        currentQuestionPosition: Int
    ) { val questionCurrent =questionsList[currentQuestionPosition]
        tvQuestion.setText("$questionCurrent eeeee")
    }

}