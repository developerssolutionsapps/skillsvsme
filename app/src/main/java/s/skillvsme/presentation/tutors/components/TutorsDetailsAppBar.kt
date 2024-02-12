package s.skillvsme.presentation.tutors.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import s.skillvsme.R
import s.skillvsme.presentation.components.SkillvsmeButton
import s.skillvsme.presentation.components.SkillvsmeLiveTag
import s.skillvsme.presentation.components.SkillvsmeText
import s.skillvsme.ui.theme.white

@Composable
fun TutorsDetailsAppBar(
    name: String,
    location: String,
    time: String,
    onClick: () -> Unit = {},
    modifier: Modifier = Modifier,
    backgroundColor: Color,
    backgroundImage: Painter? = null,
    profileImage: Painter? = null,
    bottomCornerRadius: Dp = 24.dp,
    ) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = backgroundColor,
                shape = RoundedCornerShape(
                    bottomEnd = bottomCornerRadius,
                    bottomStart = bottomCornerRadius,
                )
            )
    ) {
        Image(
            painter = if (backgroundImage == null) painterResource(id = R.drawable.top_blackish_bg) else backgroundImage,
            contentDescription = "Background Image",
            contentScale = ContentScale.Crop
        )
        // Circle Image View
        Column(
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.TopCenter),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
            Box(
                modifier = Modifier
                    .width(130.dp)
                    .height(146.dp)
                    .padding(top = 16.dp)
                    .background(Color.Transparent, CircleShape)
            ) {
                Card(
                    modifier = Modifier
                        .fillMaxSize()
                        .border(border = BorderStroke(8.dp, white), shape = CircleShape),
                    shape = CircleShape
                ) {
                    if (profileImage != null) {
                        Image(
                            painter = profileImage,
                            contentDescription = "",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop
                        )
                    }
                }
                SkillvsmeLiveTag(
                    modifier = Modifier
                        .align(Alignment.BottomCenter),
                    textModifier = Modifier
                        .padding(horizontal = 12.dp)
                )
            }
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = name,
                color = white,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                modifier = Modifier
                    .fillMaxWidth(),
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(4.dp))
            SkillvsmeText(
                value = "${location} | ${time}",
                iconBefore = painterResource(id = R.drawable.location_white),
                boldValue = true,
                valueColor = white
            )
            Spacer(modifier = Modifier.height(16.dp))
            SkillvsmeButton(
                modifier = Modifier
                    .fillMaxWidth(),
                label = "Schedule a class",
                primary = false
            )
            Spacer(modifier = Modifier.height(16.dp))
        }
        Image(
            painter = painterResource(id = R.drawable.white_arrow_left),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(start = 16.dp, top = 48.dp)
                .size(25.dp)
                .clickable { /* Handle back button click */ }
        )
    }
}