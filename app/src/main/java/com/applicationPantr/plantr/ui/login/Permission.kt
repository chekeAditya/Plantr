package com.applicationPantr.plantr.ui.login

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.applicationPantr.plantr.R
import com.applicationPantr.plantr.ui.home.HomeActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn.hasPermissions
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_permission.*
import kotlin.String as String

abstract class Permission(private val PERMISSIONS: Array<String>) : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_permission)
        val request = registerForActivityResult(ActivityResultContracts.RequestPermission()) {
            if (it) {
                Toast.makeText(applicationContext, "Permission Granted", Toast.LENGTH_SHORT)
                    .show()

            } else {
                Toast.makeText(applicationContext, "Permission Not Granted", Toast.LENGTH_SHORT)
                    .show()

            }
        }

        ivNotNow.setOnClickListener {
            val notificationIntentGoogle = Intent(this, HomeActivity::class.java)
            startActivity(notificationIntentGoogle)
        }

        ivPermission.setOnClickListener {
            request.launch(android.Manifest.permission.CAMERA)
            request.launch(android.Manifest.permission.ACCESS_COARSE_LOCATION)
            request.launch(android.Manifest.permission.READ_EXTERNAL_STORAGE)
        }


    }
}