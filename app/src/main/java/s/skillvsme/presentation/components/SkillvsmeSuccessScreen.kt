package s.skillvsme.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import s.skillvsme.R
import s.skillvsme.common.Fonts


@Composable
fun SkillvsmeSuccessScreen(
    modifier: Modifier = Modifier,
    successMessage: String,
    successInfo: String? = null,
    buttonText: String,
    backButtonText: String,
    buttonOnclickAction: () -> Unit = {},
    backButtonOnclickAction: () -> Unit = {},
) {
    Column(
        modifier = modifier
            .padding(20.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxHeight(0.6f)
                .fillMaxWidth()
        ) {
            Spacer(modifier = Modifier.height(100.dp))
            Image(
                painter = painterResource(R.drawable.baseline_check_circle),
                contentDescription = "successful icon"
            )
            Spacer(modifier = Modifier.height(14.dp))
            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = successMessage,
                fontWeight = FontWeight.Bold,
                fontSize = 26.sp,
                fontFamily = Fonts.jostFontFamily,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(23.dp))
            if (successInfo != null) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth(),
                    text = successInfo,
                    fontWeight = FontWeight.Normal,
                    fontFamily = Fonts.jostFontFamily,
                    fontSize = 22.sp,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
        Column {
            SkillvsmeButton(
                modifier = Modifier.fillMaxWidth(),
                label = buttonText,
                primary = true,
                onClick = buttonOnclickAction
            )
            Spacer(modifier = Modifier.height(4.dp))
            SkillvsmeButton(
                modifier = Modifier.fillMaxWidth(),
                label = backButtonText,
                primary = false,
                onClick = backButtonOnclickAction
            )
            Spacer(modifier = Modifier.height(16.dp))
            Spacer(modifier = Modifier.height(40.dp))
        }
    }
}