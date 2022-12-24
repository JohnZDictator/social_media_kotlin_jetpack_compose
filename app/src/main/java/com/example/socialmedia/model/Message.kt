package com.example.socialmedia.model

data class Message(
    val senderEmailAddress: String,
    val title: String,
    val messageContent: String,
    val timeCreated: String,
)
