package s.skillvsme.presentation.components


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.RadioButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import s.skillvsme.ui.theme.purple

@Preview
@Composable
fun SkillvsmeRadioPrice() {
    val selectedValue = remember { mutableStateOf("") }
    val label = "Item"
    val primary = true
    val discount = 12
    val price = 30
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .background(
                color = if (primary) MaterialTheme.colors.primary else MaterialTheme.colors.onPrimary
            )
            .padding(20.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier.fillMaxWidth(0.6f)
        ){
            RadioButton(
                selected = selectedValue.value == label,
                onClick = { selectedValue.value = label }
            )
            Column {
                Text(
                    text = label,
                    color = if (primary) MaterialTheme.colors.onPrimary else MaterialTheme.colors.primary,
                    modifier = Modifier.fillMaxWidth()
                )
                if(discount != null) Surface(
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier
                        .background(
                            color = if (primary) MaterialTheme.colors.primary else MaterialTheme.colors.onPrimary
                        )
                        .padding(all = 8.dp)
                ) {
                    Text(
                        text = "${discount}% off",
                        color = if (primary) MaterialTheme.colors.onPrimary else MaterialTheme.colors.primary,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }

        Row(
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier.fillMaxWidth(0.3f)
        ){
            Text(
                text = "${price}$",
                color = if (primary) purple else MaterialTheme.colors.onPrimary,
                modifier = Modifier.fillMaxWidth()
            )
            Text(
                text = "/mo",
                color = if (primary) MaterialTheme.colors.onPrimary else MaterialTheme.colors.primary,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}