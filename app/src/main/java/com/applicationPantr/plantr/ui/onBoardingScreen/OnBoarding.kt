package com.applicationPantr.plantr.ui.onBoardingScreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.core.view.get
import androidx.core.view.isVisible
import androidx.viewpager2.widget.ViewPager2
import com.applicationPantr.plantr.R
import com.applicationPantr.plantr.ui.login.LoginActivity
import kotlinx.android.synthetic.main.activity_on_boarding.*
import java.util.*

class OnBoarding : AppCompatActivity() {
    private val introAdapter = IntroAdapter(

        listOf(
            IntroSlider
                (
                R.drawable.ic_swap_with_people,R.drawable.ic_swap,
                "Share or Exchange your plants with \n others and form a Swap community."
            ),
            IntroSlider
                (
                R.drawable.ic_scan_your_plants,R.drawable.ic_scan,
                "Scan your Plants with Plant Scanner \n and know all the details about it"
            ),
            IntroSlider
                (
                R.drawable.ic_chat_with_experts,R.drawable.ic_chat,
                "Scan your Plants with Plant Scanner \n and know all the details about it"
            ),
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_boarding)
        SliderViewpager.adapter = introAdapter
        setUpIndicator()
        setUpCurrentIndicator(0)
        SliderViewpager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                setUpCurrentIndicator(position)
            }
        })
        btnNext.setOnClickListener {
            if(SliderViewpager.currentItem+1<introAdapter.itemCount) {
                SliderViewpager.currentItem += 1;
//            if (SliderViewpager.currentItem>=3)
                if(SliderViewpager.currentItem>0){
                    btnBack.isVisible=true
                }
                if (SliderViewpager.currentItem >=2){
                    btnGetStarted.isVisible=true
                    btnNext.isVisible=false
                }else if(SliderViewpager.currentItem<2){
                    btnGetStarted.isVisible=false
                }
            }else{
                Intent(applicationContext,LoginActivity::class.java).also {
                    startActivity(it)
                    finish()
                }
            }
            btnBack.setOnClickListener {
             SliderViewpager.currentItem=SliderViewpager.currentItem-1
                btnNext.isVisible=true
                btnGetStarted.isVisible=false
            }
        }

        tvSkip.setOnClickListener {   Intent(applicationContext,LoginActivity::class.java).also {
            startActivity(it)
            finish()
        }}
        btnGetStarted.setOnClickListener {   Intent(applicationContext,LoginActivity::class.java).also {
            startActivity(it)
            finish()
        }}
    }

    private fun setUpIndicator() {
        val indicator = arrayOfNulls<ImageView>(introAdapter.itemCount)
        val layoutParams: LinearLayout.LayoutParams =
            LinearLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT)
        layoutParams.setMargins(8, 0, 8, 0)
        for (i in indicator.indices) {
            indicator[i] = ImageView(applicationContext)
            indicator[i].apply {
                this?.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_inactive
                    )
                )
                this?.layoutParams = layoutParams
            }
            ViewPagerIndicatorContainer.addView(indicator[i])
        }
    }

    private fun setUpCurrentIndicator(index: Int) {
        val childCount = ViewPagerIndicatorContainer.childCount
        for (i in 0 until childCount) {
            val imageview = ViewPagerIndicatorContainer[i] as ImageView
            if (i == index) {
                imageview.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_active
                    )
                )
            } else {
                imageview.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_inactive
                    )
                )
            }
        }
    }
}