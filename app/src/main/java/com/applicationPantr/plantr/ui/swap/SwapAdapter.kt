package com.applicationPantr.plantr.ui.swap

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.applicationPantr.plantr.R
import com.applicationPantr.plantr.remote.response.responseModel.Plant
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_swap_layout.view.*

class SwapAdapter(private val listOfPlants: List<Plant>)
    : RecyclerView.Adapter<SwapAdapter.SwapViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SwapViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_swap_layout,parent,false)
        return SwapViewHolder(view)
    }

    override fun onBindViewHolder(holder: SwapViewHolder, position: Int) {
        holder.onDataBind(listOfPlants[position])
    }

    override fun getItemCount(): Int {
        return listOfPlants.size
    }

    class SwapViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        fun onDataBind(plant: Plant){
            itemView.apply {
                Glide.with(ivPlantImage).load(plant.image).into(ivPlantImage)
                tvPlantA.text = plant.plantA
                tvPlantB.text = plant.plantB
            }
        }

    }

}