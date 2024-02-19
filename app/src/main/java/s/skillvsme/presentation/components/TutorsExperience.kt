package s.skillvsme.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import s.skillvsme.common.Fonts
import s.skillvsme.ui.theme.darkGrey
import s.skillvsme.ui.theme.greyishBlack
import s.skillvsme.ui.theme.white


@Composable
fun TutorsExperience(
    title: String,
    timeline: String,
    institution: String
) {
    BorderedSurface(
        background = white,
        borderColor = darkGrey,
        borderWidth = 1.dp,
        cornerRadius = 24.dp,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Text(
                fontFamily = Fonts.jostFontFamily,
                text = title,
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                fontFamily = Fonts.jostFontFamily,
                text = timeline,
                fontSize = 16.sp,
                color = greyishBlack,
                fontWeight = FontWeight.Light
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                fontFamily = Fonts.jostFontFamily,
                text = institution,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp
            )
        }
    }
}