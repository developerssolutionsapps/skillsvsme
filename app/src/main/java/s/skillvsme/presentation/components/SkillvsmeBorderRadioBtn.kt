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
fun SkillvsmeBorderRadioBtn(
    modifier: Modifier,
    selectedValue: String,
    label: String,
    onClick: () -> Unit = {}
) {
    val primary = if (selectedValue == label) true else false
    BorderedSurface(
        modifier = modifier,
        borderColor = if (primary) white else black,
        borderWidth = 1.dp,
        cornerRadius = 24.dp,

    ) {
        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.background(
                color = if (primary) black else white
            ).padding(8.dp),
        ){
            RadioButton(
                selected = selectedValue == label,
                onClick = onClick,
                colors = RadioButtonDefaults.colors(
                    selectedColor = white,
                    unselectedColor = black
                )
            )
            Text(
                text = label,
                color = if (primary) white else black,
                modifier = Modifier.fillMaxWidth(),
                fontFamily = Fonts.jostFontFamily,
                fontSize = 20.sp
            )
        }
    }
}