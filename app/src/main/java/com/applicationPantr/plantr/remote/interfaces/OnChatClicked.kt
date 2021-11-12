package com.applicationPantr.plantr.remote.interfaces

import com.applicationPantr.plantr.remote.response.responseModel.Expert

interface OnChatClicked {
    fun onClicked(expert: Expert)
}