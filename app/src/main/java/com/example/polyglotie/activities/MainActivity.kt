package com.example.polyglotie.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.polyglotie.R
import com.example.polyglotie.fragments.HomeFragment
import com.example.polyglotie.fragments.LearnFragment
import com.example.polyglotie.fragments.Profile
import com.example.polyglotie.fragments.StatsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnQuiz : Button = findViewById(R.id.btnQuiz)
        val btnFlashCards: Button=findViewById(R.id.btnFlashCards)
        val btnInsertWord: Button=findViewById(R.id.btnInsertWord)

        /*Set fragments values */
        val homeFragment = HomeFragment()
        val learnFragment= LearnFragment()
        val statsFragment = StatsFragment()
        val profileFragment = Profile()

        val bottomNavigationView  = findViewById<BottomNavigationView >(R.id.bottom_navigation)
        val navController= findNavController(R.id.flFragment)

        bottomNavigationView.setupWithNavController(navController)

        /*
        navigationView.setOnClickListener {
            println("item menuuuuuuuuuuuuuuu")}

        btnFlashCards.setOnClickListener{ supportFragmentManager.beginTransaction().apply{
            replace(R.id.flFragment, homeFragment)

            commit()
            println("Home fragment")
        }
        }

        btnInsertWord.setOnClickListener{ supportFragmentManager.beginTransaction().apply{
            replace(R.id.flFragment, learnFragment)

            commit()
            println("Home fragment")
        }
        }

        //Initialize the bottom navigation view
        //create bottom navigation view object
        val bottomNavigationView = findViewById<BottomNavigationView
                >(R.id.bottom_navigation)
        val navController = findNavController(R.id.flFragment)
        bottomNavigationView.setupWithNavController(navController
        )

        btnQuiz.setOnClickListener {
            val Intent = Intent(this, QuizActivity2::class.java)
            startActivity(Intent)
            finish()
        }*/
    }
}