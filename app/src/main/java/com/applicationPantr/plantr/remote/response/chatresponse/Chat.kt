package com.applicationPantr.plantr.remote.response.chatresponse

data class Chat(
    val senderId: String = "",
    val receiverId: String = "",
    val message: String = ""
)