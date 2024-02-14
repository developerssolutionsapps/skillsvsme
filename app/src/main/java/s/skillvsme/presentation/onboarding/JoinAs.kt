package s.skillvsme.presentation.onboarding

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import s.skillvsme.R
import s.skillvsme.common.Fonts
import s.skillvsme.common.Route
import s.skillvsme.presentation.components.SkillvsmeButton
import s.skillvsme.ui.theme.black
import s.skillvsme.ui.theme.lightGrey
import s.skillvsme.ui.theme.purple
import s.skillvsme.ui.theme.white

@Composable
fun JoinAs(
    navController: NavController
) {
    Column(
        modifier = Modifier
            .padding(20.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Spacer(modifier = Modifier.height(32.dp))
        // Logo
        Image(
            painter = painterResource(id = R.drawable.logo), // Replace with your logo
            contentDescription = "Logo",
            modifier = Modifier
                .padding(top = 32.dp)
                .size(120.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Welcome text
        Text(
            fontFamily = Fonts.jostFontFamily,
            text = "Join Skillvsme as",
            style = MaterialTheme.typography.h4
        )

        Spacer(modifier = Modifier.height(16.dp))

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
                        .clickable {
                            studentSelected = false
                            tutorSelected = true
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
                Text(
                    fontFamily = Fonts.jostFontFamily,
                    text = "Tutor",
                    color = MaterialTheme.colors.onSurface,
                    style = MaterialTheme.typography.body2,
                    modifier = Modifier
                        .padding(bottom = 8.dp)
                        .align(Alignment.CenterHorizontally)
                )
            }
            // Select Join As Student Image
            Column() {
                Column(
                    modifier = Modifier
                        .padding(6.dp)
                        .clickable {
                            studentSelected = true
                            tutorSelected = false
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
                Text(
                    fontFamily = Fonts.jostFontFamily,
                    text = "Student",
                    color = MaterialTheme.colors.onSurface,
                    style = MaterialTheme.typography.body2,
                    modifier = Modifier
                        .padding(bottom = 8.dp)
                        .align(Alignment.CenterHorizontally)
                )
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        SkillvsmeButton(
            enabled = studentSelected || tutorSelected,
            modifier = Modifier
                .fillMaxWidth(),
            label = "Start",
            onClick = {
                navController.navigate(Route.Student.Onboarding.SignUp)
            }
        )

        Spacer(modifier = Modifier.height(32.dp))
    }
}