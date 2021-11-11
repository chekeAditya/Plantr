package com.applicationPantr.plantr.remote.response.responseModel


import com.google.gson.annotations.SerializedName

data class Blog(
    @SerializedName("date")
    val date: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("link")
    val link: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("views")
    val views: String,
    @SerializedName("writer")
    val writer: String
)