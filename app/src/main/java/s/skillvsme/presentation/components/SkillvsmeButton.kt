package s.skillvsme.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.ButtonElevation
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import s.skillvsme.common.Fonts
import s.skillvsme.ui.theme.black
import s.skillvsme.ui.theme.darkGrey
import s.skillvsme.ui.theme.greyishBlack
import s.skillvsme.ui.theme.lightGrey
import s.skillvsme.ui.theme.white

@Composable
fun SkillvsmeButton(
    modifier: Modifier = Modifier,
    label:String,
    enabled: Boolean = true,
    primary: Boolean = true,
    onClick: () -> Unit = {},
    ) {
    Button(
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 0.dp
        ),
        border = BorderStroke(0.dp, white),
        onClick = onClick,
        modifier = modifier.testTag(label),
        enabled = enabled,
        shape = MaterialTheme.shapes.large.copy(all = CornerSize(24.dp)),
        colors = ButtonDefaults.buttonColors(
            contentColor = if(primary) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.primary,
            containerColor = if (primary) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onPrimary,
            disabledContainerColor = if(primary) greyishBlack else white,
            disabledContentColor = if(primary) white else greyishBlack
        )
    ){
        Text(
            text = label,
            modifier = Modifier
                .padding(8.dp),
            color = if(primary) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.primary,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            fontFamily = Fonts.jostFontFamily
        )
    }
}