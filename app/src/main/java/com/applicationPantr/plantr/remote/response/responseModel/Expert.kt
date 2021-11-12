package com.applicationPantr.plantr.remote.response.responseModel


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Expert(
    @SerializedName("about")
    val about: String,
    @SerializedName("avgCharges")
    val avgCharges: String,
    @SerializedName("bgPlantImage")
    val bgPlantImage: String,
    @SerializedName("clients")
    val clients: List<Client>,
    @SerializedName("happyClients")
    val happyClients: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("live")
    val live: Boolean,
    @SerializedName("minCalls")
    val minCalls: String,
    @SerializedName("minChat")
    val minChat: String,
    @SerializedName("name")
    val name: String
) : Serializable