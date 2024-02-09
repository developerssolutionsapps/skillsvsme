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
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Alignment.Companion.TopCenter
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
import s.skillvsme.ui.theme.lightGrey

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")

@Composable
fun HomePage(
    navController: NavController
) {
    val scrollState = rememberScrollState()
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Hi Kamal!")
                },
                backgroundColor = Color.White,
                actions = {
                    IconButton(onClick = { /* Handle notification icon click */ }) {
                        Icon(Icons.Default.Notifications, contentDescription = null)
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    // Rounded image view
                    Box(
                        modifier = Modifier
                            .size(30.dp)
                            .background(Color.Gray, CircleShape)
                    ) {
                        // Image
                        Image(painter =(painterResource(id =R.drawable.profile )) ,
                            contentDescription ="",Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop )
                    }
                }
            )
        },
        content = {

                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxSize()
                        .verticalScroll(scrollState)
                ) {
                    // Black rounded corner shape container
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(190.dp)
                            .padding(vertical = 8.dp),
                        shape = RoundedCornerShape(16.dp),
                        backgroundColor = Color.Black
                    ) {
                        Column(
                            modifier = Modifier.padding(16.dp)
                        ) {
                            Text(
                                text = "Invite a Friend and get \n$20 for free",
                                color = Color.White,
                                fontSize = 16.sp
                            )
                            Spacer(modifier = Modifier.height(20.dp))
                            Button(
                                onClick = { /* Handle Invite button click */ },
                                shape = RoundedCornerShape(16.dp),
                               modifier= Modifier.width(100.dp),
                                colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)
                            ) {
                                Text(text = "Invite")
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    // Streaming now text
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Streaming now",
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(start = 16.dp)
                        )
                        Spacer(modifier = Modifier.weight(1f))
                        Text(
                            text = "See all",
                            color = Color(0.7f, 0f, 0.5f, 1f),
                            modifier = Modifier.padding(end = 16.dp)
                        )
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    Row(
                        modifier = Modifier.horizontalScroll(rememberScrollState())
                    ) {
                        repeat(4) {
                            Box(
                                modifier = Modifier
                                    .width(100.dp)
                                    .height(140.dp)
                                    .background(lightGrey, RoundedCornerShape(8.dp))
                                    .padding(5.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                Column {
                                    // Rounded image view
                                    Box(
                                        modifier = Modifier
                                            .size(80.dp)
                                            .padding(top = 10.dp)
                                            .background(Color.White, CircleShape),
                                        contentAlignment = Alignment.BottomCenter
                                    ) {
                                        Image(painter = painterResource(id = R.drawable.profile), contentDescription ="", contentScale = ContentScale.Crop )
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
                                        text = "John Willis", color = Color.Black,
                                        fontSize = 12.sp,
                                        modifier = Modifier.padding(4.dp))
                                }
                            }
                            Spacer(modifier = Modifier.width(8.dp))
                        }
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = "Learning Plans",
                        fontWeight = FontWeight.Bold,
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
                                Text(text = "1",
                                    Modifier
                                        .background(Color.Black, CircleShape)
                                        .padding(9.dp),
                                    color = Color.White, textAlign = TextAlign.Center,
                                    fontWeight = FontWeight.Bold,style = TextStyle(
                                        fontSize = 23.sp
                                    ))
                            }
                            Text(text = "Book a trial session",)
                            Spacer(modifier = Modifier.weight(1f))
                            Icon(
                                imageVector = Icons.Default.ArrowForward,
                                contentDescription = null,
                                tint = Color.Black
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
                                Text(text = "2",
                                    Modifier
                                        .background(Color.Black, CircleShape)
                                        .padding(9.dp),
                                    color = Color.White, textAlign = TextAlign.Center,
                                    fontWeight = FontWeight.Bold,style = TextStyle(
                                        fontSize = 23.sp
                                    ))
                            }

                            Text(text = "Choose A subscription plan",style = TextStyle(
                                fontSize = 15.sp
                            ))
                            Spacer(modifier = Modifier.weight(1f))
                            Icon(
                                imageVector = Icons.Default.ArrowForward,
                                contentDescription = null,
                                tint = Color.Black,
                                modifier = Modifier.padding(end = 8.dp)

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
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(start = 16.dp)
                        )
                        Spacer(modifier = Modifier.weight(1f))
                        Text(
                            text = "See all",
                            color = Color(0.7f, 0f, 0.5f, 1f),
                            modifier = Modifier.padding(end = 16.dp)
                        )
                    }
                    Spacer(modifier = Modifier.weight(1f))
                    Row(
                        modifier = Modifier.horizontalScroll(rememberScrollState())
                    ) {
                        repeat(3) {
                            Box(
                                modifier = Modifier
                                    .size(150.dp)
                                    .background(lightGrey, RoundedCornerShape(8.dp))
                                    .padding(8.dp),

                            ) {
                                Row(modifier = Modifier.padding(8.dp)) {
                                    Image(painter = painterResource(id = R.drawable.verified), contentDescription = "")
                                    // Rounded image view
                                    Spacer(modifier = Modifier.width(10.dp))
                                    Box(
                                        modifier = Modifier
                                            .size(50.dp)
                                            .background(Color.White, CircleShape)
                                    ) {
                                        // Image
                                        Image(painter = painterResource(id = R.drawable.profi), contentDescription = "", contentScale = ContentScale.Crop)
                                    }

                                }
                            }
                            Spacer(modifier = Modifier.width(10.dp))
                        }
                    }
                }

        },
        bottomBar = {
            s.skillvsme.presentation.homeScreen.navigation.BottomNavigation(navController = navController)
        }
    )
}

