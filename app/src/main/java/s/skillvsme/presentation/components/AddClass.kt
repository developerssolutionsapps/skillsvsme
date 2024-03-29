package s.skillvsme.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import s.skillvsme.R
import s.skillvsme.common.Fonts
import s.skillvsme.common.Route
import s.skillvsme.ui.theme.black
import s.skillvsme.ui.theme.white

@Composable
fun AddClass(
    modifier: Modifier = Modifier,
    navController: NavController
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
                .clickable {
                    navController.navigate(Route.Tutor.Classes.AddClass)
                }
                .padding(vertical = 8.dp, horizontal = 20.dp),
        ){
            Image(painter = painterResource(id = R.drawable.add_black_bg), contentDescription = null)
            Spacer(modifier = Modifier.width(20.dp))
            Text(
                text = "Add a class",
                color = if (primary) white else black,
                modifier = Modifier.fillMaxWidth(),
                fontFamily = Fonts.jostFontFamily,
                fontSize = 20.sp
            )
        }
    }
}