package s.skillvsme.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import s.skillvsme.R
import s.skillvsme.common.Route
import s.skillvsme.ui.theme.black
import s.skillvsme.ui.theme.purple


@Composable
fun TutorsListComponent(
    name: String,
    bio: String,
    rating: Double,
    profile: Painter,
    isLive: Boolean = true,
    navController: NavController
) {

    Row(
        modifier = Modifier
            .clickable {
                navController.navigate(Route.Student.Tutor.TutorProfile)
            }
            .fillMaxWidth()
            .wrapContentHeight(),

        ) {
        Column {
            Spacer(modifier = Modifier.height(24.dp))
            Box(
                modifier = Modifier
                    .height(92.dp)
                    .width(76.dp),
            ) {
                Surface(
                    shape = RoundedCornerShape(20.dp)
                ) {
                    Image(
                        painter = profile,
                        contentDescription = "profile photo",
                        contentScale = ContentScale.Crop
                    )
                }
                SkillvsmeLiveTag(
                    modifier = Modifier
                        .align(Alignment.BottomCenter),
                    textModifier = Modifier
                        .padding(horizontal = 8.dp),
                    isLive = isLive
                )
            }
        }
        Spacer(modifier = Modifier.width(4.dp))
        Column(
            modifier = Modifier
                .padding(start = 12.dp, end = 12.dp, top = 30.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                SkillvsmeText(
                    value = name,
                    boldValue = true,
                    valueSize = 24
                )
                Row(
                    verticalAlignment = Alignment.Top,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(R.drawable.rate_star),
                        modifier = Modifier.size(20.dp),
                        contentDescription = "rate star",
                    )
                    SkillvsmeText(
                        value = "${rating}",
                        valueColor = black.copy(alpha = 0.5f),
                        valueSize = 14
                    )
                }
            }
            Spacer(modifier = Modifier.height(4.dp))
            SkillvsmeText(
                value = bio,
                maxline = 4,
                lineheight = 1.13,
                letterSpacing = 0.02,
                valueSize = 16
            )
            Spacer(modifier = Modifier.height(12.dp))
        }
    }
    Divider(
        thickness = 1.dp,
        color = black
    )
}