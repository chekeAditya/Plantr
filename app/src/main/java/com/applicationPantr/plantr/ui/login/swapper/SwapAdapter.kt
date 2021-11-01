package com.applicationPantr.plantr.ui.login.swapper

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.applicationPantr.plantr.R

class SwapAdapter: RecyclerView.Adapter<SwapAdapter.SwapViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SwapViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_swap_layout,parent,false)
        return SwapViewHolder(view)
    }

    override fun onBindViewHolder(holder: SwapViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 20
    }

    class SwapViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

    }

}