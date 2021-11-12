package com.applicationPantr.plantr.remote.interfaces

import com.applicationPantr.plantr.extras.Constants.CONTENT_TYPE
import com.applicationPantr.plantr.extras.Constants.SERVER_KEY
import com.applicationPantr.plantr.remote.response.chatresponse.PushNotification
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface NotificationApi {

    @Headers("Authorization: key=$SERVER_KEY","Content-type:$CONTENT_TYPE")
    @POST("fcm/send")
    suspend fun postNotification(
        @Body notification: PushNotification
    ): Response<ResponseBody>
}