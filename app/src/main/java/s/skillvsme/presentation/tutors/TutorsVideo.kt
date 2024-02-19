package s.skillvsme.presentation.tutors

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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import s.skillvsme.R
import s.skillvsme.presentation.components.SkillvsmeButton
import s.skillvsme.presentation.components.SkillvsmeText
import s.skillvsme.presentation.tutors.components.TutorsDetailsAppBar
import s.skillvsme.ui.theme.black
import s.skillvsme.ui.theme.purple


@Composable
fun TutorsVideo(
    navController: NavController
) {
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
    ) {
        Column(
            modifier = Modifier
        ) {
            // Tutors details app bar
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
                    .background(
                        color = black
                    )
            ){
                Image(
                    painter = painterResource(id = R.drawable.play_circle_filled_white),
                    contentDescription = "play icon",
                    modifier = Modifier
                        .align(Alignment.Center)
                )
            }
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .height(40.dp)
                        .width(40.dp)
                ){
                    Image(
                        modifier = Modifier.fillMaxSize(),
                        painter = painterResource(id = R.drawable.person_add_black),
                        contentDescription = "add contact"
                    )
                }
                Spacer(modifier = Modifier.width(16.dp))
                SkillvsmeButton(
                    modifier = Modifier
                        .fillMaxWidth(),
                    label = "Schedule",
                    primary = true
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            // Bio
            SkillvsmeText(
                label = "Bio",
                boldLabel = true,
                labelColor = purple,
                value = "Experienced and dedicated language tutor passionate about helping students unlock their linguistic potential. Skilled in creating personalized learning plans, fostering a supportive environment, and utilizing innovative teaching methods to enhance language proficiency. Committed to empowering students to communicate confidently and fluently in their target language."
            )
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}