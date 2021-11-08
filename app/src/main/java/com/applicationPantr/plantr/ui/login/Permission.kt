package com.applicationPantr.plantr.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.applicationPantr.plantr.R
import com.applicationPantr.plantr.databinding.ActivityMainBinding
import com.applicationPantr.plantr.databinding.ActivityPermissionBinding
import kotlinx.android.synthetic.main.activity_permission.*
import org.jetbrains.annotations.Contract
import java.security.Permission
import java.util.jar.Manifest

class Permission : AppCompatActivity() {
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
            val notificationIntentGoogle = Intent(this, ready::class.java)
            startActivity(notificationIntentGoogle)
        }

        ivPermission.setOnClickListener {
            request.launch(android.Manifest.permission.CAMERA)
            request.launch(android.Manifest.permission.ACCESS_COARSE_LOCATION)
            request.launch(android.Manifest.permission.READ_EXTERNAL_STORAGE)
        }

    }
}