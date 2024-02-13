package s.skillvsme.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import s.skillvsme.R


@Composable
fun TutorsListComponent(
    name: String,
    bio: String,
    rating: Double,
    profile: Painter,
    isLive: Boolean = true,
) {
    Row(){
        Column {
            Spacer(modifier = Modifier.height(12.dp))
            Box(
                modifier = Modifier
                    .height(100.dp)
                    .width(80.dp),
            ) {
                Surface(
                    shape = RoundedCornerShape(16.dp)
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
                SkillvsmeText(
                    value = name,
                    boldValue = true,
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(painter = painterResource(R.drawable.rate_star), contentDescription = "rate star")
                    SkillvsmeText(
                        value = "${rating}"
                    )
                }
            }
            SkillvsmeText(
                value = bio,
            )
        }
    }
}