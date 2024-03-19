package s.skillvsme.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import s.skillvsme.R
import s.skillvsme.common.Fonts
import s.skillvsme.ui.theme.white

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SimpleAppBar(
    navController: NavController,
    text: String,
    canNavigateBack: Boolean = true,
    backNavigation: (() -> Unit)? = null
)
{
    androidx.compose.material3.Surface(
        shadowElevation = 3.dp,
        modifier = Modifier
            .fillMaxWidth(),
        color = white
    ) {
        TopAppBar(
            title = {
                Text(
                    text,
                    fontFamily = Fonts.headlandOneFontFamily,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 28.dp),
                    textAlign = TextAlign.Center,
                )
            },
            navigationIcon = {
                Image(
                    painter = painterResource(id = R.drawable.right_arrow),
                    contentDescription = "right arrow",
                    modifier = Modifier
                        .clickable {
                            if (canNavigateBack) {
                                if (backNavigation != null){
                                    backNavigation()
                                } else {
                                    navController.popBackStack()
                                }
                            }
                        }
                )
            },
            colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = white),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp)
        )
    }
}