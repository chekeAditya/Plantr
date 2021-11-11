package com.applicationPantr.plantr.remote.response.responseModel


import com.google.gson.annotations.SerializedName

data class PlantrResponseModel(
    @SerializedName("blogs")
    val blogs: List<Blog>,
    @SerializedName("experts")
    val experts: List<Expert>,
    @SerializedName("plants")
    val plants: List<Plant>
)