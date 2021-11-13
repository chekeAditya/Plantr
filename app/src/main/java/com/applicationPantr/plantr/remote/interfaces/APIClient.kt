package com.applicationPantr.plantr.remote.interfaces

import com.applicationPantr.plantr.remote.response.responseModel.PlantrResponseModel
import retrofit2.http.GET

interface APIClient {


    //    Base_url :- https://gist.githubusercontent.com/ybansal830/9154e31ff1a40b6fce0843b63feafebd/raw/ef1f78965f1d45e1fabde5fe0d49f246f4c0e39e/PlantrAPI
    @GET("PlantrAPI")
    suspend fun getApiResponse(): PlantrResponseModel


//    @GET("PlantrAPI")
//    suspend fun getApiResponseOfExpert(): Expert

}