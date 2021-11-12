package com.applicationPantr.plantr.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.applicationPantr.plantr.R
import com.applicationPantr.plantr.databinding.ItemLayoutChatBinding
import com.applicationPantr.plantr.remote.interfaces.OnChatClicked
import com.applicationPantr.plantr.remote.response.responseModel.Expert
import com.bumptech.glide.Glide

class ChatAdapter(
    private val expertResponseList: List<Expert>,
    private val onChatClicked: OnChatClicked
) : RecyclerView.Adapter<ChatViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
        val itemLayoutChatBinding: ItemLayoutChatBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_layout_chat, parent, false
        )
        return ChatViewHolder(itemLayoutChatBinding, onChatClicked)
    }

    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
        val expertResponse = expertResponseList[position]
        holder.onBind(expertResponse)
    }

    override fun getItemCount(): Int {
        return expertResponseList.size
    }
}

//viewHolder
class ChatViewHolder(
    private val itemLayoutChatBinding: ItemLayoutChatBinding,
    private val onChatClicked: OnChatClicked
) : RecyclerView.ViewHolder(itemLayoutChatBinding.root) {
    fun onBind(expertResponse: Expert) {
        itemLayoutChatBinding.onClickedChat = onChatClicked
        itemLayoutChatBinding.expertsResponse = expertResponse
        Glide.with(itemLayoutChatBinding.cvImage).load(expertResponse.image)
            .into(itemLayoutChatBinding.expertImage)
    }
}