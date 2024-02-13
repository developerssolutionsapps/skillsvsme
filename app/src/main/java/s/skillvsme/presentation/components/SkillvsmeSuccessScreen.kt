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


@Composable
fun SkillvsmeSuccessScreen(
    successMessage: String,
    successInfo: String? = null,
    buttonText: String,
    backButtonText: String,
    buttonOnclickAction: () -> Unit = {},
    backButtonOnclickAction: () -> Unit = {},
) {
    Column(
        modifier = Modifier
            .padding(24.dp)
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
            Spacer(modifier = Modifier.height(16.dp))
            Image(painter = painterResource(R.drawable.baseline_check_circle), contentDescription = "successful icon")
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = successMessage,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(8.dp))

            if (successInfo != null) {
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(24.dp),
                    text = successInfo,
                    fontWeight = FontWeight.Normal,
                    fontSize = 18.sp,
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
        }
    }
}