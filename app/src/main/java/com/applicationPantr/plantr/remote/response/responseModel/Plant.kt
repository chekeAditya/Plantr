package com.applicationPantr.plantr.remote.response.responseModel


import com.google.gson.annotations.SerializedName

data class Plant(
    @SerializedName("image")
    val image: String,
    @SerializedName("plantA")
    val plantA: String,
    @SerializedName("plantB")
    val plantB: String
)