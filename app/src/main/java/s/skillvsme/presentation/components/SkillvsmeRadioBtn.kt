package s.skillvsme.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.RadioButton
import androidx.compose.material.RadioButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import s.skillvsme.common.Fonts
import s.skillvsme.ui.theme.black
import s.skillvsme.ui.theme.white

@Composable
fun SkillvsmeRadioBtn(
    modifier: Modifier = Modifier,
    selectedValue: String,
    label: String,
    onClick: () -> Unit = {}
) {
    Row(
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically,
    ){
        RadioButton(
            selected = selectedValue == label,
            onClick = onClick,
            colors = RadioButtonDefaults.colors(
                selectedColor = black,
                unselectedColor = black
            )
        )
        Text(
            text = label,
            modifier = Modifier.fillMaxWidth(),
            fontFamily = Fonts.jostFontFamily,
            fontSize = 20.sp
        )
    }
}