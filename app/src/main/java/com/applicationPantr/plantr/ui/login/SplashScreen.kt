package com.applicationPantr.plantr.ui.login

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.applicationPantr.plantr.R
import com.applicationPantr.plantr.ui.home.HomeActivity
import com.applicationPantr.plantr.ui.onBoardingScreen.OnBoarding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class SplashScreen : AppCompatActivity() {
    private lateinit var gAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        gAuth = Firebase.auth
        requestWindowFeature(1)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN,
            WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN
        )
        setContentView(R.layout.activity_splash_screen)


        CoroutineScope(Dispatchers.Main).launch {
            delay(10000)
            if (gAuth.currentUser != null)
                startActivity(Intent(this@SplashScreen, HomeActivity::class.java))
            else
                startActivity(Intent(this@SplashScreen, OnBoarding::class.java))
            finish()
        }

    }
    }


