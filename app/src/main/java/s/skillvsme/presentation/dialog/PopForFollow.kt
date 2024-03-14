package s.skillvsme.presentation.dialog

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import s.skillvsme.common.Fonts
import s.skillvsme.presentation.components.SkillvsmeButton
import s.skillvsme.ui.theme.black
import s.skillvsme.ui.theme.white

@Composable
fun PopForFollow(value: String, setShowDialog: (Boolean) -> Unit, following: (Boolean) -> Unit, ) {
    Dialog(onDismissRequest = { setShowDialog(false) }) {
        Surface(
            shape = RoundedCornerShape(16.dp),
            color = black,

            ) {
            Box(
                contentAlignment = Alignment.Center
            ) {
                Column(
                    modifier = Modifier.padding(20.dp),
                    verticalArrangement = Arrangement.Center
                ) {

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Spacer(modifier = Modifier.weight(1f))
                        Image(
                            painter = painterResource(id = s.skillvsme.R.drawable.cancel),
                            contentDescription = "",
                            modifier = Modifier
                                .width(30.dp)
                                .height(30.dp)
                                .clickable { setShowDialog(false) }
                        )
                    }

                    Spacer(modifier = Modifier.height(20.dp))

                    Box(
                        modifier = Modifier
                            .padding(start = 108.dp, end = 90.dp)
                            .size(61.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(id = s.skillvsme.R.drawable.student),
                            contentDescription = "", modifier = Modifier.background(
                                white,
                                CircleShape
                            ).clip(CircleShape),
                            contentScale = ContentScale.Crop
                        )

                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Keria Swain",
                        Modifier
                            .padding(start = 100.dp, end = 80.dp),
                        fontSize = 18.sp,
                        fontFamily = Fonts.jostFontFamily,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(
                        text = "we will notify you when the tutor karia \nswain goes live or come online",
                        Modifier
                            .padding( ),fontSize = 18.sp,
                        fontFamily = Fonts.jostFontFamily,
                        fontWeight = FontWeight.Light,
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    SkillvsmeButton(
                        label = "Follow",
                        modifier = Modifier
                            .padding(start = 20.dp, end = 20.dp)
                            .fillMaxWidth(),
                        primary = false
                    ){
                        following(false)
                        setShowDialog(false)
                    }
                }
            }
        }
    }
}