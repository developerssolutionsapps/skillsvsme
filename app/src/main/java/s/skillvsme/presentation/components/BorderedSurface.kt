package s.skillvsme.presentation.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun BorderedSurface(
    modifier: Modifier = Modifier,
    borderColor: Color = Color.Gray,
    borderWidth: Dp = 2.dp,
    cornerRadius: Dp = 8.dp,
    content: @Composable () -> Unit
) {
    Surface(
        modifier = modifier.padding(borderWidth),
        shape = RoundedCornerShape(cornerRadius),
        color = borderColor
    ) {
        Surface(
            modifier = Modifier.padding(borderWidth),
            shape = RoundedCornerShape(cornerRadius),
            color = Color.White
        ) {
            content()
        }
    }
}
