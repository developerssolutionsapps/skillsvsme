package s.skillvsme.presentation.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import s.skillvsme.ui.theme.lightGrey


@Composable
fun LanguageCard(
    language: String
) {
    Surface(
        color = lightGrey,
        shape = RoundedCornerShape(12.dp)
    ) {
        Text(
            text = language,
            modifier = Modifier
                .padding(horizontal = 28.dp, vertical = 16.dp)
        )
    }
}