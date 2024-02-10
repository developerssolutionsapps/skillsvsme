package s.skillvsme.presentation.homeScreen



import android.annotation.SuppressLint
import android.graphics.Matrix
import android.graphics.RectF
import android.widget.ImageView.ScaleType
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.asComposePath
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.PathParser
import androidx.navigation.NavController
import s.skillvsme.R

@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "RestrictedApi")

@Composable
fun HomeScreen(
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
                        Image(painter =(painterResource(id =R.drawable.account )) ,
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
                Box(
                    modifier = Modifier

                        .width(352.dp)
                        .height(38.dp)
                        .clip(RoundedCornerShape(topStart = 0.dp, topEnd = 0.dp, bottomStart = 0.dp, bottomEnd = 0.dp))
                        .background(Color.Transparent)
                        .padding(start = 0.dp, top = 0.dp, end = 0.dp, bottom = 0.dp)
                        .alpha(1f)
                ) {
                    Text(
                        text = "Hi Kamal!",
                        textAlign = TextAlign.Start,
                        fontSize = 30.sp,
                        textDecoration = TextDecoration.None,
                        letterSpacing = 0.sp,

                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier
                            .align(Alignment.CenterStart)
                            .width(152.dp)
                            .alpha(1f),
                        color = Color(red = 0f, green = 0f, blue = 0f, alpha = 1f),
                        fontWeight = FontWeight.Normal,
                        fontStyle = FontStyle.Normal,
                    )
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

                // Horizontal scrollable containers with gray background and Live tag
                Row(
                    modifier = Modifier.horizontalScroll(rememberScrollState())
                ) {
                    repeat(6) {

                        Box(


                            modifier = Modifier

                                .width(98.dp)
                                .height(120.dp)
                                .clip(
                                    RoundedCornerShape(
                                        topStart = 0.dp,
                                        topEnd = 0.dp,
                                        bottomStart = 0.dp,
                                        bottomEnd = 0.dp
                                    )
                                )
                                .background(Color.Transparent)

                                .padding(start = 0.dp, top = 0.dp, end = 0.dp, bottom = 0.dp)

                                .alpha(1f)


                        ) {

                            Box(
                                modifier = Modifier
                                    .width(98.dp)
                                    .height(120.dp)
                                    .clip(
                                        RoundedCornerShape(
                                            topStart = 8.dp,
                                            topEnd = 8.dp,
                                            bottomStart = 8.dp,
                                            bottomEnd = 8.dp
                                        )
                                    )
                                    .align(Alignment.TopStart)

                                    .background(
                                        Color(
                                            red = 0.9411764740943909f,
                                            green = 0.9490196108818054f,
                                            blue = 0.9607843160629272f,
                                            alpha = 1f
                                        )
                                    )
                            )
                            Box(


                                modifier = Modifier

                                    .width(98.dp)
                                    .height(145.dp)
                                    .clip(
                                        RoundedCornerShape(
                                            topStart = 0.dp,
                                            topEnd = 0.dp,
                                            bottomStart = 0.dp,
                                            bottomEnd = 0.dp
                                        )
                                    )
                                    .background(Color.Transparent)

                                    .padding(
                                        start = 13.dp,
                                        top = 12.dp,
                                        end = 13.dp,
                                        bottom = 36.dp
                                    )
                                    .align(Alignment.CenterStart)
                                    .alpha(1f)


                            ) {

                                Box(


                                    modifier = Modifier

                                        .width(72.dp)
                                        .height(97.dp)
                                        .clip(
                                            RoundedCornerShape(
                                                topStart = 0.dp,
                                                topEnd = 0.dp,
                                                bottomStart = 0.dp,
                                                bottomEnd = 0.dp
                                            )
                                        )
                                        .background(Color.Transparent)

                                        .padding(
                                            start = 0.dp,
                                            top = 0.dp,
                                            end = 0.dp,
                                            bottom = 25.dp
                                        )
                                        .align(Alignment.TopStart)
                                        .alpha(1f)


                                ) {

                                    Box(
                                        modifier = Modifier
                                            .width(66.dp)
                                            .height(66.dp)
                                            .clip(
                                                RoundedCornerShape(
                                                    topStart = 39.dp,
                                                    topEnd = 39.dp,
                                                    bottomStart = 39.dp,
                                                    bottomEnd = 39.dp
                                                )
                                            )
                                            .align(Alignment.Center)

                                            .background(
                                                Color(
                                                    red = 0.8509804010391235f,
                                                    green = 0.8509804010391235f,
                                                    blue = 0.8509804010391235f,
                                                    alpha = 1f
                                                )
                                            )
                                    )
                                    Box(
                                        modifier = Modifier
                                            .width(32.dp)
                                            .height(15.dp)
                                            .clip(
                                                RoundedCornerShape(
                                                    topStart = 4.dp,
                                                    topEnd = 4.dp,
                                                    bottomStart = 4.dp,
                                                    bottomEnd = 4.dp
                                                )
                                            )
                                            .align(Alignment.TopCenter)

                                            .background(
                                                Color(
                                                    red = 0.9682811498641968f,
                                                    green = 0.14885932207107544f,
                                                    blue = 0.04841405898332596f,
                                                    alpha = 1f
                                                )
                                            )
                                    )

                                    Text(
                                        text = "Live",
                                        textAlign = TextAlign.Center,
                                        fontSize = 10.sp,
                                        textDecoration = TextDecoration.None,
                                        letterSpacing = 0.sp,
                                        lineHeight = 11.sp,
                                        overflow = TextOverflow.Ellipsis,
                                        modifier = Modifier
                                            .align(Alignment.TopCenter)
                                            .width(17.dp)

                                            //.height(7.dp)

                                            .alpha(1f),
                                        color = Color(
                                            red = 0.9916145205497742f,
                                            green = 0.9916145205497742f,
                                            blue = 0.9916145205497742f,
                                            alpha = 1f
                                        ),
                                        fontWeight = FontWeight.Normal,
                                        fontStyle = FontStyle.Normal,
                                    )
                                }


                                Text(
                                    text = "John wills",
                                    textAlign = TextAlign.Center,
                                    fontSize = 16.sp,
                                    textDecoration = TextDecoration.None,
                                    letterSpacing = 0.sp,
                                    lineHeight = 18.sp,
                                    overflow = TextOverflow.Ellipsis,
                                    modifier = Modifier
                                        .align(Alignment.TopCenter)
                                        .width(64.dp)

                                        //.height(18.dp)

                                        .alpha(1f),
                                    color = Color(
                                        red = 0.018281172960996628f,
                                        green = 0.018098369240760803f,
                                        blue = 0.018098369240760803f,
                                        alpha = 1f
                                    ),
                                    fontWeight = FontWeight.Normal,
                                    fontStyle = FontStyle.Normal,
                                )
                            }
                        }
                        Spacer(modifier = Modifier.height(16.dp))
                    }
                    }
                Spacer(modifier = Modifier.height(16.dp))

                // Learning Plans text
                Text(
                    text = "Learning Plans",
                    fontWeight = FontWeight.Bold,
                )
                Spacer(modifier = Modifier.height(8.dp))
                // Thin black margin rectangular container bordered containe

                Column(
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.Top),
                    modifier = Modifier

                        .width(354.dp)
                        .height(166.dp)
                        .clip(RoundedCornerShape(topStart = 0.dp, topEnd = 0.dp, bottomStart = 0.dp, bottomEnd = 0.dp))
                        .background(Color.Transparent)

                        .padding(start = 0.dp, top = 0.dp, end = 0.dp, bottom = 0.dp)

                        .alpha(1f)
                        .verticalScroll(rememberScrollState()),

                    ) {

                    Box(


                        modifier = Modifier

                            .width(354.dp)
                            .height(79.dp)
                            .clip(RoundedCornerShape(topStart = 0.dp, topEnd = 0.dp, bottomStart = 0.dp, bottomEnd = 0.dp))
                            .background(Color.Transparent)

                            .padding(start = 0.dp, top = 0.dp, end = 0.dp, bottom = 0.dp)

                            .alpha(1f)


                    ) {

                        Box(
                            modifier = Modifier
                                .width(354.dp)
                                .height(79.dp)
                                .clip(RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp, bottomStart = 20.dp, bottomEnd = 20.dp))
                                .align(Alignment.TopCenter)
                                .border(1.dp, Color(red = 0f, green = 0f, blue = 0f, alpha = 1f), RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp, bottomStart = 20.dp, bottomEnd = 20.dp))
                                .background(Color.Transparent)
                        )
                        Box(


                            modifier = Modifier

                                .width(354.dp)
                                .height(61.dp)
                                .clip(RoundedCornerShape(topStart = 0.dp, topEnd = 0.dp, bottomStart = 0.dp, bottomEnd = 0.dp))
                                .background(Color.Transparent)

                                .padding(start = 18.dp, top = 19.dp, end = 19.dp, bottom = 0.dp)
                                .align(Alignment.TopCenter)
                                .alpha(1f)


                        ) {


                            Text(
                                text = "Book a trial session",
                                textAlign = TextAlign.Start,
                                fontSize = 20.sp,
                                textDecoration = TextDecoration.None,
                                letterSpacing = 0.sp,
                                lineHeight = 23.sp,
                                overflow = TextOverflow.Ellipsis,
                                modifier = Modifier
                                    .align(Alignment.Center)
                                    .width(162.dp)

                                    //.height(23.dp)

                                    .alpha(1f),
                                color = Color(red = 0f, green = 0f, blue = 0f, alpha = 1f),
                                fontWeight = FontWeight.Normal,
                                fontStyle = FontStyle.Normal,
                            )

                            Box(


                                modifier = Modifier

                                    .width(317.dp)
                                    .height(42.dp)
                                    .clip(RoundedCornerShape(topStart = 0.dp, topEnd = 0.dp, bottomStart = 0.dp, bottomEnd = 0.dp))
                                    .background(Color.Transparent)

                                    .padding(start = 0.dp, top = 0.dp, end = 275.dp, bottom = 0.dp)
                                    .align(Alignment.CenterStart)
                                    .alpha(1f)


                            ) {


                                Text(
                                    text = "1",
                                    textAlign = TextAlign.Center,
                                    fontSize = 24.sp,
                                    textDecoration = TextDecoration.None,
                                    letterSpacing = 0.sp,
                                    lineHeight = 27.sp,
                                    overflow = TextOverflow.Ellipsis,
                                    modifier = Modifier
                                        .align(Alignment.Center)
                                        .width(12.dp)

                                        //.height(27.dp)

                                        .alpha(1f),
                                    color = Color(red = 0.9916145205497742f, green = 0.9916145205497742f, blue = 0.9916145205497742f, alpha = 1f),
                                    fontWeight = FontWeight.SemiBold,
                                    fontStyle = FontStyle.Normal,
                                )
                            }

                            Canvas(
                                modifier = Modifier
                                    .width(25.dp)
                                    .height(0.dp)
                                    //.fillMaxWidth()
                                    //.aspectRatio(1f)
                                    .align(Alignment.CenterStart)
                            ) {
                                val fillPath = PathParser.createPathFromPathData("M 0 0 L 25 0 ")
                                //fillPath.fillType = Path.FillType.EVEN_ODD
                                val rectF = RectF()
                                fillPath.computeBounds(rectF, true)
                                val matrix = Matrix()
                                val scale = minOf( size.width / rectF.width(), size.height / rectF.height() )
                                matrix.setScale(scale, scale)
                                fillPath.transform(matrix)
                                val composePathFill = fillPath.asComposePath()

                                drawPath(path = composePathFill, color = Color.Transparent, style = Fill)
                                drawPath(path = composePathFill, color = Color(red = 0f, green = 0f, blue = 0f, alpha = 1f), style = Stroke(width = 5f, miter = 4f, join = StrokeJoin.Round))
                            }}
                    }

                    Box(


                        modifier = Modifier

                            .width(354.dp)
                            .height(79.dp)
                            .clip(RoundedCornerShape(topStart = 0.dp, topEnd = 0.dp, bottomStart = 0.dp, bottomEnd = 0.dp))
                            .background(Color.Transparent)

                            .padding(start = 0.dp, top = 0.dp, end = 0.dp, bottom = 0.dp)

                            .alpha(1f)


                    ) {

                        Box(
                            modifier = Modifier
                                .width(354.dp)
                                .height(79.dp)
                                .clip(RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp, bottomStart = 20.dp, bottomEnd = 20.dp))
                                .align(Alignment.TopCenter)
                                .border(1.dp, Color(red = 0f, green = 0f, blue = 0f, alpha = 1f), RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp, bottomStart = 20.dp, bottomEnd = 20.dp))
                                .background(Color.Transparent)
                        )
                        Box(


                            modifier = Modifier

                                .width(354.dp)
                                .height(61.dp)
                                .clip(RoundedCornerShape(topStart = 0.dp, topEnd = 0.dp, bottomStart = 0.dp, bottomEnd = 0.dp))
                                .background(Color.Transparent)

                                .padding(start = 18.dp, top = 19.dp, end = 19.dp, bottom = 0.dp)
                                .align(Alignment.TopCenter)
                                .alpha(1f)


                        ) {


                            Text(
                                text = "Choose a subscription plan",
                                textAlign = TextAlign.Start,
                                fontSize = 20.sp,
                                textDecoration = TextDecoration.None,
                                letterSpacing = 0.sp,
                                lineHeight = 23.sp,
                                overflow = TextOverflow.Ellipsis,
                                modifier = Modifier
                                    .align(Alignment.Center)
                                    .width(231.dp)

                                    //.height(23.dp)

                                    .alpha(1f),
                                color = Color(red = 0f, green = 0f, blue = 0f, alpha = 1f),
                                fontWeight = FontWeight.Normal,
                                fontStyle = FontStyle.Normal,
                            )

                            Box(

                                modifier = Modifier

                                    .width(317.dp)
                                    .height(42.dp)
                                    .clip(RoundedCornerShape(topStart = 0.dp, topEnd = 0.dp, bottomStart = 0.dp, bottomEnd = 0.dp))
                                    .background(Color.Transparent)

                                    .padding(start = 0.dp, top = 0.dp, end = 275.dp, bottom = 0.dp)
                                    .align(Alignment.CenterStart)
                                    .alpha(1f)


                            ) {


                                Text(
                                    text = "2",
                                    textAlign = TextAlign.Center,
                                    fontSize = 24.sp,
                                    textDecoration = TextDecoration.None,
                                    letterSpacing = 0.sp,
                                    lineHeight = 27.sp,
                                    overflow = TextOverflow.Ellipsis,
                                    modifier = Modifier
                                        .align(Alignment.Center)
                                        .width(16.dp)

                                        //.height(27.dp)

                                        .alpha(1f),
                                    color = Color(red = 0.9916145205497742f, green = 0.9916145205497742f, blue = 0.9916145205497742f, alpha = 1f),
                                    fontWeight = FontWeight.SemiBold,
                                    fontStyle = FontStyle.Normal,
                                )
                            }

                            Canvas(
                                modifier = Modifier
                                    .width(25.dp)
                                    .height(0.dp)
                                    //.fillMaxWidth()
                                    //.aspectRatio(1f)
                                    .align(Alignment.CenterStart)
                            ) {
                                val fillPath = PathParser.createPathFromPathData("M 0 0 L 25 0 ")
                                //fillPath.fillType = Path.FillType.EVEN_ODD
                                val rectF = RectF()
                                fillPath.computeBounds(rectF, true)
                                val matrix = Matrix()
                                val scale = minOf( size.width / rectF.width(), size.height / rectF.height() )
                                matrix.setScale(scale, scale)
                                fillPath.transform(matrix)
                                val composePathFill = fillPath.asComposePath()

                                drawPath(path = composePathFill, color = Color.Transparent, style = Fill)
                                drawPath(path = composePathFill, color = Color(red = 0f, green = 0f, blue = 0f, alpha = 1f), style = Stroke(width = 5f, miter = 4f, join = StrokeJoin.Round))
                            }}
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
                // Thin black margin rectangular container bordered container
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    shape = RoundedCornerShape(16.dp),
                    backgroundColor = Color.White,
                    border =  BorderStroke(width = 2.dp, color = Color.Black)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Button(
                            onClick = { /* Handle button click */ },
                            modifier = Modifier
                                .size(8.dp)
                                .padding(8.dp)
                                .background(Color.Black, RoundedCornerShape(4.dp))
                        ) {
                            Text(text = "1",)
                        }
                        Spacer(modifier = Modifier.weight(1f))
                        Icon(
                            imageVector = Icons.Default.ArrowForward,
                            contentDescription = null,
                            tint = Color.Black
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
                                .background(Color.Gray, RoundedCornerShape(8.dp))
                                .padding(8.dp)
                        ) {
                            Column {
                                // Rounded image view
                                Box(
                                    modifier = Modifier
                                        .size(130.dp)
                                        .background(Color.White, CircleShape)
                                ) {
                                    // Image
                                }
                                Spacer(modifier = Modifier.height(4.dp))
                                // Live tag
                                Box(
                                    modifier = Modifier
                                        .background(Color.Red)
                                        .padding(4.dp)
                                ) {
                                    Text(
                                        text = "Live",
                                        color = Color.White,
                                        fontSize = 12.sp,
                                        modifier = Modifier.padding(4.dp)
                                    )
                                }
                            }
                        }
                        Spacer(modifier = Modifier.width(3.dp))
                    }
                }
            }

        },
        bottomBar = {
            s.skillvsme.presentation.homeScreen.navigation.BottomNavigation(navController = navController)
        }
    )
}

// Horizontal scrollable containers with
