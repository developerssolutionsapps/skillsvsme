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
import s.skillvsme.presentation.components.SkillvsmeButton

@Composable
fun Onboarding2(
    navController: NavController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_onboarding_2),
                contentDescription = "Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                contentScale = ContentScale.FillWidth
            )
            Text(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth(),
                text = "Schedule classes with one click at your own convenience",
                style = MaterialTheme.typography.body1,
                fontWeight = FontWeight.Normal,
                fontFamily = Fonts.jostFontFamily,
                textAlign = TextAlign.Center
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            SkillvsmeButton(
                label = "Skip",
                modifier = Modifier.weight(1f),
                primary = false,
                onClick = {
                    navController.navigate(Route.Student.Onboarding.JoinAS)
                }
            )
            SkillvsmeButton(
                label = "Next",
                modifier = Modifier.weight(1f),
                onClick = {
                    navController.navigate(Route.Student.Onboarding.Onboarding3)
                }
            )
        }
    }
}