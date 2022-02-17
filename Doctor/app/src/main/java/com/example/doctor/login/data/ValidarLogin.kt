package com.example.doctor.login.data

class ValidarLogin(private val login:String, private val senha:String) {

    fun validarLogin():Boolean{
        return (login=="a"&& senha=="1")
    }
}