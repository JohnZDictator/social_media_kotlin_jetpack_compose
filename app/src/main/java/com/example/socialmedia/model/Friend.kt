package com.example.socialmedia.model

import androidx.annotation.DrawableRes

data class Friend(
    val firstName: String,
    val lastName: String,
    val emailAddress: String,
    @DrawableRes val imageSource: Int,
)
