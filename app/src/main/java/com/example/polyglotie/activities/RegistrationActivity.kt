package com.example.polyglotie.activities

import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import com.example.polyglotie.R
import com.example.polyglotie.firebase.FirestoreClass
import com.example.polyglotie.models.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class RegistrationActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        /* EditTexts values*/
        val editTextName :EditText = findViewById(R.id.editTextName)
        val editTextEmail : EditText = findViewById(R.id.editTextEmail)
        val registerPassword: EditText = findViewById(R.id.registerPassword)
        val registerPassword2: EditText = findViewById(R.id.registerPassword2)

        /* Buttons values*/
        val backBtn : ImageButton = findViewById<ImageButton>(R.id.backBtn)
        val registrationButton : Button = findViewById(R.id.registrationBtn)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        fun registerUser(){
            showProgressDialog(resources.getString(R.string.please_wait))
            val name: String = editTextName.text.toString().trim { it <= ' '}
            val email : String = editTextEmail.text.toString().trim{ it <= ' '}
            val registerPassword = registerPassword.text.toString()
            FirebaseAuth.getInstance()
                .createUserWithEmailAndPassword(email, registerPassword).addOnCompleteListener(
                    {   task ->
                        hideProgressDialog()
                        if(task.isSuccessful){
                            val firebaseUser : FirebaseUser = task.result!!.user!!
                            val registeredEmail = firebaseUser.email!!
                            val user = User(firebaseUser.uid, name, registeredEmail)
                            FirestoreClass().registerUser(this, user)
                        }else{
                            Toast.makeText(this,
                                "Registration failed", Toast.LENGTH_SHORT).show()
                        }
                    }
                )
        }

        /*Btn events*/
        backBtn.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

        registrationButton.setOnClickListener {
            if(editTextName.text.isEmpty()){
                Toast.makeText(this, "Plaese enter your name ", Toast.LENGTH_LONG).show()
            }
            else if(editTextEmail.text.isEmpty()){
                Toast.makeText(this, "Plaese enter your email",Toast.LENGTH_LONG).show()
            }
            registerUser()
        }
    }

    fun userRegisteredSuccess() {
        Toast.makeText(this,
            "You have been succesfully registered!", Toast.LENGTH_LONG).show()
        FirebaseAuth.getInstance().signOut()
        finish()
    }
}