package com.applicationPantr.plantr.remote.response.chatresponse

import com.applicationPantr.plantr.remote.response.chatresponse.NotificationDataModel

data class PushNotification(
    val data: NotificationDataModel,
    val to: String
)