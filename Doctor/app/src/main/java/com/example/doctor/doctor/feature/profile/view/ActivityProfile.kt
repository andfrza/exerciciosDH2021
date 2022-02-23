package com.example.doctor.doctor.feature.profile.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.view.isVisible
import com.example.doctor.R
import com.example.doctor.doctor.feature.profile.viewmodel.ProfileViewModel

class ActivityProfile : AppCompatActivity(R.layout.activity_profile) {

    private val viewModel: ProfileViewModel by viewModels()
    private val loading: FrameLayout
        get() = findViewById(R.id.activity_profile_screen_loading)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.loadProfile()
        observeData()
    }

    private fun observeData() {
        viewModel.loading.observe(this){loading.isVisible = it}
        viewModel.error.observe(this){
            if (!it){
            Toast.makeText(this,"Deu certo!",Toast.LENGTH_LONG).show()
            }
        }
    }
}