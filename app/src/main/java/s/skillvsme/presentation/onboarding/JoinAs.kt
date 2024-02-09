package s.skillvsme.presentation.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import s.skillvsme.R
import s.skillvsme.presentation.components.SkillvsmeButton
import s.skillvsme.ui.theme.black
import s.skillvsme.ui.theme.purple

@Composable
fun JoinAs() {
    Column(
        modifier = Modifier
            .padding(24.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround
    ) {
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
            text = "Join Skillvsme as",
            style = MaterialTheme.typography.h4
        )

        Spacer(modifier = Modifier.height(16.dp))

        var tutorSelected by remember { mutableStateOf(true) }
        var studentSelected by remember { mutableStateOf(false) }
        // Horizontal row of images with text below
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            ImageWithText(
                painter = painterResource(id = R.drawable.teacher),
                text = "Tutor",
                isSelected = tutorSelected,
                onClick = {
                    tutorSelected = !tutorSelected
                }
            )

            ImageWithText(
                painter = painterResource(id = R.drawable.womens_voice),
                text = "Student",
                isSelected = studentSelected,
                onClick = {
                    studentSelected = !studentSelected
                }
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        SkillvsmeButton(
            modifier = Modifier
                .fillMaxWidth(),
            label = "Start",
            onClick = { /* Handle next button click */ }
        )

        Spacer(modifier = Modifier.height(32.dp))
    }
}

@Composable
fun ImageWithText(
    painter: Painter,
    text: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Column() {
        Column(
            modifier = Modifier
                .size(124.dp)
                .clickable { onClick },
        ) {
            Image(
                painter = painter,
                contentDescription = text,
                modifier = Modifier
                    .size(120.dp)
                    .clip(CircleShape)
                    .border(
                        width = if (isSelected) 2.dp else 4.dp,
                        color = if (isSelected) black else purple,
                        shape = CircleShape
                    )
            )
        }
        Text(
            text = text,
            color = MaterialTheme.colors.onSurface,
            style = MaterialTheme.typography.body2,
            modifier = Modifier.padding(bottom = 8.dp)
                .align(Alignment.CenterHorizontally)
        )
    }
}
