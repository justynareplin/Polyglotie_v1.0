package com.example.polyglotie.firebase

import android.util.Log
import com.example.polyglotie.activities.LoginActivity
import com.example.polyglotie.activities.RegistrationActivity
import com.example.polyglotie.models.User
import com.example.polyglotie.utils.Constants
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.SetOptions
import com.google.firebase.firestore.ktx.toObject

class FirestoreClass {
    private val mFireStore = FirebaseFirestore.getInstance()


    /* tu w user mozebyc blad*/
    fun registerUser(activity: RegistrationActivity, userInfo: com.example.polyglotie.models.User){
        mFireStore.collection(Constants.USERS)
            .document(getCurrentUserId())
            .set(userInfo, SetOptions.merge())
            .addOnSuccessListener {
                activity.userRegisteredSuccess()
            }.addOnFailureListener{
                e->
                Log.e(activity.javaClass.simpleName, "Error occured")
             }
    }
    fun signInUser(activity: LoginActivity, userInfo: com.example.polyglotie.models.User){
        mFireStore.collection(Constants.USERS)
            .document(getCurrentUserId())
            .get()
            .addOnSuccessListener { document ->
                val loggedInUser = document.toObject(User::class.java)//val that stores log in user, document gets us this info
                if (loggedInUser != null) {
                    activity.signInSuccess(loggedInUser)
                }
            }.addOnFailureListener{
                    e->
                Log.e(activity.javaClass.simpleName, "Error occured")
            }
    }

    fun getCurrentUserId() : String{

        var currentUser = FirebaseAuth.getInstance().currentUser
        var currentUserID = ""
        if(currentUser != null){
            currentUserID = currentUser.uid
        }
        return currentUserID
    }
}