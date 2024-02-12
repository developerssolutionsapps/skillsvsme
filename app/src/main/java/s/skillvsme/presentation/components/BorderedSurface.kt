package s.skillvsme.presentation.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import s.skillvsme.ui.theme.lightGrey

@Composable
fun BorderedSurface(
    modifier: Modifier = Modifier,
    borderColor: Color = Color.Gray,
    borderWidth: Dp = 2.dp,
    cornerRadius: Dp = 8.dp,
    background: Color? = null,
    content: @Composable () -> Unit
) {
    Surface(
        modifier = modifier.padding(borderWidth),
        shape = RoundedCornerShape(cornerRadius),
        color = borderColor
    ) {
        Card(
            modifier = Modifier.padding(borderWidth),
            shape = RoundedCornerShape(cornerRadius),
            colors = CardDefaults.cardColors(
                containerColor = if (background != null) background else Color.Transparent,
            ),
        ) {
            content()
        }
    }
}
