package com.applicationPantr.plantr.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.applicationPantr.plantr.R
import com.applicationPantr.plantr.databinding.ItemMoreExpertBinding
import com.applicationPantr.plantr.remote.response.responseModel.Expert
import com.bumptech.glide.Glide

class MoreExpertAdapter(
    private val expertResponseList: List<Expert>,
) : RecyclerView.Adapter<MoreExpertViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoreExpertViewHolder {
        val itemMoreExpertBinding: ItemMoreExpertBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_more_expert, parent, false
        )
        return MoreExpertViewHolder(itemMoreExpertBinding)
    }

    override fun onBindViewHolder(holder: MoreExpertViewHolder, position: Int) {
        val expertResponse = expertResponseList[position]
        holder.onBind(expertResponse)
    }

    override fun getItemCount(): Int {
        return expertResponseList.size
    }
}

//viewHolder
class MoreExpertViewHolder(
    private val itemMoreExpertBinding: ItemMoreExpertBinding,
) : RecyclerView.ViewHolder(itemMoreExpertBinding.root) {
    fun onBind(expertResponse: Expert) {
        itemMoreExpertBinding.expertsResponse = expertResponse
        Glide.with(itemMoreExpertBinding.ciExpertImage).load(expertResponse.image)
            .into(itemMoreExpertBinding.ciExpertImage)
    }
}