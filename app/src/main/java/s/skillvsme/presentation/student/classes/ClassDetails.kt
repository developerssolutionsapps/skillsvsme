package s.skillvsme.presentation.student.classes

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import s.skillvsme.R
import s.skillvsme.common.Fonts
import s.skillvsme.common.Route
import s.skillvsme.presentation.student.classes.components.ClassesDetailsAppBar
import s.skillvsme.presentation.components.SkillvsmeText
import s.skillvsme.presentation.student.navigation.BottomNavigation
import s.skillvsme.ui.theme.black
import s.skillvsme.ui.theme.lightGrey
import s.skillvsme.ui.theme.purple

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@RequiresApi(Build.VERSION_CODES.Q)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ClassDetails(
    navController: NavController
) {
    Scaffold(
        content = {
            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
            ) {
                Column(
                    modifier = Modifier
                ) {
                    // Tutors details app bar
                    ClassesDetailsAppBar(
                        tutorsName = "Alexander Brik",
                        timeLine = "11:00 AM - 12:30 PM",
                        backgroundColor = black,
                        backgroundImage = painterResource(id = R.drawable.background_lines),
                        tutorsProfileImage = painterResource(id = R.drawable.profile2),
                        myProfileImage = painterResource(id = R.drawable.student_profile),
                        onClick = {
                            navController.navigate(Route.Student.Classes.ClassRoom)
                        },
                        navController = navController
                    )
                    Spacer(modifier = Modifier.height(32.dp))
                    Text(
                        text = "About the tutor",
                        color = purple,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 20.sp,
                        modifier = Modifier
                            .padding(horizontal = 20.dp)
                            .fillMaxWidth(),
                        fontFamily = Fonts.jostFontFamily,
                        textAlign = TextAlign.Start
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    Row(
                        modifier = Modifier
                            .padding(horizontal = 20.dp)
                    ) {
                        Column(){
                            Box(
                                modifier = Modifier
                                    .height(100.dp)
                                    .width(80.dp),
                                contentAlignment = Alignment.BottomCenter
                            ) {
                                Surface(
                                    shape = RoundedCornerShape(24.dp)
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.profile2),
                                        contentDescription = "profile photo",
                                        contentScale = ContentScale.Crop
                                    )
                                }
                                Box(
                                    modifier = Modifier
                                        .graphicsLayer {
                                            translationY = -6.dp.toPx()
                                            translationX = +6.dp.toPx()
                                        }
                                        .align(Alignment.TopEnd)
                                ) {
                                    Image(
                                        modifier = Modifier
                                            .size(24.dp),
                                        painter = painterResource(id = R.drawable.verified),
                                        contentDescription = null
                                    )
                                }
                                Box(
                                    modifier = Modifier
                                        .graphicsLayer {
                                            translationY = +20.dp.toPx()
                                        }
                                        .fillMaxWidth()
                                        .background(lightGrey, RoundedCornerShape(20.dp))
                                        .align(Alignment.BottomCenter)
                                ) {
                                    Row(
                                        modifier = Modifier
                                            .padding(horizontal = 8.dp, vertical = 4.dp),
                                        horizontalArrangement = Arrangement.Center,
                                        verticalAlignment = Alignment.CenterVertically
                                    ){
                                        Image(
                                            modifier = Modifier
                                                .size(16.dp),
                                            painter = painterResource(id = R.drawable.rate_star),
                                            contentDescription = null
                                        )
                                        Text(
                                            text = "5.0",
                                            fontSize = 14.sp,
                                            modifier = Modifier
                                                .padding(4.dp),
                                            fontFamily = Fonts.jostFontFamily
                                        )
                                    }
                                }
                            }
                        }
                        Column(
                            modifier = Modifier
                                .padding(horizontal = 12.dp)
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(
                                    text = "Alexander Brik",
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    modifier = Modifier
                                        .padding(4.dp),
                                    fontFamily = Fonts.jostFontFamily
                                )
                            }
                            SkillvsmeText(
                                value = "Experienced and dedicated language tutor passionate about helping students unlock their linguistic potential. Skilled in creating personalized learning Pla...",
                                valueSize = 16
                            )
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.height(100.dp))

        },
        bottomBar = {
            BottomNavigation(navController = navController)
        }
    )
}