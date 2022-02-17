package com.example.doctor.login.loginviewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.doctor.login.data.ValidarLogin

class LoginViewModel: ViewModel() {
    private val _login = MutableLiveData<Boolean>()
    val login: LiveData<Boolean>
        get() = _login

    fun verificarCadastro(dadosLogin:ValidarLogin){
        _login.value = dadosLogin.validarLogin()
    }
}