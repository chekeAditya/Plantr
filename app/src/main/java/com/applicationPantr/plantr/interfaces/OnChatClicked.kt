package com.applicationPantr.plantr.interfaces

import com.applicationPantr.plantr.remote.response.ChatResponse

interface OnChatClicked {
    fun onClicked(chatResponse: ChatResponse)
}