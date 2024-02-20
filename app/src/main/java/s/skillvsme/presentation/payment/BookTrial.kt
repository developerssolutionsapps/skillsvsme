package s.skillvsme.presentation.payment

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.IconButton
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import s.skillvsme.R
import s.skillvsme.common.Fonts
import s.skillvsme.common.Route
import s.skillvsme.presentation.components.BorderedSurface
import s.skillvsme.presentation.components.SimpleAppBar
import s.skillvsme.presentation.components.SkillvsmeButton
import s.skillvsme.presentation.components.SkillvsmeSuccessScreen
import s.skillvsme.presentation.components.SkillvsmeText
import s.skillvsme.presentation.components.SkillvsmeTextField
import s.skillvsme.presentation.homeScreen.navigation.BottomNavigation
import s.skillvsme.ui.theme.black
import s.skillvsme.ui.theme.white


@OptIn(ExperimentalMaterial3Api::class)
@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun BookTrial(
    navController: NavController
) {
    Scaffold(
        topBar = {
            SimpleAppBar(navController = navController, text = "Book Trial")
        },
        content = {it ->
            Column(
                modifier = Modifier
                    .padding(it)
                    .padding(20.dp)
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    // Black rounded corner shape container
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(172.dp),
                        shape = RoundedCornerShape(26.dp),
                        backgroundColor = Color.Black
                    ) {
                        Box {
                            Image(
                                painter = painterResource(id = R.drawable.top_blackish_bg),
                                contentDescription = "bg",
                                modifier = Modifier.fillMaxSize(),
                                contentScale = ContentScale.Crop
                            )
                            Column(
                                modifier = Modifier.padding(16.dp)
                            ) {
                                Spacer(modifier = Modifier.height(16.dp))
                                Text(
                                    text = "Schedule a 30 min trial session with affordable price and start learning today",
                                    fontFamily = Fonts.jostFontFamily,
                                    fontWeight = FontWeight.Normal,
                                    color = white,
                                    fontSize = 20.sp,
                                )
                                Spacer(modifier = Modifier.height(16.dp))
                                Text(
                                    text = "10 USD/30 mins",
                                    fontFamily = Fonts.jostFontFamily,
                                    fontWeight = FontWeight.SemiBold,
                                    fontSize = 22.sp,
                                    color = white
                                )
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.Start,
                    ) {
                        SkillvsmeText(
                            value = "Payment Summary",
                            boldValue = true,
                            valueSize = 18,
                        )
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                    ) {
                        SkillvsmeText(
                            value = "30 min trial session",
                            valueSize = 18,
                        )
                        SkillvsmeText(
                            value = "10 USD",
                            boldValue = true,
                            valueSize = 18
                        )
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    Row {
                        Divider(
                            thickness = 1.dp,
                            color = black
                        )
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                    ) {
                        Text(
                            fontFamily = Fonts.jostFontFamily,
                            text = "Total",
                            color = black,
                            fontWeight = FontWeight.Bold,
                            style = TextStyle(fontSize = 24.sp)
                        )
                        Text(
                            fontFamily = Fonts.jostFontFamily,
                            text = "10.00 USD",
                            color = black,
                            fontWeight = FontWeight.Bold,
                            style = TextStyle(fontSize = 24.sp)
                        )
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    SkillvsmeText(
                        value = "Please enter your card details",
                        valueSize = 18,
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    BorderedSurface(
                        borderWidth = 1.dp,
                        background = white,
                        cornerRadius = 16.dp
                    ) {
                        SkillvsmeTextField(
                            modifier = Modifier
                                .padding(8.dp)
                                .fillMaxWidth(),
                            value = "1234-5678-9123-4567",
                            onChange = {},
                            label = "Card number",
                            hint = "",
                            hintSize = 18,
                            fieldDescription = ""
                        )
                        SkillvsmeTextField(
                            modifier = Modifier
                                .padding(8.dp)
                                .fillMaxWidth(),
                            value = "Jane Doe",
                            onChange = {},
                            hintSize = 18,
                            label = "Card holder name",
                            hint = "",
                            fieldDescription = ""
                        )
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .padding(8.dp)
                                .fillMaxWidth(),
                        ) {
                            SkillvsmeTextField(
                                modifier = Modifier
                                    .padding(8.dp)
                                    .fillMaxWidth(0.5f),
                                value = "03/28",
                                onChange = {},
                                hintSize = 18,
                                label = "Expiry Date",
                                hint = "MM/YY",
                                fieldDescription = ""
                            )
                            SkillvsmeTextField(
                                modifier = Modifier
                                    .padding(8.dp)
                                    .fillMaxWidth(),
                                value = "111",
                                hintSize = 18,
                                onChange = {},
                                label = "CFV",
                                hint = "",
                                fieldDescription = ""
                            )
                        }
                    }
                }
                Column {
                    Spacer(modifier = Modifier.height(30.dp))
                    SkillvsmeButton(
                        modifier = Modifier.fillMaxWidth(),
                        label = "Purchase trial",
                        primary = true,
                        onClick = {
                            navController.navigate(Route.Student.Payment.PaymentSuccess)
                        }
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    SkillvsmeButton(
                        modifier = Modifier.fillMaxWidth(),
                        label = "Back",
                        primary = false,
                        onClick = {
                            navController.popBackStack()
                        }
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
        },
        bottomBar = {
            BottomNavigation(navController = navController)
        }
    )
}