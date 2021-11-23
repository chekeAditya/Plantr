package com.applicationPantr.plantr.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.applicationPantr.plantr.R
import com.applicationPantr.plantr.ui.onBoardingScreen.OnBoarding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ready : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ready)
        CoroutineScope(Dispatchers.Main).launch {
            delay(10000)//This method will be executed once the timer is over
            // Start your app main activity
            val i = Intent(this@ready, permissionRequest::class.java)
            startActivity(i)
            // close this activity
            finish()
        }

    }
}