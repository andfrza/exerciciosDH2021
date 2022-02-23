package com.example.doctor.doctor.data.repository

import com.example.doctor.doctor.data.model.ProfileResponse
import com.example.doctor.doctor.data.network.Api
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class UserRepository(private val api: Api = Api.instance) {
    fun fetchProfile(): Flow<ProfileResponse> = flow<ProfileResponse> {
        emit(api.getProfile())
    }.flowOn(Dispatchers.IO)

    companion object{
        val instance by lazy{ UserRepository() }
    }
}
