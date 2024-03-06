package s.skillvsme.presentation.onboarding

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
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
import s.skillvsme.presentation.components.SkillvsmeButton
import s.skillvsme.presentation.navigation.LoginDetails
import s.skillvsme.ui.theme.lightGrey
import s.skillvsme.ui.theme.purple
import s.skillvsme.ui.theme.white

@Composable
fun JoinAs(
    navController: NavController,
    loginDetails: LoginDetails
) {
    SetStatusBarColor(color = white)
    Column(
        modifier = Modifier
            .padding(20.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Spacer(modifier = Modifier.weight(0.32f))
        // Logo
        Image(
            painter = painterResource(id = R.drawable.logo), // Replace with your logo
            contentDescription = "Logo",
            modifier = Modifier
                .padding(top = 32.dp)
                .size(120.dp)
        )
        Spacer(modifier = Modifier.weight(0.76f))
        // Welcome text
        Text(
            fontFamily = Fonts.jostFontFamily,
            text = "Join Skillvsme as",
            style = MaterialTheme.typography.h4
        )
        Spacer(modifier = Modifier.weight(0.26f))
        var tutorSelected by remember { mutableStateOf(false) }
        var studentSelected by remember { mutableStateOf(false) }
        // Horizontal row of images with text below
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            // Select Join As Tutor Image
            Column() {
                Column(
                    modifier = Modifier
                        .padding(6.dp)
                        .noRippleClickable {
                            studentSelected = false
                            tutorSelected = true
                            loginDetails.loginAsTutor()
                        },
                ) {
                    Surface(
                        shape = CircleShape,
                        color = lightGrey,
                        border = BorderStroke(
                            width = 2.dp,
                            color = if (tutorSelected) purple else white
                        )
                    ) {
                        Box(
                            modifier = Modifier
                                .size(150.dp),
                            contentAlignment = Alignment.BottomCenter
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.teacher),
                                contentDescription = "Tutor",
                                modifier = Modifier
                                    .size(112.dp),
                                contentScale = ContentScale.Crop
                            )
                        }
                    }
                }
                Spacer(modifier = Modifier.height(30.dp))
                Text(
                    fontFamily = Fonts.jostFontFamily,
                    text = "Tutor",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 24.sp,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                )
            }
            // Select Join As Student Image
            Column() {
                Column(
                    modifier = Modifier
                        .padding(6.dp)
                        .noRippleClickable {
                            studentSelected = true
                            tutorSelected = false
                            loginDetails.loginAsStudents()
                        },
                ) {
                    Surface(
                        shape = CircleShape,
                        color = lightGrey,
                        border = BorderStroke(
                            width = 2.dp,
                            color = if (studentSelected) purple else white
                        )
                    ) {
                        Box(
                            modifier = Modifier
                                .size(150.dp),
                            contentAlignment = Alignment.BottomCenter
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.womens_voice),
                                contentDescription = "Student",
                                modifier = Modifier
                                    .size(103.dp),
                                contentScale = ContentScale.Crop
                            )
                        }
                    }
                }
                Spacer(modifier = Modifier.height(30.dp))
                Text(
                    fontFamily = Fonts.jostFontFamily,
                    text = "Student",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 24.sp,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                )
            }
        }
        Spacer(modifier = Modifier.weight(1.8f))
        SkillvsmeButton(
            enabled = studentSelected || tutorSelected,
            modifier = Modifier
                .fillMaxWidth(),
            label = "Start",
            onClick = {
                navController.navigate(Route.Student.Onboarding.SignUp)
            }
        )
        Spacer(modifier = Modifier.height(49.dp))
    }
}
@SuppressLint("ModifierFactoryUnreferencedReceiver")
@Composable
fun Modifier.noRippleClickable(onClick: () -> Unit): Modifier = composed {
    clickable(indication = null,
        interactionSource = remember { MutableInteractionSource() }) {
        onClick()
    }
}