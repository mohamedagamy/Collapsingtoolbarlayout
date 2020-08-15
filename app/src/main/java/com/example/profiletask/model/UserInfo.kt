package com.example.profiletask.model

data class UserInfo(
    val bio: String,
    val counts: Counts,
    val full_name: String,
    val id: Int,
    val location: String,
    val profile_picture: String
)