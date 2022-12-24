package com.example.socialmedia

import android.os.Bundle
import android.view.Gravity.apply
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement.Absolute.spacedBy
import androidx.compose.foundation.layout.Arrangement.spacedBy
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.socialmedia.data.FriendData
import com.example.socialmedia.data.MessageData
import com.example.socialmedia.model.Friend
import com.example.socialmedia.model.Message
import com.example.socialmedia.ui.theme.SocialMediaTheme
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SocialMediaTheme(darkTheme = false) {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    SocialMediaApp()
                }
            }
        }
    }
}

@Composable
fun SocialMediaApp() {
    HomeScreen()
}

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier.padding(8.dp, 16.dp)
    ) {
        NavBar()
        Greeting(username = R.string.username)
        FriendsList()
        MessageSection()
    }
}

@Preview
@Composable
fun NavBar() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth().padding(16.dp, 0.dp),
    ) {
        Image(
            painter = painterResource(id = R.drawable.profile4),
            contentDescription = stringResource(id = R.string.profile_pictures),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
        )
        Icon(
            painter = painterResource(id = R.drawable.dots_horizontal_circle),
            contentDescription = stringResource(id = R.string.settings),
            modifier = Modifier
                .size(24.dp)
                .clip(CircleShape)
        )
    }
}

@Composable
fun Greeting(@StringRes username: Int) {
    Text(
        modifier = Modifier.padding(16.dp, 12.dp),
        text = "Hi ${stringResource(id = username)}",
        style = MaterialTheme.typography.body1,
        fontSize = 40.sp
    )
}

@Composable
fun SearchBar() {
//    TextField(value = , onValueChange = ) {
//        Row
//    }
}

@Composable
fun FriendsList() {
    val friendsList = FriendData().loadFriends()
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(18.dp)
    ) {
        items(friendsList.size) {
            FriendProfile(friendsList[it])
        }
    }
}

@Composable
fun FriendProfile( friend: Friend ) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = painterResource(id = friend.imageSource),
            contentDescription = stringResource(id = R.string.profile_pictures),
            modifier = Modifier
                .clip(CircleShape)
                .size(64.dp),
            contentScale = ContentScale.Crop,
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = "${friend.firstName}",
            style = MaterialTheme.typography.body2,
        )
    }
}

@Composable
fun MessageSection() {
    val messages = MessageData().loadMessages()
    Column() {
        Text(
            text = stringResource(id = R.string.last_message),
            style = MaterialTheme.typography.body2
        )
        MessageList(messages = messages)
    }
}

@Composable
fun MessageList(messages: List<Message>) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        items(messages.size) {
            Divider(color = Color.LightGray, modifier = Modifier.fillMaxWidth().height(0.5.dp))
            MessageCard(message = messages[it])
        }
    }
}

@Composable
fun MessageCard(message: Message) {
    val friends = FriendData().loadFriends()
    val friend = friends.first { it.emailAddress == message.senderEmailAddress }
    Row(
        modifier = Modifier.padding(0.dp, 8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.Top,
    ) {
        Image(
            painter = painterResource(id = friend.imageSource),
            contentDescription = "${friend.firstName} Profile Picture",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop,
        )
        Column() {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top
            ) {
                Column() {
                    Text(
                        text = "${friend.firstName} ${friend.lastName}",
                        style = MaterialTheme.typography.body1,
                        fontSize = 20.sp,
                    )
                    Text(
                        text = "${message.title}",
                        style = MaterialTheme.typography.body1,
                        fontSize = 16.sp,
                    )
                }
                Text(
                    text = "${message.timeCreated}",
                    style = MaterialTheme.typography.body2,
                )
            }
            Text(
                text = "${message.messageContent}",
                style = MaterialTheme.typography.body2,
                fontSize = 18.sp,
            )
        }
    }
}