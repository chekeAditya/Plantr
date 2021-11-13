package com.applicationPantr.plantr.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.applicationPantr.plantr.R
import com.applicationPantr.plantr.ui.onBoardingScreen.OnBoarding

class ready : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ready)
        Handler().postDelayed(Runnable { //This method will be executed once the timer is over
            // Start your app main activity
            val i = Intent(this,Permission::class.java)
            startActivity(i)
            // close this activity
            finish()
        },10000)

    }
}