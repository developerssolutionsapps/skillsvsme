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

@Composable
fun TransactionHistory(
    modifier: Modifier = Modifier,
    iconStart: Painter,
    textSuccess:String="Successfully" ,
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
                .padding(10.dp), shape = CircleShape, Color.Black
        ) {
            Image(painter = iconStart, contentDescription = "", contentScale = ContentScale.Crop)
        }
        Spacer(modifier = modifier.height(-10.dp))
        Row(
            modifier
                .padding(10.dp)
                .fillMaxWidth()
        ) {
            Column {
                Text(text = "Pay Pal", fontWeight = FontWeight.Bold)
                Text(text = "54821236877123", fontWeight = FontWeight.Normal)
                Text(text = "04 Dec,2023 | 5:00 PM",fontWeight = FontWeight.Light)
            }
            Spacer(modifier = Modifier.weight(1f))
            Column {
                Text(
                    text = "150 $",
                    fontWeight = FontWeight.Bold,
                )

                Box(
                    modifier
                        .padding(top = 10.dp)
                        .size(width = 50.dp, height = 15.dp)
                        .background(if (textSuccess=="Successfully") Color.Green else Color.Red, shape = RoundedCornerShape(5.dp)),
                    contentAlignment = androidx.compose.ui.Alignment.Center,
                ) {
                    Text(text = textSuccess, style = TextStyle(fontSize = 8.sp))
                }
            }
        }
    }
}