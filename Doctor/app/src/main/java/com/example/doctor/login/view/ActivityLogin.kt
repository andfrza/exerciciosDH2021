package com.example.doctor.login.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.example.doctor.R
import com.example.doctor.login.loginviewmodel.LoginViewModel
import com.example.doctor.login.model.ValidarLogin
import com.google.android.material.snackbar.Snackbar

class ActivityLogin : AppCompatActivity(R.layout.activity_login),
    FragmentLogin.IshowForgotPasswordDialog {

    private val viewModel:LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportFragmentManager.beginTransaction()
            .add(R.id.inflater, FragmentLogin())
            .commit()

        observe()
    }

    //Funções de comunicação com o fragmento:
    override fun showForgotPasswordDialogBox() {
        val dialog = FragmentForgotPasswordDialog()
        dialog.show(supportFragmentManager, FragmentForgotPasswordDialog.TAG)
    }
    override fun dadosCadastro(dadosLogin: ValidarLogin){
        viewModel.verificarCadastro(dadosLogin)
    }

    //Função para o tratamento de LiveData, retornando uma autenticação para o login:
    private fun showLoginStatusSnackbar(){
        val contextView = findViewById<CoordinatorLayout>(R.id.snackbar)
            Snackbar.make(contextView, "Login e /ou senha inválidos!", Snackbar.LENGTH_LONG)
                .show()
    }

    private fun observe(){
        viewModel.login.observe(this){
            if(!it){showLoginStatusSnackbar()}
        }
    }
}