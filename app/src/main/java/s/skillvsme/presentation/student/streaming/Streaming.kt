package s.skillvsme.presentation.streaming

import android.annotation.SuppressLint
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
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
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
import s.skillvsme.common.Route
import s.skillvsme.common.SetStatusBarColor
import s.skillvsme.presentation.components.SimpleAppBar
import s.skillvsme.presentation.components.SkillvsmeLiveTag
import s.skillvsme.presentation.student.navigation.BottomNavigation
import s.skillvsme.ui.theme.lightGrey
import s.skillvsme.ui.theme.white

@RequiresApi(Build.VERSION_CODES.Q)
@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Streaming(
    navController:NavController
){
    SetStatusBarColor(color = white)
    Scaffold (
        topBar = {
            SimpleAppBar(navController = navController, text = "Live now")
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .padding(paddingValues)
            ) {
                Column(
                    modifier = Modifier
                        .padding(20.dp)
                        .verticalScroll(rememberScrollState())
                ) {
                    repeat(4) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceEvenly,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            repeat(3) {
                                Box(
                                    modifier = Modifier
                                        .weight(1f)
                                        .fillMaxWidth()
                                        .padding(6.dp)
                                        .wrapContentHeight()
                                        .background(lightGrey, RoundedCornerShape(8.dp))
                                        .clickable {
                                            navController.navigate(Route.Student.Streaming.ViewLiveStream)
                                        },
                                    contentAlignment = Alignment.Center
                                ) {
                                    Column(
                                        modifier = Modifier
                                            .padding(
                                                top = 14.dp,
                                                bottom = 4.dp,
                                                start = 8.dp,
                                                end = 8.dp
                                            ),
                                        horizontalAlignment = Alignment.CenterHorizontally
                                    ) {
                                        // Rounded image view
                                        Box(
                                            modifier = Modifier
                                                .size(65.dp),
                                            contentAlignment = Alignment.BottomCenter
                                        ) {
                                            Image(
                                                painter = painterResource(id = R.drawable.rectangle4),
                                                contentDescription = "",
                                                modifier = Modifier.background(
                                                    white,
                                                    CircleShape
                                                ),
                                                contentScale = ContentScale.Crop
                                            )
                                            SkillvsmeLiveTag(
                                                fontSize = 10,
                                                textModifier = Modifier
                                                    .padding(horizontal = 8.dp)
                                            )
                                            // Image
                                        }
                                        // Live tag
                                        Spacer(modifier = Modifier.height(7.dp))
                                        androidx.compose.material.Text(
                                            text = "John Wills", color = Color.Black,
                                            fontSize = 15.sp,
                                            fontWeight = FontWeight.Normal,
                                            fontFamily = Fonts.jostFontFamily,
                                            modifier = Modifier.padding(6.dp)
                                        )
                                    }
                                }
                                Spacer(modifier = Modifier.width(8.dp))
                            }
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