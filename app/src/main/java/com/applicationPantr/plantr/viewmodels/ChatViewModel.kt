package com.applicationPantr.plantr.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.applicationPantr.plantr.remote.response.responseModel.Client
import com.applicationPantr.plantr.remote.response.responseModel.Expert
import com.applicationPantr.plantr.repositories.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@HiltViewModel
class ChatViewModel @Inject constructor(var repository: Repository) : ViewModel() {

    fun getDataFromApi():LiveData<List<Expert>>{
        return liveData(Dispatchers.IO) {
            emit(repository.getResponse())
        }
    }


//    fun getClientResponseFromAPi():LiveData<List<Client>>{
//        return liveData(Dispatchers.IO) {
//            Log.d("Aditya", "getClientResponseFromAPi: ${repository.getResponseOfClients()}")
//            emit(repository.getResponseOfClients())
//        }
//    }
}