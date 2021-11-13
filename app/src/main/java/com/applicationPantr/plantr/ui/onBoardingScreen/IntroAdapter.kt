package com.applicationPantr.plantr.ui.onBoardingScreen

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.applicationPantr.plantr.R
import kotlinx.android.synthetic.main.item_gallery.view.*
import kotlinx.android.synthetic.main.slider_container.view.*

class IntroAdapter(private val introSlider: List<IntroSlider>) :
    RecyclerView.Adapter<IntroAdapter.IntroViewHolder>() {
    inner class IntroViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val textTittle = view.Heading1
        private val textDesc = view.Heading2
        private val image=view.ivImage
        fun bind(introSlider: IntroSlider) {
            textTittle.setImageResource(introSlider.HeadingOne)
            textDesc.text = introSlider.HeadingTwo
            image.setImageResource(introSlider.Image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IntroViewHolder {
        return IntroViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.slider_container, parent, false)
        )
    }

    override fun onBindViewHolder(holder: IntroViewHolder, position: Int) {
        holder.bind(introSlider[position])
    }

    override fun getItemCount(): Int {
        return introSlider.size
    }
}