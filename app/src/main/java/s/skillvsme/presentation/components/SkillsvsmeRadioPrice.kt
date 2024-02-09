package s.skillvsme.presentation.components


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.RadioButton
import androidx.compose.material.RadioButtonDefaults
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import s.skillvsme.ui.theme.black
import s.skillvsme.ui.theme.lightGrey
import s.skillvsme.ui.theme.purple
import s.skillvsme.ui.theme.white

@Composable
fun SkillvsmeRadioPrice(
    modifier: Modifier = Modifier,
    selectedValue: String,
    label: String,
    discount: Double? = null,
    price: Double,
    onClick: () -> Unit = {},
) {
    val primary = selectedValue != label
    BorderedSurface(
        modifier = modifier,
        borderColor = if (primary) white else black,
        borderWidth = 1.dp,
        cornerRadius = 24.dp
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(8.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = selectedValue == label,
                    onClick = onClick,
                    colors = RadioButtonDefaults.colors(
                        selectedColor = black,
                        unselectedColor = white
                    )
                )
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = label,
                        color = if (primary) white else black,
                        modifier = Modifier.padding(8.dp)
                    )
                    if (discount != null) Card(
                        shape = RoundedCornerShape(12.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = lightGrey,
                        ),
                    ) {
                        Text(
                            text = "${discount}% off",
                            color = if (primary) white else black,
                            modifier = Modifier
                                .padding(all = 4.dp)
                        )
                    }
                }
            }
            Row(
                horizontalArrangement = Arrangement.Start,
                modifier = Modifier.padding(end = 24.dp)
            ) {
                Text(
                    text = "${price}$",
                    color = if (primary) purple else black
                )
                Text(
                    text = "/mo",
                    color = if (primary) white else black
                )
            }
        }
    }
}