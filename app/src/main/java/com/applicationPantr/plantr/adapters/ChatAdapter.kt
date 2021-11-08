package com.applicationPantr.plantr.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.applicationPantr.plantr.R
import com.applicationPantr.plantr.databinding.ItemLayoutChatBinding
import com.applicationPantr.plantr.interfaces.OnChatClicked
import com.applicationPantr.plantr.remote.response.ChatResponse

class ChatAdapter(
    private val charResponseList: List<ChatResponse>,
    private val onChatClicked: OnChatClicked
) : RecyclerView.Adapter<ChatViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
       val itemLayoutChatBinding:ItemLayoutChatBinding = DataBindingUtil.inflate(
           LayoutInflater.from(parent.context),
           R.layout.item_layout_chat,parent,false
       )
        return ChatViewHolder(itemLayoutChatBinding,onChatClicked)
    }

    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
        val charResponse = charResponseList[position]
        holder.onBind(charResponse)
    }

    override fun getItemCount(): Int {
        return charResponseList.size
    }
}

//viewHolder
class ChatViewHolder(
    private val itemLayoutChatBinding: ItemLayoutChatBinding,
    private val onChatClicked: OnChatClicked
) : RecyclerView.ViewHolder(itemLayoutChatBinding.root) {
    fun onBind(chatResponse: ChatResponse) {
        itemLayoutChatBinding.onClickedChat = onChatClicked
        itemLayoutChatBinding.chatReponse = chatResponse
    }
}