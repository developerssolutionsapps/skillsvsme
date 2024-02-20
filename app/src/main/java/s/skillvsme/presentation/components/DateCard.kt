package s.skillvsme.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import s.skillvsme.common.Fonts
import s.skillvsme.ui.theme.lightGrey
import s.skillvsme.ui.theme.purple


@Composable
fun DateCard(
    day: String,
    date: String,
    month: String,
) {
    Box(
        modifier = Modifier
            .padding(top = 24.dp, end = 12.dp)
            .fillMaxWidth(0.2f)
            .background(
                color = lightGrey,
                shape = RoundedCornerShape(12.dp)
            )
    ) {
        Column() {
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                fontFamily = Fonts.jostFontFamily,
                text = day,
                fontWeight = FontWeight.SemiBold,
                color = purple,
                fontSize = 18.sp,
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .fillMaxWidth(),
                textAlign = TextAlign.Center
            )
            Text(
                fontFamily = Fonts.jostFontFamily,
                text = date,
                fontWeight = FontWeight.SemiBold,
                color = purple,
                fontSize = 18.sp,
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .fillMaxWidth(),
                textAlign = TextAlign.Center
            )
            Text(
                fontFamily = Fonts.jostFontFamily,
                text = month,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        }
    }
}