package com.example.doctor.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.doctor.R
import com.example.doctor.login.loginviewmodel.LoginViewModel
import com.example.doctor.login.repository.ValidarLogin

class ActivityLogin : AppCompatActivity(R.layout.activity_login), FragmentLogin.IshowForgotPasswordDialog {

    val viewModel:LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportFragmentManager.beginTransaction()
            .add(R.id.inflater,FragmentLogin())
            .commit()

        observe()
    }

    //Funções de comunicação com o fragmento:
    override fun showForgotPasswordDialogBox() {
        val dialog = FragmentForgotPasswordDialog()
        dialog.show(supportFragmentManager,FragmentForgotPasswordDialog.TAG)
    }
    override fun dadosCadastro(dadosLogin: ValidarLogin){
        viewModel.verificarCadastro(dadosLogin)
    }

    //Função para o tratamento de LiveData, retornando uma autenticação para o login:
    private fun showLoginStatusDialogBox(){

    }

    private fun observe(){
        viewModel.login.observe(this){
            if(it){showForgotPasswordDialogBox()}
        }
    }
}