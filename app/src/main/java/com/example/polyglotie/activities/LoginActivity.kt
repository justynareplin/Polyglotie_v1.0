package com.example.polyglotie.activities

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.polyglotie.R
import com.example.polyglotie.models.User
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : BaseActivity() {

    lateinit var  auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_form)

        auth = FirebaseAuth.getInstance()

        val redirectToRegisterButton : Button = findViewById(R.id.redirectToRegisterButton)
        val loginButton :  Button = findViewById(R.id.loginButton)
        val editTextSignInEmail : EditText= findViewById(R.id.editTextSignInEmail)
        val editTextTextPassword : EditText= findViewById(R.id.editTextTextPassword)

        redirectToRegisterButton.setOnClickListener {
            val intent= Intent(this, RegistrationActivity::class.java)
            startActivity(intent)
            finish()
        }

        loginButton.setOnClickListener {
            if(editTextSignInEmail.text.isEmpty()){
                Toast.makeText(this,
                    "Please eneter your email", Toast.LENGTH_LONG).show()
            }
            else if(editTextTextPassword.text.isEmpty()){
                Toast.makeText(this,
                    "Please eneter your password", Toast.LENGTH_LONG).show()
            }

                showProgressDialog(resources.getString(R.string.please_wait))
                val email: String = editTextSignInEmail.text.toString().trim{it <= ' '}
                val password= editTextTextPassword.text.toString().trim{it <= ' '}
                auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this) { task ->
                        hideProgressDialog()
                        if (task.isSuccessful) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success")
                            val user = auth.currentUser
                            startActivity(Intent(this, StartActivity::class.java))
                            // updateUI(user)
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.exception)
                            Toast.makeText(baseContext, "Authentication failed.",
                                Toast.LENGTH_SHORT).show()
                            //  updateUI(null)
                        }
                    }

        }

    }

    fun signInSuccess(user: User) {
        startActivity(Intent(this, MainActivity::class.java))
        finish()

    }
}