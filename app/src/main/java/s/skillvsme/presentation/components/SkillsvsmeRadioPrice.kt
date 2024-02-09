package s.skillvsme.presentation.components


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.RadioButton
import androidx.compose.material.RadioButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import s.skillvsme.ui.theme.black
import s.skillvsme.ui.theme.darkGrey
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
        borderColor = if (primary) black else white,
        borderWidth = 1.dp,
        cornerRadius = 24.dp,
        background = if (primary) white else black
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(8.dp)
                .background(color = if (primary) white else black ),
        ) {
            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = selectedValue == label,
                    onClick = onClick,
                    colors = RadioButtonDefaults.colors(
                        selectedColor = white,
                        unselectedColor = black
                    )
                )
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = label,
                        color = if (primary) black else white,
                        modifier = Modifier.padding(8.dp)
                    )
                    if (discount != null) Card(
                        shape = RoundedCornerShape(12.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = if (primary) darkGrey else lightGrey,
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
                    fontWeight = FontWeight.SemiBold,
                    color = if (primary) purple else white
                )
                Text(
                    text = "/mo",
                    fontWeight = FontWeight.SemiBold,
                    color = if (primary) black else white
                )
            }
        }
    }
}