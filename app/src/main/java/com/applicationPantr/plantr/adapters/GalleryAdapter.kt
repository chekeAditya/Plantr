package com.applicationPantr.plantr.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.applicationPantr.plantr.R
import com.applicationPantr.plantr.databinding.ItemGalleryBinding
import com.applicationPantr.plantr.remote.response.responseModel.Expert
import com.bumptech.glide.Glide

class GalleryAdapter(
    private val expertResponseList: List<Expert>,
) : RecyclerView.Adapter<GalleryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GalleryViewHolder {
        val itemGalleryBinding: ItemGalleryBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_gallery, parent, false
        )
        return GalleryViewHolder(itemGalleryBinding)
    }

    override fun onBindViewHolder(holder: GalleryViewHolder, position: Int) {
        val expertResponse = expertResponseList[position]
        holder.onBind(expertResponse)
    }

    override fun getItemCount(): Int {
        return expertResponseList.size
    }
}

//viewHolder
class GalleryViewHolder(
    private val itemGalleryBinding: ItemGalleryBinding,
) : RecyclerView.ViewHolder(itemGalleryBinding.root) {
    fun onBind(expertResponse: Expert) {
        itemGalleryBinding.expertsResponse = expertResponse
        Glide.with(itemGalleryBinding.ivImage).load(expertResponse.bgPlantImage)
            .into(itemGalleryBinding.ivImage)
    }
}