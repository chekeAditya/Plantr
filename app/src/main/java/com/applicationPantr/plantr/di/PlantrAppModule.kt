package com.applicationPantr.plantr.di

import com.applicationPantr.plantr.remote.interfaces.APIClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@Module
@InstallIn(SingletonComponent::class)
object PlantrAppModule {

    //    BaseUrl :- https://gist.githubusercontent.com/ybansal830/9154e31ff1a40b6fce0843b63feafebd/raw/ef1f78965f1d45e1fabde5fe0d49f246f4c0e39e/PlantrAPI
    private const val BASE_URL =
        "https://gist.githubusercontent.com/ybansal830/9154e31ff1a40b6fce0843b63feafebd/raw/ef1f78965f1d45e1fabde5fe0d49f246f4c0e39e/"

    @Provides
    fun provideAPIService(): APIClient {
        val builder = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return builder.create(APIClient::class.java)
    }
}