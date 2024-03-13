package s.skillvsme.presentation.tutors.TutorsProfile

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import s.skillvsme.R
import s.skillvsme.common.Fonts
import s.skillvsme.common.SetStatusBarColor
import s.skillvsme.presentation.components.BorderedSurface
import s.skillvsme.presentation.components.ProfileAppBar
import s.skillvsme.presentation.tutors.navigation.BottomNavigation
import s.skillvsme.ui.theme.black
import s.skillvsme.ui.theme.darkGrey
import s.skillvsme.ui.theme.purple
import s.skillvsme.ui.theme.white

@RequiresApi(Build.VERSION_CODES.Q)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterialApi::class, ExperimentalMaterial3Api::class)
@Composable
fun PaymentSetting(navController: NavController) {
    SetStatusBarColor(color = Color.Transparent)
    Scaffold (
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.SpaceAround,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                ProfileAppBar(
                    backgroundColor = Color.Black, modifier = Modifier, backgroundImage = painterResource(
                        id = R.drawable.rectangle6,
                    ), contentSize = 151.dp, bottomCornerRadius = 30.dp, navController = navController
                )
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 40.dp, start = 16.dp, end = 16.dp),
                ) {
                    Text(
                        text = "Kamal Tyagi",
                        fontWeight = FontWeight.Bold,
                        fontSize = 24.sp,
                        fontFamily = Fonts.jostFontFamily,
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .padding(top = 30.dp)
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(text = "Payment Methods", fontWeight = FontWeight.Medium,fontSize = 18.sp,
                        fontFamily = Fonts.jostFontFamily,)

                    Spacer(modifier = Modifier.height(20.dp))
                    Text(text = "Primary",fontWeight = FontWeight.Normal,fontSize = 18.sp,
                        fontFamily = Fonts.jostFontFamily,)
                    BorderedSurface(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(84.dp),
                        borderWidth = 1.dp,
                        borderColor = darkGrey,
                        background = white,
                        cornerRadius = 15.dp,
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 20.dp),
                            verticalAlignment = Alignment.CenterVertically,

                            ) {
                            Image(
                                painter = painterResource(id = R.drawable.payment_1),
                                contentDescription = "", modifier = Modifier
                                    .padding(start = 15.dp, end = 10.dp)
                                    .width(34.dp)
                                    .height(24.dp)
                                    .wrapContentSize()
                            )
                            Row(modifier = Modifier.wrapContentSize()) {
                                Column() {
                                    Text(text = "XXXX-XXXX-XXXX-X456",fontWeight = FontWeight.SemiBold,fontSize = 16.sp,
                                        fontFamily = Fonts.jostFontFamily,)
                                    Spacer(modifier = Modifier.height(3.dp))
                                    Text(text = "Expires 06/25", fontWeight = FontWeight.Normal,fontSize = 14.sp,
                                        fontFamily = Fonts.jostFontFamily, color = darkGrey)
                                }
                                Spacer(modifier = Modifier.weight(1f))
                                Text(
                                    text = "Remove",
                                    modifier = Modifier.padding(end = 10.dp, top = 10.dp),
                                    color = purple,
                                    fontWeight = FontWeight.Normal,fontSize = 18.sp,
                                    fontFamily = Fonts.jostFontFamily,
                                )
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(15.dp))
                    Text(text = "Other",fontWeight = FontWeight.Normal,fontSize = 18.sp,
                        fontFamily = Fonts.jostFontFamily,)
                    BorderedSurface(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(84.dp),
                        borderColor = darkGrey,
                        borderWidth = 1.dp,
                        background = white,
                        cornerRadius = 15.dp,
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 25.dp),
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.payment_1),
                                contentDescription = "", modifier = Modifier
                                    .padding(start = 15.dp, end = 10.dp)
                                    .width(34.dp)
                                    .height(24.dp)
                            )
                            Row(modifier = Modifier.wrapContentSize()) {
                                Column() {
                                    Text(text = "XXXX-XXXX-XXXX-X456", fontWeight = FontWeight.SemiBold,fontSize = 16.sp,
                                        fontFamily = Fonts.jostFontFamily,)
                                    Spacer(modifier = Modifier.height(3.dp))
                                    Text(text = "Expires 06/25", fontWeight = FontWeight.Normal,fontSize = 14.sp,
                                        fontFamily = Fonts.jostFontFamily, color = darkGrey)
                                }
                                Spacer(modifier = Modifier.weight(1f))
                                Text(
                                    text = "Remove",
                                    modifier = Modifier.padding(end = 10.dp, top = 10.dp),
                                    color = purple,
                                    fontWeight = FontWeight.Normal,fontSize = 18.sp,
                                    fontFamily = Fonts.jostFontFamily,
                                )
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    BorderedSurface(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(84.dp),
                        borderColor = darkGrey,
                        borderWidth = 1.dp,
                        background = white,
                        cornerRadius = 15.dp,
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 25.dp),
                            verticalAlignment = Alignment.CenterVertically,

                            ) {
                            Image(
                                painter = painterResource(id = R.drawable.addition) ,
                                contentDescription = "", modifier = Modifier
                                    .padding(start = 15.dp, end = 10.dp)
                                    .size(30.dp)
                                    .background(Color.Black, CircleShape)
                                    .wrapContentSize()
                            )
                            Text(text = "Payment Method", fontWeight = FontWeight.Normal)
                        }

                    }

                }
            }
        },
        bottomBar = { BottomNavigation(
            navController = navController
        )
        }
    )

}