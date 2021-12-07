package com.example.polyglotie.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.polyglotie.R
import com.example.polyglotie.models.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class ProfileActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var databaseReference: DatabaseReference
    private val db = Firebase.firestore

    override fun onCreate(savedInstanceState: Bundle?) {



        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)



        val tv_username: TextView = findViewById(R.id.tv_username)
        val tv_email: TextView = findViewById(R.id.tv_email)
        val btnLogOut: Button = findViewById(R.id.btnLogOut)

        var ref = FirebaseDatabase.getInstance().getReference("Users").child(
            FirebaseAuth.getInstance().currentUser!!.uid
        )

        auth = FirebaseAuth.getInstance()

        val uid = auth.currentUser?.uid
        val email = auth.currentUser?.email
        val name = auth.currentUser?.displayName
        val user = Firebase.auth.currentUser

        if (user != null) {
            tv_username.text = uid.toString()
            tv_email.text = email
        }

        btnLogOut.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            val intent = Intent(this, StartActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
            finish()
        }
    }

    fun updateUserDetails(loggedInUser: User) {

        val userCircleImage: ImageView = findViewById(R.id.user_circle_image)

        Glide
            .with(this)
            .load(loggedInUser.image)
            .centerCrop()
            //    .placeholder(R.drawable.ic_user_place_holder)
            .into(userCircleImage)
    }
}