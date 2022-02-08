package com.example.doctor.login

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.doctor.R
import java.lang.RuntimeException

class Fragment_Login : Fragment(R.layout.fragment_login) {

    private val button_forgot_password: Button?
        get() = view?.findViewById(R.id.button_forgot_password)
    private var listener: IshowForgotPasswordDialog? = null

    interface IshowForgotPasswordDialog{
        fun showDialogBox()
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
            listener?.showDialogBox()
        }
    }
}