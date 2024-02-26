package s.skillvsme.presentation.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import s.skillvsme.common.Fonts
import s.skillvsme.ui.theme.darkGrey

@Composable
fun AmountTextField(

) {
    Box(
        modifier = Modifier
            .border(
                width = 1.dp,
                color = darkGrey,
                shape = RoundedCornerShape(12.dp)
            )
            .height(185.dp),

        contentAlignment = Alignment.Center
    ) {
        Column(Modifier.fillMaxWidth()) {
            Row(modifier = Modifier.padding(bottom = 21.dp, start = 14.dp, end = 13.dp,)) {
                Text(
                    text = "Amount Transferred",
                    fontFamily = Fonts.jostFontFamily,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Normal,
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(text = "1500 USD",
                    fontFamily = Fonts.jostFontFamily,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium,)
            }
            Divider(
                modifier = Modifier.fillMaxWidth().padding(start = 14.dp,end=14.dp),
                color = darkGrey
            )
            Row(modifier = Modifier.padding(top = 21.dp, start = 14.dp, end = 13.dp,)) {
                Text(text = "Total",fontFamily = Fonts.jostFontFamily,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium,)
                Spacer(modifier = Modifier.weight(1f))
                Text(text = "1500 USD",fontFamily = Fonts.jostFontFamily,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Medium,)
            }

        }
    }
}