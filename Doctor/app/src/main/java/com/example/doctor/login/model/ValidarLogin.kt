package com.example.doctor.login.model

class ValidarLogin(private val login:String, private val senha:String) {

    fun validarLogin():Boolean{
        return (login=="a"&& senha=="1")
    }
}