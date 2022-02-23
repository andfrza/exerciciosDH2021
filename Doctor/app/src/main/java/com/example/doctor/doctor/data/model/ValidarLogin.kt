package com.example.doctor.doctor.data.model

class ValidarLogin(private val login:String, private val senha:String) {

    fun validarLogin():Boolean{
        return (login=="a"&& senha=="1")
    }
}