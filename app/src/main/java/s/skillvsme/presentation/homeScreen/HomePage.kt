package s.skillvsme.presentation.homeScreen

import android.annotation.SuppressLint
import android.widget.ImageView.ScaleType
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.BottomEnd
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Alignment.Companion.TopCenter
import androidx.compose.ui.Alignment.Companion.TopEnd
import androidx.compose.ui.Alignment.Companion.TopStart
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import s.skillvsme.R
import androidx.compose.ui.text.TextStyle
import s.skillvsme.common.Fonts
import s.skillvsme.ui.theme.black
import s.skillvsme.ui.theme.lightGrey
import s.skillvsme.ui.theme.purple

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")

@Composable
fun HomePage(
    navController: NavController
) {
    val scrollState = rememberScrollState()
    Scaffold(
        content = {
            Column(
                modifier = Modifier
                    .padding(30.dp)
                    .fillMaxSize()
                    .verticalScroll(scrollState)
            ) {
                // Black rounded corner shape container
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Hi Kamal!",
                        fontFamily = Fonts.headlandOneFontFamily,
                        fontWeight = FontWeight.Normal,
                        fontSize = 30.sp
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    IconButton(onClick = { /* Handle notification icon click */ }) {
                        Image(
                            painter = painterResource(id = R.drawable.notification),
                            contentDescription = null
                        )
                    }
                    Box(
                        modifier = Modifier
                            .size(30.dp)
                            .background(Color.Gray, CircleShape)
                    ) {
                        // Image
                        Image(
                            painter = (painterResource(id = R.drawable.ellipse1)),
                            contentDescription = "", Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop
                        )
                    }
                }
                Spacer(modifier = Modifier.height(15.dp))
                Card(
                    modifier = Modifier
                        .width(351.dp)
                        .height(196.dp),
                    shape = RoundedCornerShape(26.dp),
                    backgroundColor = Color.Black
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Spacer(modifier = Modifier.height(15.dp))
                        Text(
                            text = "Invite a friend and get\n20$ for free",
                            fontFamily = Fonts.jostFontFamily,
                            fontWeight = FontWeight.SemiBold,
                            color = Color.White,
                            fontSize = 26.sp,
                        )
                        Spacer(modifier = Modifier.height(25.dp))
                        Button(
                            onClick = { /* Handle Invite button click */ },
                            shape = RoundedCornerShape(21.dp),
                            modifier = Modifier
                                .width(128.dp)
                                .height(45.dp),
                            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)
                        ) {
                            Text(
                                text = "Invite", fontFamily = Fonts.jostFontFamily,
                                fontWeight = FontWeight.Normal,
                                color = Color.Black,
                                fontSize = 20.sp,
                            )
                        }
                    }
                }
                Spacer(modifier = Modifier.height(20.dp))
                // Streaming now text
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Streaming now",
                        fontFamily = Fonts.jostFontFamily,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.Black,
                        fontSize = 24.sp,
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Text(
                        text = "See all",
                        fontFamily = Fonts.jostFontFamily,
                        fontWeight = FontWeight.Normal,
                        color = purple,
                        fontSize = 18.sp,

                        )
                }
                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    modifier = Modifier.horizontalScroll(rememberScrollState())
                ) {
                    repeat(4) {
                        Box(
                            modifier = Modifier
                                .width(98.dp)
                                .height(120.dp)
                                .background(lightGrey, RoundedCornerShape(8.dp)),
                            contentAlignment = Alignment.Center
                        ) {
                            Column {
                                // Rounded image view
                                Box(
                                    modifier = Modifier
                                        .size(79.dp)
                                        .padding(
                                            top = 3.dp,
                                            bottom = 8.dp,
                                            start = 4.dp,
                                            end = 4.dp,
                                        )
                                        .background(Color.White, CircleShape),
                                    contentAlignment = Alignment.BottomCenter
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.profile),
                                        contentDescription = "",
                                        contentScale = ContentScale.Crop
                                    )
                                    Box(
                                        modifier = Modifier
                                            .graphicsLayer {
                                                translationY = +10.dp.toPx()
                                            }
                                            .width(30.dp)
                                            .height(20.dp)
                                            .background(Color.Red, RoundedCornerShape(5.dp))
                                    ) {
                                        Text(
                                            text = "Live",
                                            color = Color.White,
                                            fontSize = 12.sp,
                                            modifier = Modifier.padding(4.dp)
                                        )
                                    }
                                    // Image
                                }
                                // Live tag
                                Spacer(modifier = Modifier.height(10.dp))
                                Text(
                                    text = "John Wills", color = Color.Black,
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.Normal,
                                    fontFamily = Fonts.jostFontFamily,
                                    modifier = Modifier.padding(6.dp)
                                )
                            }
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Learning Plans",
                    fontFamily = Fonts.jostFontFamily,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Black,
                    fontSize = 24.sp,
                )
                Spacer(modifier = Modifier.height(8.dp))
                Card(
                    modifier = Modifier
                        .height(80.dp)
                        .fillMaxWidth()
                        .padding(vertical = 2.dp, horizontal = 2.dp),
                    shape = RoundedCornerShape(16.dp),
                    backgroundColor = Color.White,
                    border = BorderStroke(width = 1.dp, color = Color.Black),
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 20.dp, end = 20.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Card(
                            modifier = Modifier
                                .size(60.dp)
                                .padding(9.dp)
                                .align(Alignment.CenterVertically)

                        ) {
                            Text(
                                text = "1",
                                Modifier
                                    .background(Color.Black, CircleShape)
                                    .padding(5.dp),
                                fontFamily = Fonts.jostFontFamily,
                                color = Color.White, textAlign = TextAlign.Center,
                                fontWeight = FontWeight.SemiBold, style = TextStyle(
                                    fontSize = 24.sp
                                )
                            )
                        }
                        Text(
                            text = "Book a trial session", fontFamily = Fonts.jostFontFamily,
                            fontWeight = FontWeight.Normal,
                            color = black,
                            fontSize = 20.sp,
                        )
                        Spacer(modifier = Modifier.weight(1f))
                        androidx.compose.material3.Icon(
                            painter = painterResource(id = R.drawable.line1),
                            contentDescription = "",
                            tint = black,
                            modifier = Modifier.padding(start = 4.dp)

                        )
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
                // Thin black margin rectangular container bordered container
                Card(
                    modifier = Modifier
                        .height(80.dp)
                        .fillMaxWidth()
                        .padding(vertical = 2.dp, horizontal = 2.dp),
                    shape = RoundedCornerShape(16.dp),

                    backgroundColor = Color.White,
                    border = BorderStroke(width = 1.dp, color = Color.Black),
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 20.dp, end = 20.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Card(
                            modifier = Modifier
                                .size(60.dp)
                                .padding(9.dp)
                                .align(Alignment.CenterVertically)
                        ) {
                            Text(
                                text = "2",
                                Modifier
                                    .background(Color.Black, CircleShape)
                                    .padding(5.dp),
                                fontFamily = Fonts.jostFontFamily,
                                color = Color.White, textAlign = TextAlign.Center,
                                fontWeight = FontWeight.SemiBold, style = TextStyle(
                                    fontSize = 24.sp
                                )
                            )
                        }

                        Text(
                            text = "Choose A subscription plan", fontFamily = Fonts.jostFontFamily,
                            fontWeight = FontWeight.Normal,
                            color = black,
                            fontSize = 18.sp,
                        )

                        Spacer(modifier = Modifier.weight(1f))
                        androidx.compose.material3.Icon(
                            painter = painterResource(id = R.drawable.line1),
                            contentDescription = "",
                            tint = Color.Black,
                            modifier = Modifier.padding(start = 4.dp)

                        )
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))

                // Featured tutors text
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Featured tutors",
                        fontFamily = Fonts.jostFontFamily,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.Black,
                        fontSize = 24.sp,
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Text(
                        text = "See all",
                        fontFamily = Fonts.jostFontFamily,
                        fontWeight = FontWeight.Normal,
                        color = purple,
                        fontSize = 18.sp,
                    )
                }
                Spacer(modifier = Modifier.height(6.dp))
                Row(
                    modifier = Modifier.horizontalScroll(rememberScrollState())
                ) {
                    repeat(3) {
                        Box(
                            modifier = Modifier
                                .size(width = 169.dp, height = 147.dp)
                                .background(lightGrey, RoundedCornerShape(8.dp))
                                .padding(8.dp),

                            ) {
                            Row(
                                modifier = Modifier
                                    .padding(8.dp)
                                    .height(121.dp)
                                    .width(142.dp)
                            ) {
                                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                    Image(
                                        painter = painterResource(id = R.drawable.verified),
                                        contentDescription = ""
                                    )
                                    // Rounded image view
                                    Spacer(modifier = Modifier.width(10.dp))
                                    Box(
                                        modifier = Modifier
                                            .size(71.dp)
                                            .background(Color.White, CircleShape),
                                        contentAlignment = TopEnd
                                    ) {
                                        // Image
                                        Image(
                                            painter = painterResource(id = R.drawable.ellipse2),
                                            contentDescription = "",
                                            contentScale = ContentScale.Crop
                                        )
                                        Image(
                                            painter = painterResource(id = R.drawable.ellipse3),
                                            contentDescription = "",
                                            modifier = Modifier.graphicsLayer {
                                                translationY = +12.dp.toPx()
                                            }
                                        )
                                    }
                                    Text(
                                        text = "Michael Swift", fontFamily = Fonts.jostFontFamily,
                                        fontWeight = FontWeight.SemiBold,
                                        color = black,
                                        fontSize = 18.sp,
                                    )
                                }

                            }
                        }
                        Spacer(modifier = Modifier.width(10.dp))
                    }
                }
                Spacer(modifier = Modifier.height(20.dp))
            }

        },
        bottomBar = {
            s.skillvsme.presentation.homeScreen.navigation.BottomNavigation(navController = navController)
        }
    )
}

