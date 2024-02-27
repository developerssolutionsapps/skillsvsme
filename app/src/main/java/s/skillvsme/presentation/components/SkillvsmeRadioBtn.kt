package s.skillvsme.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Colors
import androidx.compose.material.RadioButton
import androidx.compose.material.RadioButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
    onClick: () -> Unit = {},
    color: Color = black,
    textColor:Color= black,
    fontSize:Int=20
) {
    Row(
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically,
    ){
        RadioButton(
            selected = selectedValue == label,
            onClick = onClick,
            colors = RadioButtonDefaults.colors(
                selectedColor = color,
                unselectedColor = color
            )
        )
        Text(
            text = label,
            color = color,
            modifier = Modifier.fillMaxWidth(),
            fontFamily = Fonts.jostFontFamily,
            fontSize = fontSize.sp
        )
    }
}