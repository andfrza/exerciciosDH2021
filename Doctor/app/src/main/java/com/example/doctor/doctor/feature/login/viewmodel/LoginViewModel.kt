package com.example.doctor.doctor.feature.login.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.doctor.doctor.data.model.ValidarLogin

class LoginViewModel: ViewModel() {
    private val _login = MutableLiveData<Boolean>()
    val login: LiveData<Boolean>
        get() = _login

    fun verificarCadastro(dadosLogin: ValidarLogin){
        _login.value = dadosLogin.validarLogin()
    }
}