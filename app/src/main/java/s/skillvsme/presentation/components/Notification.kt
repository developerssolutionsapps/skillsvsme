package s.skillvsme.presentation.components

import android.app.Notification
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
import s.skillvsme.ui.theme.darkGrey

@Composable
fun Notification(
    modifier: Modifier = Modifier,
    iconStart: Painter,

) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight(),
    ) {
        Surface(
            modifier = Modifier
                .size(55.dp)
                .padding(10.dp), shape = CircleShape,
        ) {
            Image(painter = iconStart, contentDescription = "",modifier=Modifier.padding(5.dp))
        }
        Spacer(modifier = modifier.height(-10.dp))
        Row(
            modifier
                .padding(10.dp)
                .fillMaxWidth()
        ) {
            Column {
                Text(
                    fontFamily = Fonts.jostFontFamily,
                    text = "Black Friday is Here",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 20.sp
                )
                Spacer(
                    modifier = Modifier.height(4.dp)
                )
                Text(
                    fontFamily = Fonts.jostFontFamily,
                    text = "Get 50% 0f Yearly subscription in \n Black Friday for Limited time",
                    fontWeight = FontWeight.Normal,
                    fontSize = 18.sp
                )
                Spacer(
                    modifier = Modifier.height(10.dp)
                )
                Text(
                    fontFamily = Fonts.jostFontFamily,
                    text = "30/1123 | 5:00 PM",
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp,
                    color = darkGrey
                )
            }
        }
    }
}