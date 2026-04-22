package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme
import androidx.compose.ui.Modifier

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Surface() {
                    MainPanel(name = stringResource(R.string.name), title = stringResource(R.string.title))
                }


            }
        }
    }
}

@Composable
fun MainPanel(name: String, title: String, modifier: Modifier = Modifier) {
    var logo = painterResource( R.drawable.ghost_png_36312)
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Spacer(modifier = Modifier.height(150.dp))
        Row(modifier = Modifier
            .fillMaxSize()
            .padding(16.dp), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
            Spacer(modifier = Modifier.width(85.dp))
            Box(modifier = Modifier.fillMaxSize()) {
                Image(
                    painter = logo,
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                )
                Row() {
                    Spacer(modifier = Modifier.width(40.dp))
                    Text(
                        text = name,
                        fontSize = 36.sp,
                        fontWeight = FontWeight.ExtraBold,
                        lineHeight = 590.sp,
                        textAlign = TextAlign.Center
                    )
                }
                Row() {
                    Spacer(modifier = Modifier.width(42.dp))
                    Text(
                        text = title,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Medium,
                        lineHeight = 655.sp,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
    LowerPanel(phone = stringResource(R.string.phone), email = stringResource(R.string.email), github = stringResource(R.string.github))
}

@Composable
fun LowerPanel(phone: String, email: String, github: String, ) {
    var phoneLogo = painterResource(R.drawable.phone_call_icon)
    var githubLogo = painterResource((R.drawable.github_icon))
    var emailLogo = painterResource((R.drawable.envelope_line_icon))

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {
        Spacer(modifier = Modifier.height(650.dp))
        Row() {
            Spacer(modifier = Modifier.width(20.dp))
            Box(modifier = Modifier.size(width = 380.dp, height = 1000.dp)) {
                Row(horizontalArrangement = Arrangement.Center) {
                    //Spacer(modifier = Modifier.width(40.dp))
                    Column() {
                        Row(modifier = Modifier.fillMaxWidth().border(width = 1.dp, color = Color.White)) {
                            Image(
                                painter = painterResource(R.drawable.phone_call_icon),
                                contentDescription = null,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier.size(50.dp).clip(CircleShape)
                                    .background(Color.White)
                            )
                            Spacer(modifier = Modifier.width(10.dp))
                            Text(
                                text = phone,
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Medium,
                                textAlign = TextAlign.Center,
                                modifier = Modifier.padding(top = 15.dp)
                            )
                        }
                        Spacer(modifier = Modifier.height(10.dp))
                        Row(modifier = Modifier.fillMaxWidth().border(width = 1.dp, color = Color.White)) {
                            Spacer(modifier = Modifier.height(20.dp))
                            Image(
                                painter = painterResource(R.drawable.github_icon),
                                contentDescription = null,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier.size(50.dp).clip(CircleShape)
                                    .background(Color.White)
                            )
                            Spacer(modifier = Modifier.width(10.dp))
                            Text(
                                text = github,
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Medium,
                                textAlign = TextAlign.Center,
                                modifier = Modifier.padding(top = 15.dp)
                            )
                        }
                        Spacer(modifier = Modifier.height(12.dp))
                        Row(modifier = Modifier.fillMaxWidth().border(width = 1.dp, color = Color.White)) {
                            Spacer(modifier = Modifier.height(20.dp))
                            Image(
                                painter = painterResource(R.drawable.envelope_line_icon),
                                contentDescription = null,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier.size(50.dp).clip(CircleShape)
                                    .background(Color.White)
                            )
                            Spacer(modifier = Modifier.width(10.dp))
                            Text(
                                text = email,
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Medium,
                                textAlign = TextAlign.Center,
                                modifier = Modifier.padding(top = 15.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme{
        Surface{
        MainPanel(name = stringResource(R.string.name), title = stringResource(R.string.title))
        }
    }
}