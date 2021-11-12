package com.applicationPantr.plantr.remote.response.responseModel


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Client(
    @SerializedName("image")
    val image: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("review")
    val review: String
) : Serializable