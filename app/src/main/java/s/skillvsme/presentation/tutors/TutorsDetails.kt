package s.skillvsme.presentation.tutors

import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import s.skillvsme.R
import s.skillvsme.common.Fonts
import s.skillvsme.presentation.components.BorderedSurface
import s.skillvsme.presentation.components.LanguageCard
import s.skillvsme.presentation.components.SkillvsmeText
import s.skillvsme.presentation.components.TutorsExperience
import s.skillvsme.presentation.tutors.components.TutorsDetailsAppBar
import s.skillvsme.ui.theme.black
import s.skillvsme.ui.theme.darkGrey
import s.skillvsme.ui.theme.lightGrey
import s.skillvsme.ui.theme.purple
import s.skillvsme.ui.theme.white

@Composable
fun TutorsDetails(
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
            TutorsDetailsAppBar(
                name = "Alexander Brik",
                location = "California, USA",
                time = "6:30 PM",
                backgroundColor = black,
                backgroundImage = painterResource(id = R.drawable.top_blackish_bg),
                profileImage = painterResource(id = R.drawable.teacher),
                onClick = {}
            )
        }
        Column (
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
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.rate_star),
                        contentDescription = "rate star"
                    )
                    Text(
                        text = "5.0",
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        fontFamily = Fonts.jostFontFamily,
                        )
                }
                Divider(
                    modifier = Modifier
                        .width(1.dp)
                        .height(32.dp),
                    thickness = 1.dp
                )
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(text = "45+", fontWeight = FontWeight.Bold, fontSize = 18.sp, fontFamily = Fonts.jostFontFamily)
                    Text(text = "hrs", fontWeight = FontWeight.Bold, fontSize = 18.sp, fontFamily = Fonts.jostFontFamily)
                }
                Divider(
                    modifier = Modifier
                        .width(1.dp)
                        .height(32.dp),
                    thickness = 1.dp
                )
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(text = "155+", fontWeight = FontWeight.Bold, fontSize = 18.sp, fontFamily = Fonts.jostFontFamily)
                    Text(text = "classes", fontWeight = FontWeight.Bold, fontSize = 18.sp, fontFamily = Fonts.jostFontFamily)
                }
                Divider(
                    modifier = Modifier
                        .width(1.dp)
                        .height(32.dp),
                    thickness = 1.dp
                )
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Image(
                        modifier = Modifier
                            .size(30.dp),
                        painter = painterResource(id = R.drawable.video),
                        contentDescription = "rate star"
                    )
                    Text(text = "watch", fontWeight = FontWeight.Bold, fontSize = 18.sp, fontFamily = Fonts.jostFontFamily)
                }
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
            // Languages
            SkillvsmeText(
                value = "Languages",
                valueColor = purple,
                boldValue = true
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier.horizontalScroll(rememberScrollState())
            ) {
                LanguageCard(language = "English (Native)")
                Spacer(modifier = Modifier.width(8.dp))
                LanguageCard(language = "French (fluent)")
                Spacer(modifier = Modifier.width(8.dp))
                LanguageCard(language = "German (fluent)")
                Spacer(modifier = Modifier.width(8.dp))
                LanguageCard(language = "Spanish (Intermediate)")
            }
            // Experience
            Spacer(modifier = Modifier.height(16.dp))
            SkillvsmeText(
                value = "Experience",
                valueColor = purple,
                boldValue = true
            )
            Spacer(modifier = Modifier.height(8.dp))
            Column {
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
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                SkillvsmeText(
                    value = "Student Reviews",
                    valueColor = purple,
                    boldValue = true
                )
                SkillvsmeText(
                    value = "See All",
                    valueColor = purple
                )
            }
        }
    }
}