package s.skillvsme.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import s.skillvsme.ui.theme.darkGrey
import s.skillvsme.ui.theme.red


@Composable
fun SkillvsmeLiveTag(
    isLive: Boolean = true
) {
    Box(
        modifier = Modifier
            .graphicsLayer {
                translationY = +10.dp.toPx()
            }
            .width(30.dp)
            .height(20.dp)
            .background(if (isLive) red else darkGrey , RoundedCornerShape(5.dp))
    ) {
        Text(
            text = "Live",
            color = Color.White,
            fontSize = 12.sp,
            modifier = Modifier.padding(4.dp)
        )
    }
}