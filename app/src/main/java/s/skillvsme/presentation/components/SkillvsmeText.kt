package s.skillvsme.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import s.skillvsme.common.Fonts
import s.skillvsme.ui.theme.darkGrey
import s.skillvsme.ui.theme.white

@Composable
fun SkillvsmeText(
    value: String,
    value1: String?=null,
    modifier: Modifier = Modifier,
    label: String? = null,
    color: Color = white,
    boldLabel: Boolean = true,
    fontSize: Int? = null,
    boldValue: Boolean = false,
    iconBeforeSize: Dp =16.dp,
    valueSize: Int? = null,
    labelSize: Int? = null,
    iconBeforeSpacer: Dp =16.dp,
    iconAfterSize: Dp =16.dp,
    iconBefore: Painter? = null,
    valueFont:FontWeight=FontWeight.Normal,
    iconAfter: Painter? = null,
    valueColor: Color? = null,
    labelColor: Color? = null,
    labelIcon: Painter? = null,
    isValueHeading: Boolean = false,
    verticalAlign: Arrangement.HorizontalOrVertical = Arrangement.Center,
    horizontalAlign: Arrangement.Horizontal = Arrangement.SpaceBetween,
) {
    Row(
        modifier = modifier,
        horizontalArrangement = horizontalAlign,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (iconBefore != null) {
                Box(
                    modifier = Modifier
                        .size(iconBeforeSize)
                ) {
                    Icon(
                        iconBefore,
                        contentDescription = "icon"
                    )
                }
                Spacer(modifier = Modifier.width(iconBeforeSpacer))
            }
            Column(
                verticalArrangement = verticalAlign as Arrangement.Vertical,
                horizontalAlignment = Alignment.Start,
            ) {
                if (!label.isNullOrBlank()) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        if (labelIcon != null) {
                            Icon(labelIcon, contentDescription = "icon")
                        }
                        Text(
                            text = label,
                            fontSize = labelSize?.sp ?: TextUnit.Unspecified,
                            fontFamily = Fonts.jostFontFamily,
                            color = labelColor ?: Color.Unspecified,
                            style = MaterialTheme.typography.body1,
                            fontWeight = if (boldLabel) FontWeight.Bold else FontWeight.Normal,
                            )
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                }

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = value,
                        color = valueColor ?: Color.Unspecified,
                        fontFamily = Fonts.jostFontFamily,
                        fontSize = if(valueSize != null) valueSize.sp else TextUnit.Unspecified,
                        style = if (isValueHeading) MaterialTheme.typography.h5 else MaterialTheme.typography.body1,
                        fontWeight = if (boldValue) FontWeight.SemiBold else FontWeight.Normal
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    if (value1 !=null){
                        Text(
                            text = value1,
                            color = darkGrey ?: Color.Unspecified,
                            fontFamily = Fonts.jostFontFamily,
                            fontSize = fontSize?.sp ?: TextUnit.Unspecified,
                            style = if (isValueHeading) MaterialTheme.typography.h5 else MaterialTheme.typography.body1,
                            fontWeight = if (boldValue) FontWeight.SemiBold else FontWeight.Normal
                        )
                    }
                }
            }
        }
        if (iconAfter != null) {
            Icon(
                iconAfter,
                contentDescription = "icon",
                modifier = Modifier
                    .size(iconAfterSize)
                    .background(color),
                darkGrey
            )
        }
    }
}