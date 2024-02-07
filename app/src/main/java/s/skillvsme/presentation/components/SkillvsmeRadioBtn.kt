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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun SkillvsmeRadioBtn() {
    val selectedValue = remember { mutableStateOf("") }
    val label = "Item"
    val primary = true
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
                selected = selectedValue.value == label,
                onClick = { selectedValue.value = label }
            )
            Text(
                text = label,
                color = if (primary) MaterialTheme.colors.onPrimary else MaterialTheme.colors.primary,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}