package com.applicationPantr.plantr.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.applicationPantr.plantr.R
import com.applicationPantr.plantr.databinding.ActivityHomeBinding
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    lateinit var activityHomeBinding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityHomeBinding = DataBindingUtil.setContentView(this,R.layout.activity_home)
       val navController = findNavController(R.id.navHostFragment)

        activityHomeBinding.bottomNavigationView.setupWithNavController(navController)
    }
}