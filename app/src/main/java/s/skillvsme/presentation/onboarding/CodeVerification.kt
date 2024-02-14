package s.skillvsme.presentation.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import s.skillvsme.presentation.components.SkillvsmeButton
import s.skillvsme.presentation.components.SkillvsmeText
import s.skillvsme.ui.theme.white


@Composable
fun CodeVerification(
    navController: NavController
) {
    val scrollState = rememberScrollState()
    val onOtpTextChange: (String, Boolean) -> Unit = { otp, isComplete ->
        println("OTP entered: $otp, isComplete: $isComplete")
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
                    .background(Color(0XFFF2F3F4)),
                contentAlignment = Alignment.TopCenter

            ){
                Image(
                    painter = painterResource(id = R.drawable.top_blackish_bg),
                    contentDescription = "Vehicles Image",
                    modifier    = Modifier
                        .fillMaxWidth()
                        .height(300.dp),
                    contentScale = ContentScale.Crop
                )
                Column {
                    Spacer(modifier = Modifier.height(50.dp))
                    Image(
                        painter = painterResource(id = R.drawable.logo),
                        contentDescription = "logo",
                        modifier = Modifier
                            .size(100.dp)
                            .graphicsLayer {
                                this.scaleX = 1.5f
                                this.scaleY = 1.5f
                            }
                    )
                }
                Row(
                    modifier = Modifier
                        .padding(4.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Box(
                        modifier = Modifier
                            .size(32.dp)
                            .clip(RoundedCornerShape(10.dp)),
                        contentAlignment = Alignment.Center
                    ){
                        Image(
                            painter = painterResource(id = R.drawable.back_arrow_white),
                            contentDescription = "back arrow",
                            modifier = Modifier
                                .size(16.dp)
                                .graphicsLayer {
                                    this.scaleX = 1.5f
                                    this.scaleY = 1.5f
                                }
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
                        Text(
                            fontFamily = Fonts.jostFontFamily,
                            modifier = Modifier
                                .padding(10.dp)
                                .fillMaxWidth(),
                            text = "Verify Phone Number",
                            style = MaterialTheme.typography.body1,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center
                        )
                        Text(
                            fontFamily = Fonts.jostFontFamily,
                            modifier = Modifier
                                .padding(10.dp)
                                .fillMaxWidth(),
                            text = "We have sent you a one time verification code on to +999XXXXXXX45 ",
                            style = MaterialTheme.typography.body1,
                            fontWeight = FontWeight.Normal,
                            textAlign = TextAlign.Center
                        )
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    OtpTextField(otpText = "", onOtpTextChange = onOtpTextChange, otpCount = 4)
                    Spacer(modifier = Modifier.height(16.dp))
                    TextEndingWithLink(
                        text = "Didn't receive code?",
                        linkText = "Resend",
                        onLinkClick = {}
                    )
                    Spacer(modifier = Modifier.height(32.dp))
                    SkillvsmeButton(
                        label = "Continue",
                        modifier = Modifier
                            .padding(horizontal = 20.dp)
                            .fillMaxWidth()
                    ) {}
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
        }
    }
}