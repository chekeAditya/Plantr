package com.applicationPantr.plantr.ui.login

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.applicationPantr.plantr.R
import com.applicationPantr.plantr.ui.onBoardingScreen.OnBoarding


class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_permission)
        Handler().postDelayed(Runnable { //This method will be executed once the timer is over
            // Start your app main activity
            val i = Intent(this, OnBoarding::class.java)
            startActivity(i)
            // close this activity
            finish()
        }, 3000)
    }
}