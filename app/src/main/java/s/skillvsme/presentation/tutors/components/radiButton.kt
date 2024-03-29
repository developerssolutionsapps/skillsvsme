package s.skillvsme.presentation.tutors.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.IconToggleButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import s.skillvsme.R
import s.skillvsme.common.Fonts
import s.skillvsme.presentation.onboarding.noRippleClickable
import s.skillvsme.ui.theme.black

@Composable
fun TwoRadioButtons(
    option1Text: String,
    option2Text: String,
    selectedOption: String,
    onOptionSelected: (String) -> Unit
) {
    Row( verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start,
        modifier = Modifier.fillMaxWidth()
    ) {
        IconToggleButton(
            checked  = selectedOption == option1Text,
            onCheckedChange = { onOptionSelected(option1Text) },
        ){
            Image(
                painter = painterResource(if (selectedOption == option1Text) R.drawable.checked_radio_button else R.drawable.unchecked_radio_button),
                contentDescription = "Radio button icon",)
        }
        Text(
            text = option1Text,
            color = black,
            fontSize = 18.sp,
            fontFamily = Fonts.jostFontFamily,
            modifier = Modifier.noRippleClickable { onOptionSelected(option1Text) }
        )

        Spacer(modifier = Modifier.weight(1f))
        IconToggleButton(
            checked  = selectedOption == option2Text,
            onCheckedChange = { onOptionSelected(option2Text) },
            ){
            Image(
                painter = painterResource(if (selectedOption == option2Text) R.drawable.checked_radio_button else R.drawable.unchecked_radio_button),
                contentDescription = "Radio button icon",)
        }
        Text(
            text = option2Text,
            color = black,
            fontSize = 18.sp,
            fontFamily = Fonts.jostFontFamily,
            modifier = Modifier.noRippleClickable { onOptionSelected(option2Text) }
        )

    }
}
