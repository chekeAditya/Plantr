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


        Handler().postDelayed({
            if (gAuth.currentUser != null)
                startActivity(Intent(this, HomeActivity::class.java))
            else
                startActivity(Intent(this@SplashScreen,LoginActivity::class.java))
            finish()
        }, 10000)

    }
    }


