package com.example.doctor.login.repository

class ValidarLogin(val login:String, val senha:String) {

    fun validarLogin():Boolean{
        return (login=="a"&& senha=="1")
    }
}