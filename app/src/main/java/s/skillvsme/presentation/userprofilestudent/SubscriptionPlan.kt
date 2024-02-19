package s.skillvsme.presentation.userprofilestudent

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
import s.skillvsme.presentation.components.BorderedSurface
import s.skillvsme.presentation.components.ProfileAppBar
import s.skillvsme.presentation.components.TransactionHistory
import s.skillvsme.ui.theme.purple
import s.skillvsme.ui.theme.white

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@RequiresApi(Build.VERSION_CODES.Q)
@OptIn(ExperimentalMaterialApi::class, ExperimentalMaterial3Api::class)
@Composable
fun SubscriptionPlan(navController: NavController) {
    val scrollState = rememberScrollState()
    Scaffold(
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(scrollState),
                verticalArrangement = Arrangement.SpaceAround,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                ProfileAppBar(
                    backgroundColor = Color.Black,
                    modifier = Modifier,
                    backgroundImage = painterResource(
                        id = R.drawable.rectangle5,
                    ),
                    contentSize = 130.dp,
                    bottomCornerRadius = 30.dp,
                    cameraIconAvailable = true,
                    navController = navController
                )
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 10.dp, start = 16.dp, end = 16.dp),
                ) {
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(
                        text = "Kamal Tyagi",
                        fontWeight = FontWeight.Bold,
                        fontSize = 24.sp,
                        fontFamily = Fonts.jostFontFamily,
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    )
                    Spacer(modifier = Modifier.height(25.dp))
                    Text(
                        text = "Current Plan",
                        fontWeight = FontWeight.Normal,
                        fontSize = 18.sp,
                        fontFamily = Fonts.jostFontFamily
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    BorderedSurface(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(90.dp),
                        background = white,
                        cornerRadius = 15.dp,
                        borderWidth = 1.dp
                    ) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(
                                text = "1 hr/week",
                                modifier = Modifier
                                    .align(alignment = Alignment.CenterHorizontally)
                                    .padding(top = 10.dp)
                                    .fillMaxWidth(),
                                textAlign = TextAlign.Center,
                                fontFamily = Fonts.jostFontFamily,
                                fontWeight = FontWeight.SemiBold,
                                style = TextStyle(fontSize = 24.sp),
                                color = purple
                            )
                            Text(
                                text = "pay every 3 mo",
                                modifier = Modifier
                                    .align(alignment = Alignment.CenterHorizontally)
                                    .fillMaxWidth(),
                                textAlign = TextAlign.Center,
                                fontWeight = FontWeight.SemiBold,
                                fontFamily = Fonts.jostFontFamily,
                                style = TextStyle(fontSize = 20.sp),
                                color = purple,
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Transaction history",
                        modifier = Modifier.padding(top = 20.dp, bottom = 15.dp),
                        fontWeight = FontWeight.Normal,
                        fontSize = 18.sp,
                        fontFamily = Fonts.jostFontFamily
                    )
                    TransactionHistory(iconStart = painterResource(id = R.drawable.line_1))
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
                    TransactionHistory(iconStart = painterResource(id = R.drawable.line_1))
                    Divider(
                        color = Color.Gray,
                        modifier = Modifier
                            .height(1.dp)
                            .fillMaxWidth() // Adjust width as needed
                    )
                }
            }
        },
        bottomBar = { s.skillvsme.presentation.homeScreen.navigation.BottomNavigation(navController = navController) }
    )
}