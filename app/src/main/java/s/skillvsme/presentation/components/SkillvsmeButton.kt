package s.skillvsme.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import s.skillvsme.ui.theme.black
import s.skillvsme.ui.theme.darkGrey
import s.skillvsme.ui.theme.lightGrey
import s.skillvsme.ui.theme.white

@Composable
fun SkillvsmeButton(
    modifier: Modifier = Modifier,
    label:String,
    enabled: Boolean = true,
    primary: Boolean = true,
    onClick: () -> Unit,
    ) {
    Button(
        border = BorderStroke(1.dp, white),
        onClick = onClick,
        modifier = modifier.testTag(label),
        enabled = enabled,
        shape = MaterialTheme.shapes.large.copy(all = CornerSize(16.dp)),
        colors = ButtonDefaults.buttonColors(
            contentColor = Color.White,
            backgroundColor = if (primary) black else white,
            disabledBackgroundColor = if(primary) darkGrey else lightGrey,
            disabledContentColor = if(primary) lightGrey else darkGrey
        )
    ){
        Text(
            text = label,
            modifier = Modifier
                .padding(8.dp),
            color = if(primary) white else black,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp
        )
    }
}