package s.skillvsme.presentation.tutors.streaming

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import s.skillvsme.R
import s.skillvsme.common.Fonts
import s.skillvsme.common.Route
import s.skillvsme.ui.theme.black
import s.skillvsme.ui.theme.white

@RequiresApi(Build.VERSION_CODES.Q)
@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterialApi::class)
@Composable
fun StreamingPreview(
    navController:NavController
){
    Scaffold(
        content = { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Image(
                    modifier = Modifier
                        .fillMaxSize(),
                    contentScale = ContentScale.Crop,
                    painter = painterResource(id = R.drawable.student),
                    contentDescription = null
                )
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
                                        color = white,
                                        fontSize = 20.sp
                                    )
                                }
                            }
                        }
                        Surface(
                            modifier = Modifier
                                .size(30.dp),
                            shape = RoundedCornerShape(percent = 50),
                            color = black
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
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 33.dp, top = 10.dp),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            modifier = Modifier.size(48.dp),
                            painter = painterResource(id = R.drawable.audio_recorder),
                            contentDescription = null
                        )
                        Spacer(modifier = Modifier.width(28.dp))
                        Image(
                            modifier = Modifier.size(56.dp)
                                .clickable {
                                   navController.navigate(Route.Tutor.Streaming.LiveStream)
                                },
                            painter = painterResource(id = R.drawable.start_recording),
                            contentDescription = null
                        )
                        Spacer(modifier = Modifier.width(28.dp))
                        Image(
                            modifier = Modifier.size(48.dp),
                            painter = painterResource(id = R.drawable.video_recorder),
                            contentDescription = null
                        )
                    }
                }
            }
        },
    )
}