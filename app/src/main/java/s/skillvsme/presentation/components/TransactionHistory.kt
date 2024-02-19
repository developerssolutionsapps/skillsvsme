package s.skillvsme.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.ktor.http.ContentType
import org.w3c.dom.Text
import s.skillvsme.common.Fonts
import s.skillvsme.ui.theme.black
import s.skillvsme.ui.theme.darkGrey
import s.skillvsme.ui.theme.green
import s.skillvsme.ui.theme.greyishBlack
import s.skillvsme.ui.theme.red
import s.skillvsme.ui.theme.white

@Composable
fun TransactionHistory(
    modifier: Modifier = Modifier,
    iconStart: Painter,
    textSuccess: String = "Successfully",
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Surface(
            modifier = Modifier
                .size(55.dp)
                .padding(10.dp),
            shape = CircleShape, black
        ) {
            Image(painter = iconStart, contentDescription = "", contentScale = ContentScale.Crop)
        }
        Spacer(modifier = modifier.height((-10).dp))
        Row(
            modifier
                .padding(10.dp)
                .fillMaxWidth()
        ) {
            Column {
                Text(
                    text = "Pay Pal",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 18.sp,
                    fontFamily = Fonts.jostFontFamily
                )
                Text(
                    text = "54821236877123",
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp,
                    color = black,
                    fontFamily = Fonts.jostFontFamily
                )
                Text(
                    text = "04 Dec,2023 | 5:00 PM", fontWeight = FontWeight.Normal,
                    fontSize = 14.sp,
                    fontFamily = Fonts.jostFontFamily, color = darkGrey
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            Column {
                Text(
                    text = "150 $",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 22.sp,
                    fontFamily = Fonts.jostFontFamily
                )

                Box(
                    modifier
                        .padding(top = 5.dp)
                        .size(width = 65.dp, height = 17.dp)
                        .background(
                            if (textSuccess == "Successfully") green else red,
                            shape = RoundedCornerShape(5.dp)
                        ),
                    contentAlignment = androidx.compose.ui.Alignment.Center,
                ) {
                    Text(text = textSuccess, style = TextStyle(fontSize = 10.sp), color = white,fontFamily = Fonts.jostFontFamily)
                }
            }
        }
    }
}