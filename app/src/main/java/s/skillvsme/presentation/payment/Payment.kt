package s.skillvsme.presentation.payment

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import s.skillvsme.presentation.components.BorderedSurface
import s.skillvsme.presentation.components.SkillvsmeButton
import s.skillvsme.presentation.components.SkillvsmeText
import s.skillvsme.presentation.components.SkillvsmeTextField
import s.skillvsme.ui.theme.white


@Composable
fun Payment() {
    Column(
        modifier = Modifier
            .padding(24.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Spacer(modifier = Modifier.height(16.dp))
            SkillvsmeText(value = "Please enter your card details")
            Spacer(modifier = Modifier.height(16.dp))
            BorderedSurface(
                borderWidth = 1.dp,
                background = white,
            ) {
                SkillvsmeTextField(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth(),
                    value = "1234-5678-9123-4567",
                    onChange = {},
                    label = "Card number",
                    hint = "",
                    fieldDescription = ""
                )
                SkillvsmeTextField(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth(),
                    value = "Jane Doe",
                    onChange = {},
                    label = "Card holder name",
                    hint = "",
                    fieldDescription = ""
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth(),
                ) {
                    SkillvsmeTextField(
                        modifier = Modifier
                            .padding(8.dp)
                            .fillMaxWidth(0.5f),
                        value = "03/28",
                        onChange = {},
                        label = "Expiry Date",
                        hint = "MM/YY",
                        fieldDescription = ""
                    )
                    SkillvsmeTextField(
                        modifier = Modifier
                            .padding(8.dp)
                            .fillMaxWidth(),
                        value = "111",
                        onChange = {},
                        label = "CFV",
                        hint = "",
                        fieldDescription = ""
                    )
                }
            }
        }
        Column {
            SkillvsmeButton(
                modifier = Modifier.fillMaxWidth(),
                label = "Proceed to payment",
                primary = true,
                onClick = {}
            )
            Spacer(modifier = Modifier.height(4.dp))
            SkillvsmeButton(
                modifier = Modifier.fillMaxWidth(),
                label = "Back",
                primary = false,
                onClick = {}
            )
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}