package com.applicationPantr.plantr.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.applicationPantr.plantr.R
import com.applicationPantr.plantr.ui.chat._chat.UserActivity
import kotlinx.android.synthetic.main.fragment_chat_details.*
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(R.layout.fragment_home) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        testimonialViewpager.adapter = testimonialAdapter
        TestimonialSlider()

        btnCheckNowHomeFragment.setOnClickListener {
            val intent = Intent(context, UserActivity::class.java)
            startActivity(intent)
        }


    }

    private fun TestimonialSlider() {
        ivForward.setOnClickListener {
            if (testimonialViewpager.currentItem + 1 < testimonialAdapter.itemCount) {
                testimonialViewpager.currentItem += 1;
//            if (SliderViewpager.currentItem>=3)
            }
            ivBackward.setOnClickListener {
                testimonialViewpager.currentItem = testimonialViewpager.currentItem - 1
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
