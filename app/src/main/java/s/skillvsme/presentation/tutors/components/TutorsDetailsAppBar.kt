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
import androidx.navigation.NavController
import s.skillvsme.R
import s.skillvsme.common.Fonts
import s.skillvsme.common.Route
import s.skillvsme.presentation.components.SkillvsmeButton
import s.skillvsme.presentation.components.SkillvsmeLiveTag
import s.skillvsme.presentation.components.SkillvsmeText
import s.skillvsme.ui.theme.black
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
    navController: NavController
    ) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Card(
            modifier = Modifier
                .matchParentSize(),
            shape = RoundedCornerShape(
                bottomEnd = bottomCornerRadius,
                bottomStart = bottomCornerRadius,
            )
        ) {
            Image(
                modifier = Modifier
                    .background(black)
                    .fillMaxSize(),
                painter = backgroundImage ?: painterResource(id = R.drawable.background_lines),
                contentDescription = "Background Image",
                contentScale = ContentScale.Crop
            )
        }
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
                    .height(170.dp)
                    .padding(top = 40.dp)
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
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = name,
                color = white,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                modifier = Modifier
                    .fillMaxWidth(),
                fontFamily = Fonts.jostFontFamily,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(4.dp))
            SkillvsmeText(
                value = "${location} | ${time}",
                iconBefore = painterResource(id = R.drawable.location),
                iconBeforeColor = white,
                iconBeforeSpacer = 0.dp,
                boldValue = true,
                valueSize = 16,
                valueColor = white
            )
            Spacer(modifier = Modifier.height(12.dp))
            SkillvsmeButton(
                modifier = Modifier
                    .fillMaxWidth(),
                label = "Schedule a class",
                fontWeight = FontWeight.Bold,
                primary = false,
                onClick = { onClick() }
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
                .clickable {
                    navController.popBackStack()
                }
        )
    }
}