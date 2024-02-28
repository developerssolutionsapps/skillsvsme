package s.skillvsme.presentation.tutors.TutorsProfile

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import s.skillvsme.R
import s.skillvsme.common.Fonts
import s.skillvsme.common.Route
import s.skillvsme.common.SetStatusBarColor
import s.skillvsme.presentation.components.AmountTextField
import s.skillvsme.presentation.components.SkillvsmeButton
import s.skillvsme.presentation.tutors.navigation.BottomNavigation
import s.skillvsme.ui.theme.black
import s.skillvsme.ui.theme.white


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun TransactionSuccess(
    navController: NavController
) {
    SetStatusBarColor(color = black)
    val scrollState = rememberScrollState()
    Scaffold(
        content = {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(state = scrollState)
                    .background(white)
            ) {
                Column(
                    verticalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(332.dp)
                            .background(black),
                        contentAlignment = Alignment.TopCenter

                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.background_lines),
                            contentDescription = "Vehicles Image",
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(332.dp),
                            contentScale = ContentScale.Crop
                        )
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center,
                            modifier = Modifier
                                .fillMaxHeight(0.6f)
                                .fillMaxWidth()
                        ) {
                            Spacer(modifier = Modifier.height(60.dp))
                            Image(
                                painter = painterResource(R.drawable.baseline_check_circle),
                                contentDescription = "successful icon"
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            androidx.compose.material3.Text(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                text = "Transaction Successful",
                                fontWeight = FontWeight.Bold,
                                fontSize = 26.sp,
                                color = white,
                                fontFamily = Fonts.jostFontFamily,
                                textAlign = TextAlign.Center
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                        }
                    }
                    Box(
                        modifier = Modifier
                            .graphicsLayer {
                                translationY = -100.dp.toPx()
                            }
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier
                                .fillMaxWidth()
                                .drawBehind {
                                    drawRoundRect(
                                        white,
                                        cornerRadius = CornerRadius(48.dp.toPx())
                                    )
                                }
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(start = 20.dp, end = 20.dp),
                            ) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier
                                        .padding(top = 43.dp,),
                                ) {
                                    Text(
                                        fontFamily = Fonts.jostFontFamily,
                                        text = "Transaction ID:",
                                        fontSize = 18.sp,
                                        fontWeight = FontWeight.Normal,
                                        textAlign = TextAlign.Start
                                    )
                                    Spacer(modifier = Modifier.width(5.dp))
                                    Text(
                                        fontFamily = Fonts.jostFontFamily,
                                        modifier = Modifier,
                                        fontSize = 18.sp,
                                        text = "54821236877123",
                                        fontWeight = FontWeight.SemiBold,
                                    )
                                }
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier
                                        .padding(top = 11.dp,),
                                ) {
                                    Text(
                                        fontFamily = Fonts.jostFontFamily,
                                        text = "Destination :",
                                        fontSize = 18.sp,
                                        fontWeight = FontWeight.Normal,
                                        textAlign = TextAlign.Start
                                    )
                                    Spacer(modifier = Modifier.width(5.dp))
                                    Text(
                                        fontFamily = Fonts.jostFontFamily,
                                        modifier = Modifier,
                                        fontSize = 18.sp,
                                        text = "Paypal",
                                        fontWeight = FontWeight.SemiBold,
                                    )
                                }
                                Spacer(modifier = Modifier.height(72.dp))
                                AmountTextField()
                            }
                            Spacer(modifier = Modifier.height(43.dp))
                            SkillvsmeButton(
                                label = "Back to Home",
                                modifier = Modifier
                                    .padding(horizontal = 20.dp)
                                    .fillMaxWidth()
                                    .height(49.dp),
                                onClick = {
                                    navController.navigate(Route.Tutor.Home.Home)
                                }
                            )
                            Spacer(modifier = Modifier.height(100.dp))
                        }
                    }
                }
            }
        },
        bottomBar = { BottomNavigation(navController = navController) }
    )
}