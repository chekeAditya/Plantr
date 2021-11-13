package com.applicationPantr.plantr.ui.home

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.applicationPantr.plantr.R
import com.applicationPantr.plantr.databinding.ItemBlogLayoutBinding
import com.applicationPantr.plantr.remote.interfaces.OnChatClicked
import com.applicationPantr.plantr.remote.response.responseModel.Blog
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_blog_layout.view.*
import java.util.*
import android.widget.LinearLayout




class BlogsAdapter(private val bloglist:List<Blog>, private val onBlogCLiked: HomeFragment):
    RecyclerView.Adapter<BlogViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BlogViewHolder {
        val itemBlogLayoutBinding:ItemBlogLayoutBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_blog_layout, parent, false
        )
        return BlogViewHolder(onBlogCLiked,itemBlogLayoutBinding)
    }

    override fun onBindViewHolder(holder: BlogViewHolder, position: Int) {
        val bloglist = bloglist[position]
        holder.onBind(bloglist)


    }

    override fun getItemCount(): Int {
        return bloglist.lastIndex
    }

}
class BlogViewHolder(private val onChatClicked: OnChatClicked, private val itemBlogLayoutBinding: ItemBlogLayoutBinding):
    RecyclerView.ViewHolder(itemBlogLayoutBinding.root)
{

    fun onBind(blogResponse:Blog) {

      itemBlogLayoutBinding.onblog=onChatClicked
        itemBlogLayoutBinding.blogResponse=blogResponse
        Glide.with(itemBlogLayoutBinding.cvBlogImage).load(blogResponse.image).into(itemBlogLayoutBinding.ivBlogImage)

    }

}



