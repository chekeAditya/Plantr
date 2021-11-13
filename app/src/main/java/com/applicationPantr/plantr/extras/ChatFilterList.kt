package com.applicationPantr.plantr.extras

import com.applicationPantr.plantr.remote.response.responseModel.Expert

class ChatFilterList {

    companion object{
        var originalList = mutableListOf<Expert>()
        var filterList = mutableListOf<Expert>()
        var filter = false
    }

}