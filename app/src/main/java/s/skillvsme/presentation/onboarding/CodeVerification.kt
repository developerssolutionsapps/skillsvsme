package s.skillvsme.presentation.onboarding

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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import s.skillvsme.R
import s.skillvsme.common.Fonts
import s.skillvsme.common.Route
import s.skillvsme.common.SetStatusBarColor
import s.skillvsme.presentation.components.SkillvsmeButton
import s.skillvsme.presentation.navigation.LoginDetails
import s.skillvsme.ui.theme.black
import s.skillvsme.ui.theme.white


@Composable
fun CodeVerification(
    navController: NavController,
    loginDetails: LoginDetails

) {
    SetStatusBarColor(color = Color.Transparent)
    val scrollState = rememberScrollState()
    var otpCodeValue by remember { mutableStateOf("") }
    val onOtpTextChange: (String, Boolean) -> Unit = { otp, isComplete ->
        otpCodeValue = otp
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(state = scrollState)
            .background(white,)
    ){
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(black),
                contentAlignment = Alignment.TopCenter

            ){
                Image(
                    painter = painterResource(id = R.drawable.background_lines),
                    contentDescription = "Vehicles Image",
                    modifier    = Modifier
                        .fillMaxWidth()
                        .height(347.dp),
                    contentScale = ContentScale.Crop
                )
                Column {
                    Spacer(modifier = Modifier.height(96.dp))
                    Image(
                        painter = painterResource(id = R.drawable.logo),
                        contentDescription = "logo",
                        modifier = Modifier
                            .size(87.dp)
                            .graphicsLayer {
                                this.scaleX = 1.5f
                                this.scaleY = 1.5f
                            }
                    )
                }
                Row(
                    modifier = Modifier
                        .padding(top = 70.dp)
                        .padding(start = 20.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Box(
                        modifier = Modifier
                            .size(24.dp)
                            .clip(RoundedCornerShape(10.dp)),
                        contentAlignment = Alignment.Center
                    ){
                        Image(
                            painter = painterResource(id = R.drawable.back_arrow_white),
                            contentDescription = "back arrow",
                            modifier = Modifier
                                .clickable {
                                    navController.popBackStack()
                                }
                                .size(16.dp)
                        )
                    }
                }
            }
            Box(
                modifier = Modifier
                    .graphicsLayer {
                        translationY = -100.dp.toPx()
                    }
            ){
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
                            .padding(20.dp)
                            .fillMaxWidth(),
                    ) {
                        Spacer(modifier = Modifier.height(26.dp))
                        Text(
                            fontFamily = Fonts.jostFontFamily,
                            modifier = Modifier
                                .fillMaxWidth(),
                            text = "Verify phone number",
                            style = MaterialTheme.typography.body1,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center
                        )
                        Spacer(modifier = Modifier.height(12.dp))
                        Text(
                            fontFamily = Fonts.jostFontFamily,
                            modifier = Modifier
                                .fillMaxWidth(),
                            text = "We have sent you a one time verification code on to +999XXXXXXX45 ",
                            style = MaterialTheme.typography.body1,
                            fontWeight = FontWeight.Normal,
                            textAlign = TextAlign.Center
                        )
                    }
                    Spacer(modifier = Modifier.height(53.dp))
                    OtpTextField(
                        otpText = otpCodeValue,
                        onOtpTextChange = onOtpTextChange,
                        otpCount = 4
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    TextEndingWithLink(
                        text = "Didn't receive code?",
                        linkText = "Resend",
                        onLinkClick = {
                            otpCodeValue = ""
                        }
                    )
                    Spacer(modifier = Modifier.height(57.dp))
                    SkillvsmeButton(
                        enabled = otpCodeValue != "",
                        label = "Continue",
                        modifier = Modifier
                            .padding(horizontal = 20.dp)
                            .fillMaxWidth(),
                        onClick = {
                            if (loginDetails.loginAsTutor){
                                navController.navigate(Route.Tutor.Home.Home)
                            }else
                            {navController.navigate(Route.Student.Home.Home)}

                        }
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
        }
    }
}