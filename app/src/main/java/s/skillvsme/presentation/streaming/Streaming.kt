package s.skillvsme.presentation.streaming

import android.annotation.SuppressLint
import android.os.Build
import android.support.v4.os.IResultReceiver.Default
import android.widget.EditText
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import s.skillvsme.R
import s.skillvsme.common.Fonts
import s.skillvsme.presentation.components.SkillvsmeLiveTag
import s.skillvsme.presentation.homeScreen.navigation.BottomNavigation
import s.skillvsme.ui.theme.black
import s.skillvsme.ui.theme.white

@RequiresApi(Build.VERSION_CODES.Q)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun streaming(
    navController:NavController
){
    Scaffold (
        content = { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Column(
                    modifier = Modifier
                        .padding(paddingValues)
                        .padding(20.dp)
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.Start
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(65.dp),
                                contentAlignment = Alignment.BottomCenter
                            ) {
                                Surface(
                                    modifier = Modifier
                                        .size(65.dp),
                                    shape = RoundedCornerShape(percent = 50)
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.student),
                                        contentDescription = "",
                                        modifier = Modifier.background(
                                            white,
                                            CircleShape
                                        ),
                                        contentScale = ContentScale.Crop
                                    )
                                }
                                SkillvsmeLiveTag(
                                    fontSize = 10,
                                    textModifier = Modifier
                                        .padding(horizontal = 8.dp)
                                )
                            }
                            Spacer(modifier = Modifier.width(20.dp))
                            Column(
                                verticalArrangement = Arrangement.SpaceEvenly
                            ) {
                                Row {
                                    Text(
                                        text = "Keria Swain",
                                        fontWeight = FontWeight.SemiBold,
                                        fontFamily = Fonts.jostFontFamily,
                                        fontSize = 20.sp
                                    )
                                    Spacer(modifier = Modifier.width(20.dp))
                                    Image(
                                        painter = painterResource(id = R.drawable.follow_1),
                                        contentDescription = null,
                                        modifier = Modifier
                                            .size(24.dp)
                                    )
                                }
                                Spacer(modifier = Modifier.height(4.dp))
                                Surface(
                                    shape = RoundedCornerShape(8.dp),
                                    color = black
                                ) {
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically,
                                        horizontalArrangement = Arrangement.SpaceEvenly,
                                        modifier = Modifier
                                            .padding(horizontal = 2.dp, vertical = 4.dp)
                                            .padding(end = 6.dp)
                                    ) {
                                        Image(
                                            painter = painterResource(id = R.drawable.followers),
                                            contentDescription = null,
                                            modifier = Modifier
                                                .size(24.dp)
                                        )
                                        Text(
                                            text = "1996",
                                            fontWeight = FontWeight.Bold,
                                            fontFamily = Fonts.jostFontFamily,
                                            fontSize = 12.sp
                                        )
                                    }
                                }
                            }
                        }
                        Surface(
                            modifier = Modifier
                                .size(30.dp),
                            shape = RoundedCornerShape(percent = 50),
                            color = black.copy(alpha = 0.3f)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.close),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(24.dp)
                            )
                        }
                    }
                    Row(
                        verticalAlignment = Alignment.Bottom,
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier
                            .wrapContentHeight()
                            .fillMaxWidth(),
                    ) {
                        Column(
                            verticalArrangement = Arrangement.Bottom,
                            modifier = Modifier
                                .weight(1f)
                                .padding(end = 20.dp)
                        ) {
                            StreamingChat(
                                name = "Sally Ed",
                                text = "Hello there"
                            )
                            StreamingChat(
                                name = "Cid Park",
                                text = "I was waiting for this live.."
                            )
                            StreamingChat(
                                name = "Fatima Adel",
                                text = "Your video is super hel..."
                            )
                            StreamingChat(
                                name = "Anne Wayte",
                                text = "Very nice"
                            )
                            Spacer(modifier = Modifier.height(20.dp))
                            Row(
                                modifier = Modifier
                                    .wrapContentHeight()
                                    .weight(1f, fill = false)
                            ) {
                                OutlinedTextField(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(TextFieldDefaults.MinHeight),
                                    value = "",
                                    colors = TextFieldDefaults.textFieldColors(
                                        containerColor = black,
                                    ),
                                    shape = RoundedCornerShape(40),
                                    onValueChange = {},
                                    placeholder = {
                                        Text(
                                            modifier = Modifier
                                                .weight(1f),
                                            text = "Write a comment",
                                            fontFamily = Fonts.jostFontFamily,
                                            fontSize = 18.sp,
                                            color = white
                                        )
                                    },
                                    trailingIcon = {
                                        Image(
                                            painter = painterResource(id = R.drawable.send),
                                            contentDescription = null,
                                            modifier = Modifier
                                                .size(48.dp)
                                                .padding(end = 4.dp, bottom = 4.dp)
                                        )
                                    }
                                )
                            }
                        }
                        Column(
                            modifier = Modifier
                                .wrapContentWidth()
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.unmute),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(48.dp)
                            )
                            Spacer(modifier = Modifier.height(10.dp))
                            Image(
                                painter = painterResource(id = R.drawable.warning),
                                contentDescription = null
                            )
                            Spacer(modifier = Modifier.height(10.dp))
                            Image(
                                painter = painterResource(id = R.drawable.user2),
                                contentDescription = null
                            )
                            Spacer(modifier = Modifier.height(10.dp))
                            Image(
                                painter = painterResource(id = R.drawable.gift),
                                contentDescription = null
                            )
                        }
                    }
                }
            }
        },
        bottomBar = {
            BottomNavigation(navController = navController)
        }
    )
}

@Composable
fun StreamingChat(
    name: String,
    text: String
){
    Row(
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Surface(
            modifier = Modifier
                .size(40.dp),
            shape = RoundedCornerShape(20.dp),
            color = Color.Magenta
        ) {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = name.first().toString(),
                    fontFamily = Fonts.jostFontFamily,
                    fontSize = 24.sp,
                    color = white
                )
            }
        }
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(horizontal = 8.dp, vertical = 4.dp),
            shape = RoundedCornerShape(16.dp),
            color = black.copy(alpha = 0.3f)
        ) {
            Column(
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 8.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth(),
                    text = name,
                    fontFamily = Fonts.jostFontFamily,
                    fontSize = 14.sp,
                    color = white,
                    maxLines = 1
                )
                Text(
                    modifier = Modifier
                        .fillMaxWidth(),
                    text = text,
                    fontFamily = Fonts.jostFontFamily,
                    fontSize = 14.sp,
                    color = white,
                    maxLines = 1
                )
            }
        }
    }
}