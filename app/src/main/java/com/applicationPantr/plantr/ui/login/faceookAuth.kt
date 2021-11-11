package com.applicationPantr.plantr.ui.login

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.applicationPantr.plantr.ui.home.HomeActivity
import com.facebook.AccessToken
import com.facebook.FacebookException

import com.facebook.login.LoginResult

import com.facebook.FacebookCallback

import com.facebook.login.LoginManager

import com.facebook.CallbackManager
import com.facebook.CallbackManager.Factory.create
import com.google.firebase.auth.FacebookAuthProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


class faceookAuth : LoginActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var callbackManager: CallbackManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        callbackManager = create()
        auth = Firebase.auth
        LoginManager.getInstance().logInWithReadPermissions(this, listOf( "public_profile"))
        LoginManager.getInstance().registerCallback(callbackManager,
            object : FacebookCallback<LoginResult?> {

                override fun onCancel() {
                    // App code
                }

                override fun onError(exception: FacebookException) {
                    // App code
                }

                override fun onSuccess(result: LoginResult?) {
                    if (result != null) {
                        handleFacebookAccessToken(result.accessToken)
                    }
                }
            })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // Pass the activity result back to the Facebook SDK
        callbackManager.onActivityResult(requestCode, resultCode, data)
    }
    private fun handleFacebookAccessToken(token: AccessToken) {


        val credential = FacebookAuthProvider.getCredential(token.token)
        auth.signInWithCredential(credential)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    val user = auth.currentUser
                    updateUI(user)
                    val notificationIntentGoogle = Intent(this, HomeActivity::class.java)
                    startActivity(notificationIntentGoogle)
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "signInWithCredential:failure", task.exception)
                    Toast.makeText(baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT).show()
                    updateUI(null)
                }
            }
    }

    private fun updateUI(user: FirebaseUser?) {
        val notificationIntent = Intent(this, HomeActivity::class.java)
        startActivity(notificationIntent)
    }
}