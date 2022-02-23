package com.example.doctor.doctor.data.network

import com.example.doctor.doctor.data.factory.GsonFactory
import com.example.doctor.doctor.data.factory.OkHttpFactory
import com.example.doctor.doctor.data.factory.RetrofitFactory
import com.example.doctor.doctor.data.model.ProfileResponse
import retrofit2.http.GET

interface Api {

    @GET("api")
    suspend fun getProfile() : ProfileResponse
    companion object{
        val instance: Api by lazy {
            RetrofitFactory.build(
                OkHttpFactory.build(),
                GsonFactory.build()
            ).create(Api::class.java)
        }
    }

}