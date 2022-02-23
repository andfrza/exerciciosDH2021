package com.example.doctor.doctor.data.factory

import com.google.gson.GsonBuilder

object GsonFactory {
    fun build() = GsonBuilder().create()
}