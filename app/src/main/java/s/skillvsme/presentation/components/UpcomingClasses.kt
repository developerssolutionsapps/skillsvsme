package s.skillvsme.presentation.components

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
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
import s.skillvsme.R
import s.skillvsme.common.Fonts
import s.skillvsme.ui.theme.black
import kotlin.random.Random


@Composable
fun UpcomingClasses(
    join: String,
    buttonOnclick: () -> Unit = {},
) {
    val showDialog =  remember { mutableStateOf(false) }
    if(showDialog.value)
        CustomDialog(
            value = "You will be able to join the classroom 10 min before the class starts",
            buttonText = "Confirm",
            setShowDialog = {
            showDialog.value = it
        })
    Column(
        modifier = Modifier
            .wrapContentSize()
    ) {
        Surface(
            border = BorderStroke(1.dp, black),
                modifier = Modifier
                .height(175.dp)
                .fillMaxWidth(),
                    shape = RoundedCornerShape(21.dp)
        ) {
            Box(
                modifier = Modifier
                    .background(if (join == "Join") Color.Black else Color.White)
            ) {
                Column(
                    modifier = Modifier.padding(8.dp),
                ) {
                    Text(
                        text = "12:30pm - 2:00pm",
                        fontFamily = Fonts.jostFontFamily,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 18.sp,
                        modifier = Modifier.padding(start = 12.dp, top = 12.dp),
                        style = MaterialTheme.typography.subtitle1.copy(fontWeight = FontWeight.Bold),
                        color = if (join == "Join") Color.White else Color.Black
                    )
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(start = 12.dp)
                    ) {
                        CircularImageView()
                        Column {
                            Text(
                                text = "Hady Swify", fontFamily = Fonts.jostFontFamily,
                                fontWeight = FontWeight.Normal,
                                fontSize = 18.sp,
                                modifier = Modifier.padding(start = 10.dp),
                                color = if (join == "Join") Color.White else Color.Black
                            )
                            Row(
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.location),
                                    modifier = Modifier
                                        .size(16.dp)
                                        .padding(start = 7.dp),
                                    contentDescription = "Location icon",
                                    tint = if (join == "Join") Color.White else Color.Black
                                )
                                Text(
                                    text = "Markesh, Morocco | 1:30pm",
                                    modifier = Modifier
                                        .padding(start = 2.dp, top = 2.5.dp, bottom = 2.5.dp),
                                    fontFamily = Fonts.jostFontFamily,
                                    fontWeight = FontWeight.Normal,
                                    fontSize = 10.sp,
                                    color = if (join == "Join") Color.White else Color.Black
                                )
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(9.dp))
                    Button(
                        onClick = {
                            if(join == "Join"){
                                val randBool = Random.nextBoolean()
                                if(randBool) {
                                    showDialog.value = true
                                } else {
                                    buttonOnclick()
                                }
                            }
                            buttonOnclick()
                                  },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(49.dp)
                            .padding(start = 12.dp, end = 11.dp)
                            .clip(RoundedCornerShape(21.dp)),
                        colors = ButtonDefaults.buttonColors(if (join == "Join") Color.White else Color.Black),
                    ) {
                        Text(text = join, color = if (join == "Join") Color.Black else Color.White)
                    }
                }
            }
        }
    }
}
@Composable
fun CircularImageView() {
    Box(
        modifier = Modifier
            .size(44.dp)
            .clip(RoundedCornerShape(56.dp))
            .background(color = Color.Blue)
    ) {
        Image(
            painter = painterResource(id = R.drawable.image_coming_class),
            contentDescription = "",
            contentScale = ContentScale.Crop
        )
    }
}
