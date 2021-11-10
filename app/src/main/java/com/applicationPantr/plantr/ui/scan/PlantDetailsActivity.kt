package com.applicationPantr.plantr.ui.scan

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.applicationPantr.plantr.R
import com.applicationPantr.plantr.databinding.ActivityPlantDetailsBinding

class PlantDetailsActivity : AppCompatActivity() {

    private lateinit var activityPlantDetailsBinding: ActivityPlantDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityPlantDetailsBinding = DataBindingUtil.setContentView(this,
            R.layout.activity_plant_details)

        val plantImageUri = Uri.parse(intent.getStringExtra("uri"))

        activityPlantDetailsBinding.ivDetailsPlantImage.setImageURI(plantImageUri)

    }
}