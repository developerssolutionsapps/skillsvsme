package s.skillvsme.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import s.skillvsme.R
import s.skillvsme.common.Fonts
import s.skillvsme.ui.theme.black
import s.skillvsme.ui.theme.white

@Composable
fun EditUnbookedClasses(
    modifier: Modifier = Modifier,
    label: String,
    onDelete: () -> Unit = {},
    onEdit: () -> Unit = {}
) {
    val primary = false
    BorderedSurface(
        modifier = modifier,
        borderColor = if (primary) white else black,
        borderWidth = 1.dp,
        cornerRadius = 24.dp
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .background(
                    color = if (primary) black else white
                )
                .padding(vertical = 8.dp, horizontal = 20.dp),
        ){
            Text(
                text = label,
                color = if (primary) white else black,
                modifier = Modifier.weight(1f),
                fontFamily = Fonts.jostFontFamily,
                fontSize = 20.sp
            )
            Row {
                Image(
                    modifier = Modifier
                        .clickable {

                                   },
                    painter = painterResource(id = R.drawable.edit_1),
                    contentDescription = null
                )
                Image(
                    modifier = Modifier
                        .clickable { onDelete() },
                    painter = painterResource(id = R.drawable.delete_1),
                    contentDescription = null
                )
            }
        }
    }
}