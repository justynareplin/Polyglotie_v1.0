package com.example.polyglotie.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import com.example.polyglotie.R

class NavbarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navbar)
        var my_toolbar = findViewById<View>(R.id.my_toolbar)
        setSupportActionBar(my_toolbar as Toolbar?)

    }
}