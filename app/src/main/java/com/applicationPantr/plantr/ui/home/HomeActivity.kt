package com.applicationPantr.plantr.ui.home

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.applicationPantr.plantr.R
import com.applicationPantr.plantr.databinding.ActivityHomeBinding
import com.applicationPantr.plantr.ui.scan.ScanActivity
import dagger.hilt.android.AndroidEntryPoint
import java.io.Serializable

@AndroidEntryPoint
class HomeActivity : AppCompatActivity(),Serializable {

    lateinit var activityHomeBinding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityHomeBinding = DataBindingUtil.setContentView(this, R.layout.activity_home)

        setContentView(activityHomeBinding.root)
        val navController = findNavController(R.id.navHostFragment)

        activityHomeBinding.bottomNavigationView.setupWithNavController(navController)

        activityHomeBinding.fbScanPlant.setOnClickListener {
            if (permissionGranted()) {
                startActivity(Intent(this, ScanActivity::class.java))
            } else {
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(Manifest.permission.CAMERA),

                1)
            }
        }

    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            startActivity(Intent(this, ScanActivity::class.java))
        }
    }

    private fun permissionGranted(): Boolean {
        return ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) ==
                PackageManager.PERMISSION_GRANTED
    }
}