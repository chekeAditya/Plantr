package com.applicationPantr.plantr.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.applicationPantr.plantr.R
import kotlinx.android.synthetic.main.clientreview.view.*


class TestimonialAdapter(private val TestimonialSlider: List<Testimonials>):
    RecyclerView.Adapter<TestimonialAdapter.TestViewHolder>() {
    inner class TestViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val textTittles = view.ClientName
        private val description=view.Descr
        private val rating=view.expert_Rating
        private val quama = view.punctuation
        private val image=view.ClientImage
        fun bind(testSlider: Testimonials) {
            textTittles.text=testSlider.names
            description.text=testSlider.HeadingTwo
            rating.setImageResource(testSlider.Rating)
            image.setImageResource(testSlider.Images)
            quama.setImageResource(testSlider.punctiation)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TestViewHolder {
        return TestViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.clientreview, parent, false)
        )
    }

    override fun onBindViewHolder(holder: TestViewHolder, position: Int) {
        holder.bind(TestimonialSlider[position])
    }

    override fun getItemCount(): Int {
        return TestimonialSlider.size
    }
}
