package com.example.polyglotie.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.polyglotie.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnQuiz : Button = findViewById(R.id.btnQuiz)

        btnQuiz.setOnClickListener {
            val Intent = Intent(this, QuizActivity::class.java)
            startActivity(Intent)
            finish()
        }
    }
}