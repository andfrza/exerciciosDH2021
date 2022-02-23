package com.example.doctor.doctor.feature.login.view

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import com.example.doctor.R
import com.example.doctor.doctor.data.model.ValidarLogin
import com.google.android.material.textfield.TextInputEditText
import java.lang.RuntimeException

class FragmentLogin : Fragment(R.layout.fragment_login) {

    private var listener: IshowForgotPasswordDialog? = null
    private val button_forgot_password: Button?
        get() = view?.findViewById(R.id.button_forgot_password)
    private val button_login: Button?
        get() = view?.findViewById(R.id.button_login)
    private val email: TextInputEditText?
        get() = view?.findViewById(R.id.textField_email_input)
    private val senha: TextInputEditText?
        get() = view?.findViewById(R.id.textField_password_input)


    interface IshowForgotPasswordDialog{
        fun showForgotPasswordDialogBox()
        fun dadosCadastro(validarLogin: ValidarLogin)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is IshowForgotPasswordDialog){
            listener = context
        }else{
            throw RuntimeException(context.toString()+"IshowForgotPasswordDialog não implementado")
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        button_forgot_password?.setOnClickListener {
            listener?.showForgotPasswordDialogBox()
        }
        button_login?.setOnClickListener {
            listener?.dadosCadastro(ValidarLogin(email?.text.toString(),senha?.text.toString()))
        }
    }
}