package com.example.doctor.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.doctor.R

class Activity_Login : AppCompatActivity(), Fragment_Login.IshowForgotPasswordDialog {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        supportFragmentManager.beginTransaction()
            .replace(R.id.inflater,Fragment_Login())
            .commit()
    }

    override fun showDialogBox() {
        val dialog = Fragment_ForgotPasswordDialog()
        dialog.show(supportFragmentManager,Fragment_ForgotPasswordDialog.TAG)
    }
}