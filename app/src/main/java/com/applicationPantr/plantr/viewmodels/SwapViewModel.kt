package com.applicationPantr.plantr.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.applicationPantr.plantr.remote.response.responseModel.Expert
import com.applicationPantr.plantr.remote.response.responseModel.Plant
import com.applicationPantr.plantr.repositories.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@HiltViewModel
class SwapViewModel @Inject constructor(var repository: Repository): ViewModel() {

    fun getPlantsDataFromApi(): LiveData<List<Plant>> {
        return liveData(Dispatchers.IO) {
            emit(repository.getPlantsResponse())
        }
    }

}