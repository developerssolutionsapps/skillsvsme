package s.skillvsme.presentation.student.streaming

import android.os.Build
import androidx.activity.compose.BackHandler
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
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomSheetScaffold
import androidx.compose.material.BottomSheetState
import androidx.compose.material.BottomSheetValue
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.rememberBottomSheetScaffoldState
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlinx.coroutines.launch
import s.skillvsme.R
import s.skillvsme.common.Fonts
import s.skillvsme.presentation.components.SkillvsmeButton
import s.skillvsme.presentation.components.SkillvsmeLiveTag
import s.skillvsme.ui.theme.black
import s.skillvsme.ui.theme.darkGrey
import s.skillvsme.ui.theme.white

@RequiresApi(Build.VERSION_CODES.Q)
@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterialApi::class)
@Composable
fun StreamingScreen(
    navController:NavController
) {
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
                    Column(
                        verticalArrangement = Arrangement.Top
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
                                            color = white,
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
                        Image(painter = painterResource(id = R.drawable.recording_timer), contentDescription = null)
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
                            Spacer(modifier = Modifier.height(8.dp))
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
                                    modifier = Modifier.size(56.dp),
                                    painter = painterResource(id = R.drawable.pause_recording),
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
                }
            }
        },
    )
}