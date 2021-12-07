package com.example.polyglotie.firebase

import android.app.Activity
import android.content.ContentValues.TAG
import android.util.Log
import com.example.polyglotie.activities.LoginActivity
import com.example.polyglotie.activities.MainActivity
import com.example.polyglotie.activities.ProfileActivity
import com.example.polyglotie.activities.RegistrationActivity
import com.example.polyglotie.models.User
import com.example.polyglotie.utils.Constants
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.SetOptions
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase

class FirestoreClass {

    private val mFireStore = FirebaseFirestore.getInstance()
    val db = Firebase.firestore
    val user = Firebase.auth.currentUser


    fun registerUser(activity: RegistrationActivity, userInfo: com.example.polyglotie.models.User) {

        mFireStore.collection(Constants.USERS)
            .document(getCurrentUserId())
            .set(userInfo, SetOptions.merge())
            .addOnSuccessListener {
                activity.userRegisteredSuccess()
            }.addOnFailureListener { e ->
                Log.e(activity.javaClass.simpleName, "Error occured")
            }
    }

    fun signInUser(activity: Activity) {
        println("test")
        mFireStore.collection(Constants.USERS)
            .document(getCurrentUserId())
            .get()
            .addOnSuccessListener { document ->
                val loggedInUser =
                    document.toObject(User::class.java) //val that stores log in user, document gets us this info

                when (activity) {
                    is LoginActivity -> {
                        if (loggedInUser != null) {
                            activity.signInSuccess(loggedInUser)
                            println("signInuser")
                        }
                    }
                    is ProfileActivity -> {
                        if (loggedInUser != null) {
                            activity.updateUserDetails(loggedInUser)
                        }
                    }
                }
            }.addOnFailureListener { e ->
                Log.e(activity.javaClass.simpleName, "Error occured")
            }
    }

    fun getCurrentUserId(): String {
        var currentUser = FirebaseAuth.getInstance().currentUser
        var currentUserID = ""
        if (currentUser != null) {
            currentUserID = currentUser.uid
        }
        return currentUserID
    }
}