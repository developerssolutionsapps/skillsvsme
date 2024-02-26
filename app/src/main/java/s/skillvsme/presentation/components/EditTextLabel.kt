package s.skillvsme.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import s.skillvsme.common.Fonts
import s.skillvsme.ui.theme.darkGrey

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditTextLabel(
    value:String,
    text:String,
    spacer: Dp? =null,
    isLongText: Boolean = false,
    trailinicon:Painter?=null
){
    Column(modifier = Modifier.fillMaxWidth()) {
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = text,
            fontFamily = Fonts.jostFontFamily,
            fontSize = 18.sp,
            fontWeight = FontWeight.Normal,
        )
        spacer?.let { Modifier.height(it) }?.let { Spacer(modifier = it) }
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .height(if (isLongText) 250.dp else TextFieldDefaults.MinHeight),
            value = value,
            onValueChange = {},
            shape = RoundedCornerShape(20.dp),
            placeholder = {
                Text(
                    modifier = Modifier
                        .scale(1.6f),
                    fontFamily = Fonts.jostFontFamily,
                    text = "",
                    fontSize = 18.sp,
                    textAlign = TextAlign.Start,
                    color = darkGrey
                )
            },
            singleLine = !isLongText,
            textStyle = TextStyle(
                fontSize = 18.sp,
                fontFamily = Fonts.jostFontFamily,
                fontWeight = FontWeight.Normal,
            )

        , trailingIcon = {
                if (trailinicon != null) {
                    Icon(painter = trailinicon, contentDescription = "")
                }
            }
        )

    }
}