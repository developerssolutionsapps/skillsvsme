package s.skillvsme.presentation.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import s.skillvsme.R
import s.skillvsme.common.Fonts
import s.skillvsme.common.Route
import s.skillvsme.common.SetStatusBarColor
import s.skillvsme.presentation.components.SkillvsmeButton
import s.skillvsme.ui.theme.white

@Composable
fun Onboarding1(
    navController: NavController
) {
    SetStatusBarColor(color = white)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.weight(0.5f))
        Column(
            modifier = Modifier
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_onboarding_1),
                contentDescription = "Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                contentScale = ContentScale.FillWidth
            )

            Text(
                fontFamily = Fonts.jostFontFamily,
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth(),
                text = "Connect with international tutors and students around the world",
                style = MaterialTheme.typography.body1,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Center
            )

        }
        Spacer(modifier = Modifier.weight(0.5f))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            SkillvsmeButton(
                label = "Skip",
                modifier = Modifier
                    .weight(1f),
                primary = false,
                onClick = {
                    navController.navigate(Route.Student.Onboarding.JoinAS)
                }
            )
            Spacer(modifier = Modifier.width(15.dp))
            SkillvsmeButton(
                label = "Next",
                modifier = Modifier
                    .weight(1f),
                onClick = {
                    navController.navigate(Route.Student.Onboarding.Onboarding2)
                }
            )
        }
        Spacer(modifier = Modifier.height(49.dp))
    }
}
