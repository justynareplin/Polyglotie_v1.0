package com.example.polyglotie.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.polyglotie.R
import com.example.polyglotie.utils.Constants

class QuizActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R .layout.activity_quiz)

        val questionsList = Constants.getQuestions()
        Log.i("Questions Size", "${questionsList.size}")

    }
}