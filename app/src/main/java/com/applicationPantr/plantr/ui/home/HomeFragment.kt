package com.applicationPantr.plantr.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.applicationPantr.plantr.R
import com.applicationPantr.plantr.databinding.FragmentHomeBinding
import com.applicationPantr.plantr.remote.interfaces.OnChatClicked
import com.applicationPantr.plantr.remote.response.responseModel.Blog
import com.applicationPantr.plantr.remote.response.responseModel.Expert
import com.applicationPantr.plantr.viewmodels.ChatViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.item_blog_layout.*
import okhttp3.internal.notify
import okhttp3.internal.notifyAll
@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home),OnChatClicked{

    lateinit var homeBinding: FragmentHomeBinding
    lateinit var blogsAdapter: BlogsAdapter
    var blolist = mutableListOf<Blog>()
    private val chatViewModel: ChatViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        homeBinding =
            DataBindingUtil.inflate(inflater,R.layout.fragment_home,container,false)
        return homeBinding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        testimonialViewpager.adapter = testimonialAdapter
        TestimonialSlider()
        setUpRecyclerView()

        chatViewModel.getBlogData().observe(viewLifecycleOwner, Observer {
            blolist.clear()
            blolist.addAll(it)
            blogsAdapter.notifyDataSetChanged()
        })
    }

    private fun setUpRecyclerView() {
        blogsAdapter = BlogsAdapter(blolist, this)
        homeBinding.apply {
            BlogsRecyclerView.layoutManager = LinearLayoutManager(context)
            BlogsRecyclerView.adapter = blogsAdapter
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
                "Riya Mishra", R.drawable.sumit,
                R.drawable.ic_rating,
                R.drawable.ic_double_commas,
                "Great Place to get information about planting. easy to use. very happy with my app"
            ),
            Testimonials(
                "Shubham Kumar",
                R.drawable.johndeep,
                R.drawable.ic_rating,
                R.drawable.ic_double_commas,
                "Expert chat is my favourite feature as expert resolve all your doubts. experts are very friendly."
            ),
            Testimonials(
                "Sonu Kumar",
                R.drawable.gopal,
                R.drawable.ic_rating,
                R.drawable.ic_double_commas,
                "Scanning feature uis great whenever I like some plants and I don't know the name i just scan it "
            )

        )
    )

    override fun onClicked(expert: Expert) {

    }

    override fun onBlogClicked(blog: Blog) {

    }
}