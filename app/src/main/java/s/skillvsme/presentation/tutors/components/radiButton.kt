package s.skillvsme.presentation.tutors.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import s.skillvsme.R

@Composable
fun TwoRadioButtons(
    option1Text: String,
    option2Text: String,
    selectedOption: String,
    onOptionSelected: (String) -> Unit
) {
    Row {
        RadioButton(
            selected = selectedOption == option1Text,
            onClick = { onOptionSelected(option1Text) },
            modifier = Modifier.padding(end = 8.dp)
        )
        Text(
            text = option1Text,
            modifier = Modifier.clickable { onOptionSelected(option1Text) }
        )
        if (selectedOption == option1Text) {

            Icon(
                painter = painterResource(id = R.drawable.green_tick_icon),
                contentDescription = null,
                tint = Color.Green
            )
        }
        Spacer(modifier = Modifier.width(16.dp))
        RadioButton(
            selected = selectedOption == option2Text,
            onClick = { onOptionSelected(option2Text) },
            modifier = Modifier.padding(end = 8.dp)
        )
        Text(
            text = option2Text,
            modifier = Modifier.clickable { onOptionSelected(option2Text) }
        )
        if (selectedOption == option2Text) {

            Icon(
                painter = painterResource(id = R.drawable.green_tick_icon),
                contentDescription = null,
                tint = Color.Green
            )
        }
    }
}
