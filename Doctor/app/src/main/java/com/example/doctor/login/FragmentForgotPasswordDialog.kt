package com.example.doctor.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.doctor.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class FragmentForgotPasswordDialog : BottomSheetDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_forgot_password_dialog, container, false)
    }

    companion object{
        const val TAG = "ForgotPasswordDialog"
    }

}