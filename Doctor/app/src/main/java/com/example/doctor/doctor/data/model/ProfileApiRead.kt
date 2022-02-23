package com.example.doctor.doctor.data.model

data class ProfileResponse (val results: List<ProfileItem>)
data class ProfileItem(val name: ProfileName, val phone: String, val birthday: ProfileRegister, val location: ProfileLocation)
data class ProfileName(val firstName: String, val lastName: String)
data class ProfileRegister(val date: String)
data class ProfileLocation(val city: String)
