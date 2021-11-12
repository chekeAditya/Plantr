package com.applicationPantr.plantr.ui.scan

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.applicationPantr.plantr.R
import com.applicationPantr.plantr.databinding.ActivityPlantDetailsBinding

class PlantDetailsActivity : AppCompatActivity() {

    private lateinit var activityPlantDetailsBinding: ActivityPlantDetailsBinding

    private var selectedPlantOption: Int = 1

    private val plantOption1Details = "Choose a growing location that receives full " +
            "to partial sunlight with a temperature above 55 degrees F. Keep the plant " +
            "away from drafts or areas with temperature fluctuations. Move the plant to a " +
            "partially shaded area if the foliage appears dried from too much sunlight."

    private val plantOption2Details = "Give the Ficus retusa enough water to keep the soil " +
            "evenly moist, but not wet, during the spring and summer months. Reduce the water " +
            "applications in the fall and winter months by applying water only once the soil " +
            "becomes slightly dry to prevent over-saturation that promotes root rot."

    private val plantOption3Details = "Bonsai trees require pruning to keep them in a desirable " +
            "shape. Prune during the winter months when the tree isn't actively growing to reduce " +
            "plant stress. Clip off up to four leaves at a time once at least 10 have grown on " +
            "the branch."

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityPlantDetailsBinding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_plant_details
        )

        val plantImageUri = Uri.parse(intent.getStringExtra("uri"))

        activityPlantDetailsBinding.ivDetailsPlantImage.setImageURI(plantImageUri)

        activityPlantDetailsBinding.apply {
            tvOptionPlantDetails.text = plantOption1Details

            llPlantOption1.setOnClickListener {
                plantOption1Selected()
            }
            llPlantOption2.setOnClickListener {
                plantOption2Selected()
            }
            llPlantOption3.setOnClickListener {
                plantOption3Selected()
            }

            ivPlantDetailsBack.setOnClickListener {
                finish()
            }
        }

    }

    fun plantOption1Selected() {
        when (selectedPlantOption) {
            2 -> {
                plantOption2Unselected()
            }
            3 -> {
                plantOption3Unselected()
            }
        }
        activityPlantDetailsBinding.apply {
            llPlantOption1.background = ContextCompat.getDrawable(
                applicationContext,
                R.drawable.bg_specific_plant_details
            )
            ivPlantF.setImageResource(R.drawable.ic_selected_plant_f)
            tvPlantF.setTextColor(
                ContextCompat.getColor(
                    applicationContext,
                    R.color.main_head_text_green
                )
            )
            tvOptionPlantDetails.text = plantOption1Details
        }
        selectedPlantOption = 1
    }

    fun plantOption2Selected() {
        when (selectedPlantOption) {
            1 -> {
                plantOption1Unselected()
            }
            3 -> {
                plantOption3Unselected()
            }
        }
        activityPlantDetailsBinding.apply {
            llPlantOption2.background = ContextCompat.getDrawable(
                applicationContext,
                R.drawable.bg_specific_plant_details
            )
            ivPlantHigh.setImageResource(R.drawable.ic_selected_plant_high)
            tvPlantHigh.setTextColor(
                ContextCompat.getColor(
                    applicationContext,
                    R.color.main_head_text_green
                )
            )
            tvOptionPlantDetails.text = plantOption2Details
        }
        selectedPlantOption = 2
    }

    fun plantOption3Selected() {
        when (selectedPlantOption) {
            1 -> {
                plantOption1Unselected()
            }
            2 -> {
                plantOption2Unselected()
            }
        }
        activityPlantDetailsBinding.apply {
            llPlantOption3.background = ContextCompat.getDrawable(
                applicationContext,
                R.drawable.bg_specific_plant_details
            )
            ivPlantHealthy.setImageResource(R.drawable.ic_selected_plant_healthy)
            tvPlantHealthy.setTextColor(
                ContextCompat.getColor(
                    applicationContext,
                    R.color.main_head_text_green
                )
            )
            tvOptionPlantDetails.text = plantOption3Details
        }
        selectedPlantOption = 3
    }

    fun plantOption1Unselected() {
        activityPlantDetailsBinding.apply {
            llPlantOption1.background = ContextCompat.getDrawable(
                applicationContext,
                R.color.white
            )
            ivPlantF.setImageResource(R.drawable.ic_unselected_plant_f)
            tvPlantF.setTextColor(
                ContextCompat.getColor(
                    applicationContext,
                    R.color.main_text_light
                )
            )
        }
    }

    fun plantOption2Unselected() {
        activityPlantDetailsBinding.apply {
            llPlantOption2.background = ContextCompat.getDrawable(
                applicationContext,
                R.color.white
            )
            ivPlantHigh.setImageResource(R.drawable.ic_unselected_plant_high)
            tvPlantHigh.setTextColor(
                ContextCompat.getColor(
                    applicationContext,
                    R.color.main_text_light
                )
            )
        }
    }

    fun plantOption3Unselected() {
        activityPlantDetailsBinding.apply {
            llPlantOption3.background = ContextCompat.getDrawable(
                applicationContext,
                R.color.white
            )
            ivPlantHealthy.setImageResource(R.drawable.ic_unselected_plant_healthy)
            tvPlantHealthy.setTextColor(
                ContextCompat.getColor(
                    applicationContext,
                    R.color.main_text_light
                )
            )
        }
    }

}