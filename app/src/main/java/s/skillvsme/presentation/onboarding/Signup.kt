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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import s.skillvsme.R
import s.skillvsme.presentation.components.SkillvsmeButton
import s.skillvsme.presentation.components.SkillvsmeText
import s.skillvsme.presentation.components.SkillvsmeTextField
import s.skillvsme.ui.theme.black
import s.skillvsme.ui.theme.lightGrey
import s.skillvsme.ui.theme.white


@Composable
fun Signup() {
    val scrollState = rememberScrollState()
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
                    painter = painterResource(id = R.drawable.ic_launcher_background),
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
                                cornerRadius = CornerRadius(24.dp.toPx())
                            )
                        }
                ) {
                    Row(
                        modifier = Modifier
                            .padding(20.dp)
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Surface(
                            modifier = Modifier
                                .padding(top = 36.dp, end = 12.dp),
                            shape = RoundedCornerShape(12.dp),
                            color = black
                        ){
                            SkillvsmeText(
                                modifier = Modifier
                                    .padding(10.dp),
                                value = " +999 ",
                                boldValue = true,
                                valueColor = white
                            )
                        }
                        SkillvsmeTextField(
                            value = "",
                            onChange = {},
                            label = "",
                            hint = "Enter Your Phone Number",
                            fieldDescription = ""
                        ) {  }
                    }
                    SkillvsmeButton(
                        label = "Send Code",
                        modifier = Modifier
                            .padding(horizontal = 20.dp)
                            .fillMaxWidth()
                    ) {}
                    Spacer(modifier = Modifier.height(16.dp))
                    SkillvsmeText(value = "OK")
                    Spacer(modifier = Modifier.height(16.dp))
                    Card    (
                        shape = RoundedCornerShape(12.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = lightGrey,
                            ),
                        modifier = Modifier
                            .padding(horizontal = 20.dp)
                            .align(alignment = CenterHorizontally)
                            .fillMaxWidth(),
                    ) {
                        Spacer(modifier = Modifier.width(56.dp))
                        SkillvsmeText(
                            modifier = Modifier
                                .align(alignment = CenterHorizontally)
                                .padding(8.dp),
                            iconBefore = painterResource(R.drawable.google),
                            value = "Sign Up With Apple"
                        )
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    Card    (
                        shape = RoundedCornerShape(12.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = lightGrey,
                        ),
                        modifier = Modifier
                            .padding(horizontal = 20.dp)
                            .align(alignment = CenterHorizontally)
                            .fillMaxWidth(),
                    ) {
                        Spacer(modifier = Modifier.width(56.dp))
                        SkillvsmeText(
                            modifier = Modifier
                                .align(alignment = CenterHorizontally)
                                .padding(8.dp),
                            iconBefore = painterResource(R.drawable.google),
                            value = "Sign Up With Google"
                        )
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    TextEndingWithLink(
                        text = "Already have an account?",
                        linkText = "login in",
                        onLinkClick = {}
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
        }
    }
}