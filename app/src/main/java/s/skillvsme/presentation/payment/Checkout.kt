package s.skillvsme.presentation.payment

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import s.skillvsme.presentation.components.SkillvsmeButton
import s.skillvsme.presentation.components.SkillvsmeText
import s.skillvsme.presentation.components.SkillvsmeTextField
import s.skillvsme.ui.theme.black
import s.skillvsme.ui.theme.purple

@Composable
fun Checkout() {
    Column(
        modifier = Modifier
            .padding(24.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Spacer(modifier = Modifier.height(16.dp))
            SkillvsmeText(value = "Promocode", boldValue = true, valueColor = purple)
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth(),
            ) {
                SkillvsmeTextField(
                    modifier = Modifier.fillMaxWidth(0.5f),
                    value = "ChRIS24",
                    onChange = {},
                    label = "",
                    hint = "",
                    fieldDescription = ""
                )
                SkillvsmeButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 28.dp, start = 24.dp),
                    label = "Apply",
                    primary = true,
                    onClick = {}
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                SkillvsmeText(value = "30 min per day (12 months)")
                SkillvsmeText(value = "360 USD", boldValue = true)
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                SkillvsmeText(value = "yearly subscription discount")
                SkillvsmeText(value = "-60 USD", boldValue = true)
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                SkillvsmeText(value = "Promotion discount")
                SkillvsmeText(value = "-30 USD", boldValue = true)
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row {
                Divider(
                    thickness = 1.dp,
                    color = black
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(
                    text = "Promotion discount",
                    color = black,
                    fontWeight = FontWeight.Bold,
                    style = TextStyle(fontSize = 20.sp)
                )
                Text(
                    text = "270.00 USD",
                    color = black,
                    fontWeight = FontWeight.Bold,
                    style = TextStyle(fontSize = 20.sp)
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
        }
        Column {
            SkillvsmeButton(
                modifier = Modifier.fillMaxWidth(),
                label = "Proceed to payment",
                primary = true,
                onClick = {}
            )
            Spacer(modifier = Modifier.height(16.dp))
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