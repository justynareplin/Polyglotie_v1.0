package com.example.polyglotie.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.polyglotie.R
import com.example.polyglotie.firebase.FirestoreClass

class StartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        val startBtn : Button = findViewById<Button>(R.id.startButton)
        var currentUserID = FirestoreClass().getCurrentUserId()

        if(currentUserID.isNotEmpty()){
            val intent= Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        startBtn.setOnClickListener {

            val intent= Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()

        }
    }
}