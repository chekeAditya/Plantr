package com.applicationPantr.plantr.repositories

import android.util.Log
import com.applicationPantr.plantr.remote.interfaces.APIClient
import com.applicationPantr.plantr.remote.response.responseModel.Blog
import com.applicationPantr.plantr.remote.response.responseModel.Client
import com.applicationPantr.plantr.remote.response.responseModel.Expert
import javax.inject.Inject


class Repository @Inject constructor(private val apiClient: APIClient){

    suspend fun getResponse():List<Expert>{
        return apiClient.getApiResponse().experts
    }
    suspend fun getBlogResponse():List<Blog>{
        return apiClient.getApiResponse().blogs
    }

//    suspend fun getResponseOfClients():List<Client>{
//        Log.d("Aditya", "getResponseOfClients: ${apiClient.getApiResponseOfExpert()}")
//        return apiClient.getApiResponseOfExpert().clients
//    }
}