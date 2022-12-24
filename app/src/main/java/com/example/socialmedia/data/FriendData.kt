package com.example.socialmedia.data

import com.example.socialmedia.R
import com.example.socialmedia.model.Friend

class FriendData {
    fun loadFriends(): List<Friend> {
        return listOf<Friend>(
            Friend("Jonathan", "Banks", "jonathan.banks@gmail.com", R.drawable.profile1),
            Friend("Veronica", "Smith", "veronica.smith@gmail.com", R.drawable.profile2),
            Friend("Jessica", "Booker", "jessica.booker@gmail.com", R.drawable.profile3),
            Friend("Joe", "Griffin", "joe.griffin@gmail.com", R.drawable.profile4),
            Friend("Catherine", "", "catherine@gmail.com", R.drawable.profile5),
            Friend("Phyllis", "", "phyllis@gmail.com", R.drawable.profile6),
            Friend("Benjamin", "Franklin", "benjamin.franklin@gmail.com", R.drawable.profile7),
        )
    }
}