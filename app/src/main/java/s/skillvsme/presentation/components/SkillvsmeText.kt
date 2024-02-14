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
import androidx.compose.ui.unit.dp
import s.skillvsme.common.Fonts

@Composable
fun SkillvsmeText(
    value: String,
    modifier: Modifier = Modifier,
    label: String? = null,
    color:Color=Color.White,
    boldLabel: Boolean = true,
    boldValue: Boolean = false,
    iconBeforeSize: Dp =16.dp,
    valueSize:TextStyle?=null,
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
                            fontFamily = Fonts.jostFontFamily,
                            color = if (labelColor != null) labelColor else Color.Unspecified,
                            style = MaterialTheme.typography.body1,
                            fontWeight = if (boldLabel) FontWeight.Bold else FontWeight.Normal
                        )
                    }
                }
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = value,
                        color = if (valueColor != null) valueColor else Color.Unspecified,
                        fontFamily = Fonts.jostFontFamily,
                        style = if (isValueHeading) MaterialTheme.typography.h5 else MaterialTheme.typography.body1,
                        fontWeight = if (boldValue) FontWeight.SemiBold else FontWeight.Normal
                    )
                }
            }
        }

        if (iconAfter != null) {
            Spacer(modifier = Modifier.width(iconAfterSize).background(color))
            Icon(iconAfter, contentDescription = "icon")
        }
    }
}