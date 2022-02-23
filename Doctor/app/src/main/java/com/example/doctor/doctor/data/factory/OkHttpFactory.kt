package com.example.doctor.doctor.data.factory

import com.example.doctor.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit

//O apply está retornando os métodos do Builder.

object OkHttpFactory {
    fun build() = OkHttpClient.Builder().apply {
        if(BuildConfig.DEBUG){
            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            addInterceptor(loggingInterceptor)
        }

        readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
        writeTimeout(DEFAULT_TIMEOUT,TimeUnit.SECONDS)
        connectTimeout(DEFAULT_TIMEOUT,TimeUnit.SECONDS)
    }.build()

    private const val DEFAULT_TIMEOUT = 60L
}