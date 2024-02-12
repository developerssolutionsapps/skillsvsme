package s.skillvsme.presentation.userprofilestudent

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import s.skillvsme.R
import s.skillvsme.presentation.components.BorderedSurface
import s.skillvsme.presentation.components.ProfileAppBar
import s.skillvsme.presentation.components.SkillvsmeText
import s.skillvsme.presentation.components.TransactionHistory

@Composable
fun PaymentSettings() {
    val scrollState = rememberScrollState()
    Column(

        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        ProfileAppBar(
            backgroundColor = Color.Black, modifier = Modifier, backgroundImage = painterResource(
                id = R.drawable.profile,
            ), contentSize = 130.dp, bottomCornerRadius = 30.dp
        )
        Spacer(modifier = Modifier.weight(1f))
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 40.dp, start = 16.dp, end = 16.dp),
        ) {
            Spacer(modifier = Modifier.height(25.dp))
            Text(
                text = "Kamal Tyagi",
                fontWeight = FontWeight.Bold,
                fontSize = 25.sp,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(25.dp))
            SkillvsmeText(value = "Current Plan", valueFont = FontWeight.Normal)
            Spacer(modifier = Modifier.height(15.dp))
            BorderedSurface(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp),
                background = Color.White,
                cornerRadius = 12.dp,
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = "1 hr/week",
                        modifier = Modifier
                            .align(alignment = Alignment.CenterHorizontally)
                            .padding(top = 10.dp, bottom = 5.dp)
                            .fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        style = TextStyle(fontSize = 25.sp),
                        color = Color.Red
                    )
                    Text(
                        text = "pay every 3 mo",
                        modifier = Modifier
                            .align(alignment = Alignment.CenterHorizontally)
                            .padding(5.dp)
                            .fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        style = TextStyle(fontSize = 18.sp),
                        color = Color.Red,
                    )
                }
            }
            Text(text = "Transaction history", modifier = Modifier.padding(top = 20.dp, bottom = 15.dp))
            TransactionHistory(iconStart = painterResource(id = R.drawable.arrow_downward_left))
            Divider(
                color = Color.Gray,
                modifier = Modifier
                    .height(1.dp)
                    .fillMaxWidth() // Adjust width as needed
            )
            TransactionHistory(iconStart = painterResource(id = R.drawable.arrow_upwardward_left), textSuccess = "failed")
            Divider(
                color = Color.Gray,
                modifier = Modifier
                    .height(1.dp)
                    .fillMaxWidth() // Adjust width as needed
            )
            TransactionHistory(iconStart = painterResource(id = R.drawable.arrow_upwardward_left))
            Divider(
                color = Color.Gray,
                modifier = Modifier
                    .height(1.dp)
                    .fillMaxWidth() // Adjust width as needed
            )
            TransactionHistory(iconStart = painterResource(id = R.drawable.arrow_upwardward_left))
            Divider(
                color = Color.Gray,
                modifier = Modifier
                    .height(1.dp)
                    .fillMaxWidth() // Adjust width as needed
            )
        }
    }
}