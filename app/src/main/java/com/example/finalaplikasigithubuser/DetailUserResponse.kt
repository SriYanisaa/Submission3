package com.example.finalaplikasigithubuser

import com.google.gson.annotations.SerializedName

data class DetailUserResponse(
	val name: String,
	val login: String,
	val id: Int,
	val avatar_url: String,
    val follower_url: String,
    val following_url: String,
    val location: String,
    val company: String,
    val followers: Int,
    val following: Int
)
