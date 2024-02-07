package s.skillvsme.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun SkillvsmeRadioBtn(
    selectedValue: String,
    label: String,
    onClick: () -> Unit = {}
) {
    val primary = if (selectedValue == label) true else false
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.background(
            color = if (primary) MaterialTheme.colors.primary else MaterialTheme.colors.onPrimary
        ).padding(20.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.Start
        ){
            RadioButton(
                selected = selectedValue == label,
                onClick = onClick
            )
            Text(
                text = label,
                color = if (primary) MaterialTheme.colors.onPrimary else MaterialTheme.colors.primary,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}