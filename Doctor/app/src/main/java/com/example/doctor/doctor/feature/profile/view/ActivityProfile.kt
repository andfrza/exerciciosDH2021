package com.example.doctor.doctor.feature.profile.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import android.widget.TextView
import androidx.activity.viewModels
import androidx.core.view.isVisible
import com.example.doctor.R
import com.example.doctor.doctor.feature.profile.viewmodel.ProfileViewModel

class ActivityProfile : AppCompatActivity(R.layout.activity_profile) {

    private val viewModel: ProfileViewModel by viewModels()
    private val loading: FrameLayout
        get() = findViewById(R.id.activity_profile_screen_loading)
    private val name: TextView
        get() = findViewById(R.id.activity_profile_screen_cardview_1_content)
    private val number: TextView
        get() = findViewById(R.id.activity_profile_screen_cardview_2_content)
    private val birth: TextView
        get() = findViewById(R.id.activity_profile_screen_cardview_3_content)
    private val location: TextView
        get() = findViewById(R.id.activity_profile_screen_cardview_4_content)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.loadProfile()
        observeData()
    }

    private fun observeData() {
        viewModel.loading.observe(this){
            loading.isVisible = it
        }
        viewModel.profile.observe(this){
            name.text = it.name.first
            number.text = it.phone
            birth.text = it.registered.date
            location.text = it.location.city
        }
    }
}