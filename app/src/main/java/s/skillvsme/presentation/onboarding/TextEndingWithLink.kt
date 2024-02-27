package s.skillvsme.presentation.onboarding

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import s.skillvsme.common.Fonts
import s.skillvsme.ui.theme.purple

@Composable
fun TextEndingWithLink(
    modifier: Modifier = Modifier.fillMaxSize(),
    text: String,
    linkText: String,
    onLinkClick: () -> Unit
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = text,
            fontFamily = Fonts.jostFontFamily,
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = linkText,
            fontFamily = Fonts.jostFontFamily,
            color = purple,
            modifier = Modifier
                .clickable(onClick = onLinkClick)
                .drawBehind {
                    val strokeWidthPx = 1.dp.toPx()
                    val verticalOffset = size.height - 2.sp.toPx()
                    drawLine(
                        color = purple,
                        strokeWidth = strokeWidthPx,
                        start = Offset(0f, verticalOffset),
                        end = Offset(size.width, verticalOffset)
                    )
                }
        )
    }
}