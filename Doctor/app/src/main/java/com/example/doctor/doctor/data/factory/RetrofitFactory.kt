package com.example.doctor.doctor.data.factory

import com.example.doctor.BuildConfig
import com.google.gson.Gson
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//Criamos um objeto para que, uma vez criado, não fique sendo recriado.

object RetrofitFactory {
    fun build(
        client: OkHttpClient,
        gson: Gson
    ): Retrofit = Retrofit.Builder()
        .client(client)
        .baseUrl(BuildConfig.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()
}

