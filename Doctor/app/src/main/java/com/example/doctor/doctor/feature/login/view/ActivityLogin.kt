package com.example.doctor.doctor.feature.login.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.example.doctor.R
import com.example.doctor.doctor.feature.login.viewmodel.LoginViewModel
import com.example.doctor.doctor.data.model.ValidarLogin
import com.example.doctor.doctor.feature.profile.view.ActivityProfile
import com.google.android.material.snackbar.Snackbar

class ActivityLogin : AppCompatActivity(R.layout.activity_login),
    FragmentLogin.IshowForgotPasswordDialog {

    private val viewModel: LoginViewModel by viewModels()

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
            if(it){
                var intent = Intent(this,ActivityProfile::class.java)
                //intent.putExtra("chaveNome1",campoDeTexto1.text.toString()) //exemplo de como enviar dados para a segunda activity
                startActivity(intent)
            }
        }
    }
}