package com.applicationPantr.plantr.ui.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import com.applicationPantr.plantr.R
import com.applicationPantr.plantr.ui.login.LoginActivity
import com.applicationPantr.plantr.ui.onBoardingScreen.IntroAdapter
import com.applicationPantr.plantr.ui.onBoardingScreen.IntroSlider
import kotlinx.android.synthetic.main.activity_on_boarding.*
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(R.layout.fragment_home) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        testimonialViewpager.adapter = testimonialAdapter
TestimonialSlider()



    }
    private fun TestimonialSlider() {
        ivForward.setOnClickListener {
            if (testimonialViewpager.currentItem + 1 < testimonialAdapter.itemCount) {
                testimonialViewpager.currentItem += 1;
//            if (SliderViewpager.currentItem>=3)
            }
            ivBackward.setOnClickListener {
                testimonialViewpager.currentItem =testimonialViewpager.currentItem - 1
            }
        }
    }
    private val testimonialAdapter = TestimonialAdapter(

        listOf(
            Testimonials(
                "Aditya CHeke",
                R.drawable.sumit,
                R.drawable.ic_rating,
                R.drawable.ic_double_commas,
                "very nice plant i lke it sooo much"
            ),
            Testimonials(
                "Aditya CHeke",
                R.drawable.sumit,
                R.drawable.ic_rating,
                R.drawable.ic_double_commas,
                "very nice plant i lke it sooo much"
            ),
            Testimonials(
                "Aditya CHeke",
                R.drawable.sumit,
                R.drawable.ic_rating,
                R.drawable.ic_double_commas,
                "very nice plant i lke it sooo much"
            )

        )
    )
}
