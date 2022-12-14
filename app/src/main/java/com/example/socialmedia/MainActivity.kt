package com.example.socialmedia

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.socialmedia.ui.theme.SocialMediaTheme

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
    Column {
        NavBar()
        Greeting(username = R.string.username)
    }
}

@Preview
@Composable
fun NavBar() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = R.drawable.profile1),
            contentDescription = stringResource(id = R.string.profile_pictures),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .border(2.dp, Color.Gray, CircleShape)
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
        text = "Hi ${stringResource(id = username)}",
//        style = MaterialTheme.typography.body1,
        fontWeight = FontWeight.Black,
        fontFamily = FontFamily.Monospace,
        fontSize = 40.sp,
    )
}