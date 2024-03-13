package s.skillvsme.presentation.tutors.TutorsProfile

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import s.skillvsme.R
import s.skillvsme.common.Fonts
import s.skillvsme.common.Route
import s.skillvsme.common.SetStatusBarColor
import s.skillvsme.presentation.components.EditTextLabel
import s.skillvsme.presentation.components.ProfileAppBar
import s.skillvsme.presentation.components.SkillvsmeButton
import s.skillvsme.presentation.components.SkillvsmeText
import s.skillvsme.presentation.components.TutorsExperience
import s.skillvsme.presentation.tutors.navigation.BottomNavigation
import s.skillvsme.ui.theme.black
import s.skillvsme.ui.theme.purple

@RequiresApi(Build.VERSION_CODES.Q)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterialApi::class)
@Composable
fun EditProfile(
    navController: NavController
) {
    SetStatusBarColor(color = Color.Transparent)
    val  scrollState= rememberScrollState()
    Scaffold(
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(scrollState),
                verticalArrangement = Arrangement.SpaceAround,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                ProfileAppBar(
                    backgroundColor = Color.Black,
                    modifier = Modifier,
                    backgroundImage = painterResource(
                        id = R.drawable.rectangle6,
                    ),
                    contentSize = 151.dp,
                    bottomCornerRadius = 30.dp,
                    navController = navController
                )
                Spacer(modifier = Modifier.weight(1f))
                Column(modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 40.dp, start = 16.dp, end = 16.dp),) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize(),
                    ) {
                        Spacer(modifier = Modifier.height(25.dp))
                        Text(
                            text = "Kamal Tyagi",
                            fontWeight = FontWeight.Bold,
                            fontSize = 25.sp,
                            modifier = Modifier.align(Alignment.CenterHorizontally)
                        )
                        Text(
                            text = "See public view",
                            fontWeight = FontWeight.Normal,
                            fontSize = 18.sp,
                            color= purple,
                            textDecoration = TextDecoration.Underline,
                            modifier = Modifier
                                .align(Alignment.CenterHorizontally)
                                .clickable {
                                    navController.navigate(Route.Tutor.Profile.TutorProfilePublicView)
                                }
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        EditTextLabel(value = "Kamal Tyagi", text = "User Name")
                        Spacer(modifier = Modifier.height(24.dp))
                        EditTextLabel(value = "+999 45821365479", text = "Phone Number")
                        Spacer(modifier = Modifier.height(24.dp))
                        EditTextLabel(value = "Califonia, USA", text = "Location")
                        Spacer(modifier = Modifier.height(24.dp))
                        EditTextLabel(value = "Experienced and dedicated language\n" +
                                "tutor passionate about helping students\n" +
                                "unlock their linguistic potential. Skilled\n" +
                                "in creating personalized learning plans,\n" +
                                "fostering a supportive environment, and\n" +
                                "utilizing innovative teaching methods to\n" +
                                "enhance language proficiency.\n" +
                                "Committed to empowering students to\n" +
                                "communicate confidently and fluently in\n" +
                                "their target language.", text = "Bio", isLongText = true)
                        Spacer(modifier = Modifier.height(24.dp))
                        Row (verticalAlignment = Alignment.CenterVertically){
                            Text(text = "Work Experience",fontSize = 18.sp,
                                fontFamily = Fonts.jostFontFamily,
                                fontWeight = FontWeight.Normal,)
                            Spacer(modifier = Modifier.weight(1f))
                            FloatingActionButton(
                                onClick = { /* Handle floating button click */ },
                                modifier = Modifier
                                    .size(25.dp),
                                backgroundColor = black,
                                shape = CircleShape

                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.addition),
                                    contentDescription = "Add",
                                    tint = Color.White
                                )
                            }
                        }
                        Spacer(modifier = Modifier.height(24.dp))
                        TutorsExperience(
                            title = "English Professor",
                            timeline = "2014 - Present",
                            institution = "Cambridge University"
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        TutorsExperience(
                            title = "Private English Tutor",
                            timeline = "2012 - 2014",
                            institution = "Self-employed"
                        )
                        Spacer(modifier = Modifier.height(40.dp))
                        SkillvsmeButton(label = "Save Changes", modifier = Modifier.fillMaxWidth()) {
                        }
                        Spacer(modifier = Modifier.height(20.dp))
                        SkillvsmeButton(
                            label = "Back",
                            modifier = Modifier.fillMaxWidth(),
                            primary = false,
                            onClick = {
                                navController.popBackStack()
                            }
                        )
                        Spacer(modifier = Modifier.height(120.dp))
                    }
                }

            }
        },
        bottomBar = {
            BottomNavigation(navController = navController)
        }
    )
}

