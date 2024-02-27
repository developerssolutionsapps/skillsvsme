package s.skillvsme.presentation.tutors.TutorsProfile

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
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
import androidx.navigation.NavController
import s.skillvsme.R
import s.skillvsme.common.Fonts
import s.skillvsme.common.Route
import s.skillvsme.presentation.components.BorderedSurface
import s.skillvsme.presentation.components.SimpleAppBar
import s.skillvsme.presentation.components.SkillvsmeButton
import s.skillvsme.presentation.components.TransactionHistory
import s.skillvsme.presentation.tutors.navigation.BottomNavigation
import s.skillvsme.ui.theme.purple
import s.skillvsme.ui.theme.white

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@RequiresApi(Build.VERSION_CODES.Q)
@OptIn(ExperimentalMaterialApi::class, ExperimentalMaterial3Api::class)
@Composable
fun Earnings(navController: NavController) {
    val scrollState = rememberScrollState()
    Scaffold(
        topBar = {
                 SimpleAppBar(navController = navController, text = "Earnings")
        },
        content = {paddingValue ->
            Column(
                modifier = Modifier.padding(start = 16.dp, end = 16.dp,)
                    .verticalScroll(scrollState),
                verticalArrangement = Arrangement.SpaceAround,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValue),
                ) {
                    Spacer(modifier = Modifier.height(18.dp))
                    Text(
                        text = "Available Balance",
                        fontWeight = FontWeight.Normal,
                        fontSize = 18.sp,
                        fontFamily = Fonts.jostFontFamily
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    BorderedSurface(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(93.dp),
                        background = white,
                        cornerRadius = 15.dp,
                        borderWidth = 1.dp
                    ) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(
                                text = "1,500 USD",
                                modifier = Modifier
                                    .align(alignment = Alignment.CenterHorizontally)
                                    .padding(top = 20.dp)
                                    .fillMaxWidth(),
                                textAlign = TextAlign.Center,
                                fontFamily = Fonts.jostFontFamily,
                                fontWeight = FontWeight.SemiBold,
                                style = TextStyle(fontSize = 24.sp),
                                color = purple
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    SkillvsmeButton(label = "Withdraw funds", modifier = Modifier.fillMaxWidth(), onClick = {
                        navController.navigate(Route.Tutor.Profile.TransactionSuccess)
                    })
                    Spacer(modifier = Modifier.height(54.dp))
                    Text(
                        text = "Transaction history",
                        modifier = Modifier.padding( bottom = 15.dp),
                        fontWeight = FontWeight.Normal,
                        fontSize = 18.sp,
                        fontFamily = Fonts.jostFontFamily
                    )
                    TransactionHistory(iconStart = painterResource(id = R.drawable.line_2))
                    Divider(
                        color = Color.Gray,
                        modifier = Modifier
                            .height(1.dp)
                            .fillMaxWidth() // Adjust width as needed
                    )
                    TransactionHistory(
                        iconStart = painterResource(id = R.drawable.line_2),
                        textSuccess = "failed"
                    )
                    Divider(
                        color = Color.Gray,
                        modifier = Modifier
                            .height(1.dp)
                            .fillMaxWidth() // Adjust width as needed
                    )
                    TransactionHistory(iconStart = painterResource(id = R.drawable.line_2))
                    Divider(
                        color = Color.Gray,
                        modifier = Modifier
                            .height(1.dp)
                            .fillMaxWidth() // Adjust width as needed
                    )
                    TransactionHistory(iconStart = painterResource(id = R.drawable.line_2))
                    Divider(
                        color = Color.Gray,
                        modifier = Modifier
                            .height(1.dp)
                            .fillMaxWidth() // Adjust width as needed
                    )
                }
            }
        },
        bottomBar = { BottomNavigation(navController = navController) }
    )
}