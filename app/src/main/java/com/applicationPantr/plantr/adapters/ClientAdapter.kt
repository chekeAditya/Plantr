package com.applicationPantr.plantr.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.applicationPantr.plantr.R
import com.applicationPantr.plantr.databinding.ItemClientReviewBinding
import com.applicationPantr.plantr.remote.response.responseModel.Client
import com.bumptech.glide.Glide

class ClientAdapter(
    private val clientList: List<Client>,
) : RecyclerView.Adapter<ClientViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClientViewHolder {
        val itemClientBinding: ItemClientReviewBinding= DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_client_review, parent, false
        )
        return ClientViewHolder(itemClientBinding)
    }

    override fun onBindViewHolder(holder: ClientViewHolder, position: Int) {
        val client = clientList[position]
        holder.onBind(client)
    }

    override fun getItemCount(): Int {
        return clientList.size
    }
}

//viewHolder
class ClientViewHolder(
    private val itemClientReviewsBinding: ItemClientReviewBinding,
) : RecyclerView.ViewHolder(itemClientReviewsBinding.root) {
    fun onBind(client: Client) {
        itemClientReviewsBinding.clients = client
        Glide.with(itemClientReviewsBinding.ciClientImage).load(client.image)
            .into(itemClientReviewsBinding.ciClientImage)
    }
}